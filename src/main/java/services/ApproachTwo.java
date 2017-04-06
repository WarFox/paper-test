package services;

import utils.NumberUtils;

import java.util.List;

/**
 * deliver to each house in turn from west to east, regardless of which side of the road they are on
 */
public class ApproachTwo implements NewsPaperDeliveryScheme {

    private final StreetSpecification streetSpecification;

    public ApproachTwo(StreetSpecification streetSpecification) {
        this.streetSpecification = streetSpecification;
    }


    @Override
    public List<Integer> deliveryOrder() {
        return streetSpecification.getHousesNumbers();
    }

    @Override
    public int numberOfCrossings() {
        int previousNumber = streetSpecification.getHousesNumbers().get(0);
        int numberOfCrossings = 0;
        for (Integer houseNumber : streetSpecification.getHousesNumbers()) {
            if (NumberUtils.isEven(previousNumber) ^ NumberUtils.isEven(houseNumber)) {
                numberOfCrossings++;
            }
            previousNumber = houseNumber;
        }
        return numberOfCrossings;
    }

    @Override
    public String getName() {
        return "ApproachTwo";
    }


}
