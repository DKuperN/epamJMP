package by.core.models;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Denis on 24.07.2016.
 */
@MappedSuperclass
public abstract class BikeEntity implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.TABLE, generator = "bike_")
    @TableGenerator(name = "bike_", allocationSize = 1)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id=id;
    }

}
