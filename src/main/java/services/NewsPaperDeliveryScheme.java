package services;

import java.util.List;

public interface NewsPaperDeliveryScheme {

    List<Integer> deliveryOrder();

    long numberOfCrossings();

    String getName();
}
