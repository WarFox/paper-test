package feature.newspaper;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import models.Street;
import services.ApproachOne;
import services.ApproachTwo;
import services.NewsPaperDeliveryScheme;
import services.StreetSpecification;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class NewspaperDeliveryStepsDef {

    private StreetSpecification streetSpecification;
    private NewsPaperDeliveryScheme deliveryScheme;

    @Given("the following street definition: (.*)")
    public void given_the_following_street_definition(List<Integer> houseNumbers) {
        final Street street = new Street(houseNumbers);
        this.streetSpecification = new StreetSpecification(street);
    }

    @And("^ApproachOne for delivering newpapers$")
    public void and_approach_one_for_delivering_newspapers() throws Throwable {
        this.deliveryScheme = new ApproachOne(streetSpecification);
    }

    @And("^ApproachTwo for delivering newpapers$")
    public void and_approach_two_for_delivering_newspapers() throws Throwable {
        this.deliveryScheme = new ApproachTwo(streetSpecification);
    }

    @Then("^delivery will be done in the following order: (.*)$")
    public void then_delivery_will_be_done_in_the_following_order(List<Integer> houseNumbers) throws Throwable {
        final List<Integer> deliveryOrder = deliveryScheme.deliveryOrder();
        assertThat(deliveryOrder).isEqualTo(houseNumbers);
    }

    @And("^they will cross the road one time$")
    public void and_they_cross_the_road_one_time() throws Throwable {
        assertThat(deliveryScheme.numberOfCrossings()).isEqualTo(1);
    }

    @And("^they will cross the road (\\d+) times$")
    public void and_they_cross_the_road_n_times(int n) throws Throwable {
        assertThat(deliveryScheme.numberOfCrossings()).isEqualTo(n);
    }

}
