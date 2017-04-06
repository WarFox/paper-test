Feature: Newspaper Delivery

  Scenario: ApproachOne
    Given the following street definition: 1,2,3,4,5,6,7
    And ApproachOne for delivering newpapers
    Then delivery will be done in the following order: 1,3,5,7,6,4,2
    And will cross the road one time

  Scenario: ApproachTwo
    Given the following street definition: 1,2,3,4,5,6,7
    And ApproachTwo for delivering newpapers
    Then delivery will be done in the following order: 1,2,3,4,5,6,7
    And will cross the road 6 times

  Scenario: ApproachTwo
    Given the following street definition: 1,2,4,6,8,3,5,7
    And ApproachTwo for delivering newpapers
    Then delivery will be done in the following order: 1,2,4,6,8,3,5,7
    And will cross the road 2 times
