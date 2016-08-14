package by.core.servicie;

import by.core.vihicle.BaseVehicle;

/**
 * Created by Denis on 09.07.2016.
 */
public class StandartBicycle extends BaseVehicle {
    private int wheelSize;
    private String bicycleClass;


    public StandartBicycle(int id, int wheelQuantity, String producerName, int releaseYear, String frameMaterial) {
        super(id, wheelQuantity, producerName, releaseYear, frameMaterial);
    }

    public int getWheelSize() {
        return wheelSize;
    }

    public void setWheelSize(int wheelSize) {
        this.wheelSize = wheelSize;
    }

    public String getBicycleClass() {
        return bicycleClass;
    }

    public void setBicycleClass(String bicycleClass) {
        this.bicycleClass = bicycleClass;
    }
}
