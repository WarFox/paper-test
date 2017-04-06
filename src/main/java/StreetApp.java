import models.Street;
import services.ApproachOne;
import services.ApproachTwo;
import services.NewsPaperDeliveryScheme;
import services.StreetSpecification;

import java.util.List;

public class StreetApp implements App {

    private final StreetSpecification streetSpecification;

    public StreetApp(List<Integer> houses) {
        final Street street = new Street(houses);
        this.streetSpecification = new StreetSpecification(street);
    }

    public void printStreetInfo() {
        printIfValid(streetSpecification);
        printNumberOfHousesInTheStreet(streetSpecification);
        printNumberOfHousesInTheNorth(streetSpecification);
        printNumberOfHousesIntheSourth(streetSpecification);
    }

    public void printDeliverySchemes() {
        NewsPaperDeliveryScheme schemeOne = new ApproachOne(streetSpecification);
        NewsPaperDeliveryScheme schemeTwo = new ApproachTwo(streetSpecification);
        printDeliveryScheme(schemeOne);
        printDeliveryScheme(schemeTwo);
    }

    public void printDeliveryScheme(NewsPaperDeliveryScheme deliveryScheme) {
        System.out.println("----------------");
        System.out.println("Delivery approach name: " + deliveryScheme.getName());
        System.out.println("Delivery Order: " + deliveryScheme.deliveryOrder());
        System.out.println("Number of crossings: " + deliveryScheme.numberOfCrossings());
    }

    public void printIfValid(StreetSpecification streetSpecification) {
        System.out.println("StreetSpecification is valid " + streetSpecification.isValid());
    }

    public void printNumberOfHousesInTheStreet(StreetSpecification streetSpecification) {
        System.out.println("Number of houses in the street " + streetSpecification.numberOfHouses());
    }

    public void printNumberOfHousesInTheNorth(StreetSpecification streetSpecification) {
        System.out.println("Number of houses in the left hand side " + streetSpecification.numberOfHousesInLeftHandSide());
    }

    public void printNumberOfHousesIntheSourth(StreetSpecification streetSpecification) {
        System.out.println("Number of houses in the right hand side " + streetSpecification.numberOfHousesInRightHandSide());
    }

    @Override
    public void process() {
        this.printStreetInfo();
        if (streetSpecification.isValid()) {
            this.printDeliverySchemes();
        } else {
            System.out.println("Street is not valid, so cannot deliver newspapers!");
        }
    }
}
