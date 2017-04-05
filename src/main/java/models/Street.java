package models;

import java.util.ArrayList;
import java.util.List;

/**
 * Street is immutable
 */
public class Street {

    private final List<Integer> houseNumbers;

    public Street(List<Integer> houses) {
        this.houseNumbers = houses;
    }

    public List<Integer> getHousesNumbers() {
        return new ArrayList<>(houseNumbers);
    }

}
