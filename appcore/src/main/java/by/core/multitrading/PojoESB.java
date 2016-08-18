//package by.core.multitrading;
//
//import com.cg.hpp.enums.ResponseCode;
//import com.cg.hpp.esb.queue.RequestQueue;
//import com.cg.hpp.esb.response.ResponseCache;
//import com.cg.hpp.esb.result.ServiceResult;
//import com.cg.hpp.exception.ServiceProviderException;
//import com.cg.hpp.service.ServiceParams;
//import com.cg.hpp.service.ServiceProvider;
//import com.cg.hpp.service.business.BusinessService;
//import com.cg.hpp.service.response.GetStatusResponse;
//import com.cg.hpp.service.response.Response;
//import com.cg.hpp.utils.ServiceResultUtil;
//import org.apache.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import javax.annotation.PostConstruct;
//import java.util.Map;
//import java.util.UUID;
//
//
///** ESB implementation */
//public class PojoESB implements ESB, Runnable {
//
//    private static final Logger log=Logger.getLogger(PojoESB.class);
//
//    /** Waiting messages queue */
//    private RequestQueue waitingQueue;
//
//    /** Maps between service ID and a service provider */
//    private Map<String, ServiceProvider> serviceProviderMap;
//
//    /** Response message map */
//    //TODO prevent memory leak
//    @Autowired
//    private ResponseCache responseMessageMap;
//
//    private boolean startThread=false;
//
//    public void setServiceProviderMap(Map<String, ServiceProvider> serviceProviderMap) {
//        this.serviceProviderMap=serviceProviderMap;
//    }
//
//    @Override
//    public ResponseMessage send(Message message) {
//        ServiceResult res=null;
//        try{
//            res=process(message);
//        }catch (Exception e){
//            log.error("exception in invoke ESB", e);
//            res=new ServiceResult(ResponseCode.FAIL);
//            res.setDescription(e.getMessage());
//        }
//
//        return createResponseMessage(message, res);
//    }
//
//    /**
//     * Creates response message.
//     *
//     * @param message
//     * @param serviceResult
//     *
//     * @return
//     */
//    private ResponseMessage createResponseMessage(Message message, ServiceResult serviceResult) {
//        ResponseMessage responseMessage=new ResponseMessage();
//        responseMessage.setServiceId(message.getServiceId());
//        responseMessage.setResultCode(serviceResult.getResultCode());
//        responseMessage.setServiceResult(serviceResult);
//        return responseMessage;
//    }
//
//    @Override
//    public String post(Message message) throws Exception {
//        //Set request UUID
//        String uuid=UUID.randomUUID().toString();
//        message.setRequestUUID(uuid);
//
//        //Push to waiting queue
//        getMessageQueue().add(message);
//        pushNotification(message);
//        synchronized (waitingQueue){
//            waitingQueue.notify();
//        }
//
//        return uuid;
//    }
//
//    private void pushNotification(final Message message) {
//        final ServiceProvider pushNotificationService=serviceProviderMap.get("PUSH");
//        if (null==pushNotificationService){
//            log.error("Can't find pushNotificationService!");
//
//            return;
//        }
//        if (null==message.getServiceParams().getParam(ServiceParams.PNID)){
//            log.warn("can't find push notification id");
//
//            return;
//        }
//        ServiceParams serviceParams=new ServiceParams();
//        serviceParams.getAllParams().put(ServiceParams.MESSAGE, message);
//        try{
//            pushNotificationService.invoke("PUSH", serviceParams);
//        }catch (ServiceProviderException e){
//            log.error("Exception in pushNotificationService", e);
//        }
//    }
//
//    @Override
//    public Response getResult(final String key) {
//        ResponseMessage responseMessage=responseMessageMap.get(key);
//        Response result;
//        if (null==responseMessage){
//            result=new GetStatusResponse(ResponseCode.RESPONSE_NOT_FOUND, ServiceProviderException.RESPONSE_NOT_FOUND);
////            result.setStatus(1);
//            return result;
//        }
//
//        result=new GetStatusResponse(responseMessage.getResultCode(),"test processed");
////        result.setStatus(0);
////        result.setResult((Integer)ServiceResultUtil.getAttribute(responseMessage.getServiceResult(), "ecg_status"));
//        result.setTestId((Long)ServiceResultUtil.getAttribute(responseMessage.getServiceResult(), "testId"));
//        result.setTestType((Integer)ServiceResultUtil.getAttribute(responseMessage.getServiceResult(), "testType"));
//
//        return result;
//    }
//
//    /**
//     * Processes service.
//     *
//     * @param message
//     *
//     * @return
//     */
//    private ServiceResult process(Message message) {
//        ServiceProvider sp=serviceProviderMap.get(message.getServiceId());
//        ServiceResult serviceResult=null;
//        if (sp!=null){
//            log.info("Invoke service "+sp.getClass().getName()+" for serviceId:"+message.getServiceId());
//            try{
//                authorizeUser(message.getServiceParams(), message.getServiceId());
//                serviceResult=sp.invoke(message.getServiceId(), message.getServiceParams());
//            }catch (ServiceProviderException e){
//                log.error("exception in service! msg:"+e.getDescription(), e);
//
//                serviceResult=new ServiceResult();
//                serviceResult.setResultCode(e.getErrorCode());
//                if (null==serviceResult.getResultCode()){
//                    serviceResult.setResultCode(ResponseCode.FAIL);
//                }
//                serviceResult.setDescription(e.getDescription());
//                serviceResult.setServiceName(message.getServiceId());
//                serviceResult.setResultObject(e.getResultObject());
//            }
//        }else{
//            log.error("Service for serviceId:"+message.getServiceId()+" not found!");
//
//            serviceResult=new ServiceResult();
//            serviceResult.setResultCode(ResponseCode.SERVICE_NOT_FOUND);
//            serviceResult.setDescription("Service for id:"+message.getServiceId()+" not found");
//        }
//
//        return serviceResult;
//    }
//
//    private void authorizeUser(final ServiceParams serviceParams, final String serviceId) throws
//            ServiceProviderException {
////        Account account=(Account)serviceParams.getParam(ServiceParams.CURRENT_USER);
//
//        ServiceProvider securitySP=serviceProviderMap.get("CHECK_PERMISSIONS");
//        serviceParams.addParam(ServiceParams.SERVICE_ID, serviceId);
//        securitySP.invoke(BusinessService.CHECK_PERMISSIONS, serviceParams);
//    }
//
//    /**
//     * Store response into response map
//     *
//     * @param message
//     * @param res
//     */
//    private void putMessageResult(final Message message, final ServiceResult res) {
//        responseMessageMap.put(message.getRequestUUID(), createResponseMessage(message, res));
//    }
//
//    @Override
//    public void run() {
//        while (true){
//
//            if (waitingQueue.isEmpty()){
//                //Wait for incoming messages
//                try{
//                    synchronized (waitingQueue){
//                        waitingQueue.wait();
//                    }
//                }catch (InterruptedException e){
//                    break;
//                }
//            }
//
//            //Process message
//            Message message=null;
//            ServiceResult res;
//            try{
//                message=getMessageQueue().poll();
//                if (null!=message){
//                    res=process(message);
//
//                    //Store response
//                    putMessageResult(message, res);
//                }
//            }catch (Exception e){
//                log.error("exception in thread ProcessMessage", e);
//            }
//        }
//    }
//
//    private RequestQueue getMessageQueue() {
//        return waitingQueue;
//    }
//
//    @PostConstruct
//    public void afterPropertiesSet() throws Exception {
//        initializeAllServices();
//
//        this.waitingQueue=getMessageQueue();
//        if (startThread){
//            new Thread(this).start();
//        }
//    }
//
//    /** Initialize all services */
//    private void initializeAllServices() {
//        for (String serviceId : serviceProviderMap.keySet()){
//            ServiceProvider serviceProvider=serviceProviderMap.get(serviceId);
//            if (null==serviceProvider){
//                log.error("cant't get service with serviceId:"+serviceId);
//            }else{
//                serviceProvider.setEsb(this);
//            }
//        }
//    }
//
//
//    public void setWaitingQueue(final RequestQueue waitingQueue) {
//        this.waitingQueue=waitingQueue;
//    }
//
//    public void setStartThread(final boolean startThread) {
//        this.startThread=startThread;
//    }
//}
