package by.core.dao.impl;

import by.core.dao.IBaseDAO;
import by.core.models.BicycleModel;
import by.core.models.BikeEntity;

import java.lang.reflect.ParameterizedType;

/**
 * Created by Denis on 14.07.2016.
 */
public class BaseBicycleDaoImpl<E extends BikeEntity> implements IBaseDAO<E> {

    private Class<E> persistClass;

    public BaseBicycleDaoImpl() {
        if (getClass().getGenericSuperclass() instanceof ParameterizedType){
            this.persistClass=(Class<E>)((ParameterizedType)getClass().getGenericSuperclass())
                    .getActualTypeArguments()[0];
        }else{
            System.out.println("Something wrong in BaseBicycleDaoImpl");
        }
    }

    public void setPersistClass(Class<E> persistClass) {
        this.persistClass = persistClass;
    }

    @Override
    public Class<? extends BikeEntity> getPersistClass() {
        return null;
    }

    @Override
    public void save(Object entity) throws Exception {

    }

    @Override
    public void delete(E entity) {

    }

    @Override
    public void saveOrUpdate(E entity) {

    }

    @Override
    public void update(E entity) {

    }
}
