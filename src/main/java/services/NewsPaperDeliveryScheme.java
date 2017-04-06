package services;

import java.util.List;

public interface NewsPaperDeliveryScheme {

    List<Integer> deliveryOrder();

    int numberOfCrossings();

    String getName();
}
