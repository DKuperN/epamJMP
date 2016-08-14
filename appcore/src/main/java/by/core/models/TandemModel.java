package by.core.models;

/**
 * Created by Denis on 24.07.2016.
 */
public class TandemModel extends BikeEntity {
    private int seatPlaces = 2;

    public int getSeatPlaces() {
        return seatPlaces;
    }

    public void setSeatPlaces(int seatPlaces) {
        this.seatPlaces = seatPlaces;
    }
}
