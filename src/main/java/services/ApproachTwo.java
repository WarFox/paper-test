package services;

import java.util.List;

/**
 * deliver to each house in turn from west to east, regardless of which side of the road they are on
 */
public class ApproachTwo implements NewsPaperDeliveryScheme {

    public ApproachTwo(StreetSpecification streetSpecification) {
        super();
    }

    @Override
    public List<Integer> deliveryOrder() {

        return null;
    }

    @Override
    public long numberOfCrossings() {
        return 0;
    }

    @Override
    public String getName() {
        return "ApproachTwo";
    }


}
