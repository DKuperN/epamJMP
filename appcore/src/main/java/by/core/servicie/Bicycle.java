package by.core.servicie;

import by.core.vihicle.BaseVehicle;

/**
 * Created by Denis on 09.07.2016.
 */
public class Bicycle extends BaseVehicle {
    private int wheelSize;
    private String frameMaterial;
    private String bicycleClass;


    public Bicycle(int id, int wheelQuantity, String producerName, int releaseYear) {
        super(id, wheelQuantity, producerName, releaseYear);
    }

    public Bicycle(int id, int wheelQuantity, String producerName, int releaseYear, int wheelSize, String frameMaterial, String bicycleClass) {
        super(id, wheelQuantity, producerName, releaseYear);
        this.wheelSize = wheelSize;
        this.frameMaterial = frameMaterial;
        this.bicycleClass = bicycleClass;
    }

}
