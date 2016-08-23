package by.core.dao;

import by.core.models.BicycleModel;
import by.core.models.BikeEntity;

/**
 * Created by Denis on 14.07.2016.
 * Normal bicycles DAO
 */
public interface IBaseDAO<E extends BikeEntity> {

    Class<? extends BikeEntity> getPersistClass();

    /**
     * Save entity
     * @param entity entity
     */
    void save(Object entity) throws Exception;

    /**
     * Delete entity
     * @param entity entity
     */
    void delete(E entity);

    /**
     * Update entity
     * @param entity entity
     */
    void saveOrUpdate(E entity);

    /**
     * Update entity
     * @param entity
     */
    void update(E entity);

}
