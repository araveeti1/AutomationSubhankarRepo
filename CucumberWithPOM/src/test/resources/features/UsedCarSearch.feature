@Used-Cars-Search
Feature: Acceptance Testing to validate that the used car search
  option is working fine
  In order to validate that 
  the used car search page is working fine
  We will do the Acceptance Testing

  @Used-Cars-Search-Positive
  Scenario: Vaidate Used Cars search page
    Given I am on the homepage of "https://www.carsguide.com.au/" website
    When I move my cursor on menu bar
      | Menu            |
      | buy + sell      |
      | reviews         |
      | news            |
      | advice          |
      | pricing + specs |
    Then I click on Used linktext
    And I select make as "Audi" from CarMaker dropdown
    And I select the car model
      | carModel |
      | A1       |
      | A3       |
      | A4       |
      | A5       |
    And I select the location as "ACT - All" from CarLocation dropdown
    And I select price as "$10,000" from CarPrice dropdown
    And I click on Find_My_Next_Car button
    Then I should see the list of searched cars
    And The page title should be "Used Audi A1 for sale ACT | carsguide"
