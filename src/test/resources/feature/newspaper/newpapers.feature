Feature: Newspaper Delivery

  Scenario: ApproachOne
    Given the following street definition: 1,2,3,4,5,6,7
    And ApproachOne for delivering newpapers
    Then delivery will be done in the following order: 1,3,5,7,6,4,2
    And they will cross the road one time

  Scenario: ApproachTwo
    Given the following street definition: 1,2,3,4,5,6,7
    And ApproachTwo for delivering newpapers
    Then delivery will be done in the following order: 1,2,3,4,5,6,7
    And they will cross the road 6 times
