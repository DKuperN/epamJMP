package by.core.models;

import by.core.catalogs.BicycleClass;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * Created by Denis on 09.07.2016.
 *
 * Entity for bicycle
 */
@Entity
public class Bicycle {

    private int id;
    private String producerName;
    private int wheelQuantity;
    private int wheelSize;
    private int releaseYear;

    @Enumerated(EnumType.STRING)
    private BicycleClass bicycleClass;

    private int yearOfCreate;


}
