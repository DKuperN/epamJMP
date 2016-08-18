package by.core.models;

import by.core.catalogs.BicycleClass;
import by.core.catalogs.Materials;
import org.springframework.beans.factory.annotation.Required;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * Created by Denis on 09.07.2016.
 *
 * BikeEntity for bicycle
 */
@Entity
public class BicycleModel extends BikeEntity {

    private String producerName;
    private int wheelQuantity;
    private int wheelSize;
    private int releaseYear;

    @Enumerated(EnumType.STRING)
    private BicycleClass bicycleClass;

    @Enumerated(EnumType.STRING)
    private Materials frameMaterials;

    public BicycleModel() {
    }

    public BicycleModel(String producerName, int wheelQuantity, int wheelSize, int releaseYear, BicycleClass bicycleClass, Materials frameMaterials) {
        this.producerName = producerName;
        this.wheelQuantity = wheelQuantity;
        this.wheelSize = wheelSize;
        this.releaseYear = releaseYear;
        this.bicycleClass = bicycleClass;
        this.frameMaterials = frameMaterials;
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
