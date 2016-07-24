package by.core.vihicle;

/**
 * Created by Denis on 09.07.2016.
 */
public abstract class BaseVehicle {
    private int id;
    private int wheelQuantity;
    private String producerName;
    private int releaseYear;
    private String frameMaterial;

    public BaseVehicle(int id, int wheelQuantity, String producerName, int releaseYear, String frameMaterial) {
        this.id = id;
        this.wheelQuantity = wheelQuantity;
        this.producerName = producerName;
        this.releaseYear = releaseYear;
        this.frameMaterial = frameMaterial;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWheelQuantity() {
        return wheelQuantity;
    }

    public void setWheelQuantity(int wheelQuantity) {
        this.wheelQuantity = wheelQuantity;
    }

    public String getProducerName() {
        return producerName;
    }

    public void setProducerName(String producerName) {
        this.producerName = producerName;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getFrameMaterial() {
        return frameMaterial;
    }

    public void setFrameMaterial(String frameMaterial) {
        this.frameMaterial = frameMaterial;
    }
}
