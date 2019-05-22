@Search-Cars
Feature: Acceptance Testing to validate that the search car
  option is working fine
  In order to validate that 
  the search car page is working fine
  We will do the Acceptance Testing

  @Search-Cars-Positive
  Scenario: Vaidate Search Cars page
    Given I am on the homepage of "https://www.carsguide.com.au/" website
    When I move my cursor on menu bar
      | Menu            |
      | buy + sell      |
      | reviews         |
      | news            |
      | advice          |
      | pricing + specs |
    Then I click on Search Cars linktext
    And I select make as "BMW" from CarMaker dropdown
    And I select the model as "1 Series" from CarModel dropdown
    And I select the location as "ACT - All" from CarLocation dropdown
    And I select price as "$10,000" from CarPrice dropdown
    And I click on Find_My_Next_Car button
    Then I should see the list of searched cars
    And The page title should be "Bmw 1 Series for Sale ACT | carsguide"
