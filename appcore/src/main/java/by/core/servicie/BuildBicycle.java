package by.core.servicie;

import by.annotationbeans.AnnotationBeans;
import by.core.catalogs.BicycleClass;
import by.core.catalogs.Materials;
import by.core.dao.impl.BicycleDaoImpl;
import by.core.models.BicycleModel;

import org.springframework.test.context.ContextConfiguration;

import java.util.Random;

/**
 * Created by Denis on 16.08.2016.
 */
@ContextConfiguration(classes = {AnnotationBeans.class})
public class BuildBicycle {

    private BicycleDaoImpl bicycleDao;
    private BicycleModel bicycleModel;
    private String threadName = Thread.currentThread().getName();

    public BuildBicycle(BicycleDaoImpl bicycleDao) {
        this.bicycleDao = bicycleDao;
    }

    public void testSavingInToDB(int tName) {
        Random r = new Random();
        try {
            int sleepTime = r.nextInt(10);
            Thread.sleep(sleepTime);
            System.out.println("Bicycle saved in "+tName + " thread. It takes: " + sleepTime + " ms.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void createAndSaveBicToDB(){
        synchronized (this){
            populateBicycleModel();
            bicycleDao.saveBicycle(bicycleModel);
            System.out.println("Bicycle saved in "+threadName + " thread");
        }
    }

    private BicycleModel populateBicycleModel(){
        bicycleModel = new BicycleModel();
        bicycleModel.setProducerName("ProducerName_"+ threadName);
        bicycleModel.setWheelQuantity(2);
        bicycleModel.setWheelSize(26);
        bicycleModel.setReleaseYear(2016);
        bicycleModel.setBicycleClass(BicycleClass.ADULT);
        bicycleModel.setFrameMaterials(Materials.CHROM_MOLIBDEN_STEEL);

        return bicycleModel;
    }


//    public void setBicycleModel(BicycleModel bicycleModel) {
//        this.bicycleModel = bicycleModel;
//    }

}
