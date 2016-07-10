package by.core.dao;

import by.core.models.BicycleModel;

import java.util.List;

/**
 * Created by Denis on 09.07.2016.
 */
public interface BicycleDAO {
    void saveBicycle(BicycleModel bicycleModel);
    void updateBicycle(BicycleModel bicycleModel);
    BicycleModel getBicycle(int id);
    List<BicycleModel> getAllBicycles();
    void deleteBicycle(int id);
}
