package by.core.servicie;

import by.core.vihicle.BaseVehicle;

/**
 * Created by Denis on 14.07.2016.
 */
public class TandemBicycle extends BaseVehicle {
    int seatsPlace;

    public int getSeatsPlace() {
        return seatsPlace;
    }

    public void setSeatsPlace(int seatsPlace) {
        this.seatsPlace = seatsPlace;
    }

    public TandemBicycle(int id, int wheelQuantity, String producerName, int releaseYear, String frameMaterial) {
        super(id, wheelQuantity, producerName, releaseYear, frameMaterial);
    }
}
