package by.core.models;

import by.core.catalogs.BicycleClass;
import by.core.catalogs.Materials;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * Created by Denis on 09.07.2016.
 *
 * Entity for bicycle
 */
@Entity
public class BicycleModel {

    private int bicycle_id;
    private String producerName;
    private int wheelQuantity;
    private int wheelSize;
    private int releaseYear;

    @Enumerated(EnumType.STRING)
    private BicycleClass bicycleClass;

    @Enumerated(EnumType.STRING)
    private Materials frameMaterials;

    public BicycleModel(int bicycle_id, String producerName, int wheelQuantity, int wheelSize, int releaseYear, BicycleClass bicycleClass, Materials frameMaterials) {
        this.bicycle_id = bicycle_id;
        this.producerName = producerName;
        this.wheelQuantity = wheelQuantity;
        this.wheelSize = wheelSize;
        this.releaseYear = releaseYear;
        this.bicycleClass = bicycleClass;
        this.frameMaterials = frameMaterials;
    }

    public int getBicycle_id() {
        return bicycle_id;
    }

    public void setBicycle_id(int bicycle_id) {
        this.bicycle_id = bicycle_id;
    }

    public String getProducerName() {
        return producerName;
    }

    public void setProducerName(String producerName) {
        this.producerName = producerName;
    }

    public int getWheelQuantity() {
        return wheelQuantity;
    }

    public void setWheelQuantity(int wheelQuantity) {
        this.wheelQuantity = wheelQuantity;
    }

    public int getWheelSize() {
        return wheelSize;
    }

    public void setWheelSize(int wheelSize) {
        this.wheelSize = wheelSize;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public BicycleClass getBicycleClass() {
        return bicycleClass;
    }

    public void setBicycleClass(BicycleClass bicycleClass) {
        this.bicycleClass = bicycleClass;
    }

    public Materials getFrameMaterials() {
        return frameMaterials;
    }

    public void setFrameMaterials(Materials frameMaterials) {
        this.frameMaterials = frameMaterials;
    }
}
