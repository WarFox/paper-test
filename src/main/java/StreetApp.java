import models.Street;
import services.StreetSpecification;

import java.util.List;

public class StreetApp {

    private final StreetSpecification streetSpecification;

    public StreetApp(List<Integer> houses) {
        final Street street = new Street(houses);
        this.streetSpecification = new StreetSpecification(street);
    }

    public void printOutput() {
        printIfValid(streetSpecification);
        printNumberOfHousesInTheStreet(streetSpecification);
        printNumberOfHousesInTheNorth(streetSpecification);
        printNumberOfHousesIntheSourth(streetSpecification);
    }

    public void printIfValid(StreetSpecification streetSpecification) {
        System.out.println("StreetSpecification is valid " + streetSpecification.isValid());
    }

    public void printNumberOfHousesInTheStreet(StreetSpecification streetSpecification) {
        System.out.println("Number of houses in the street " + streetSpecification.numberOfHouses());
    }

    public void printNumberOfHousesInTheNorth(StreetSpecification streetSpecification) {
        System.out.println("Number of houses in the north " + streetSpecification.numberOfHousesInNorth());
    }

    public void printNumberOfHousesIntheSourth(StreetSpecification streetSpecification) {
        System.out.println("Number of houses in the south " + streetSpecification.numberOfHousesInSouth());
    }

}
