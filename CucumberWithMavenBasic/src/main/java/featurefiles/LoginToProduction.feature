# When we don't want to run all the features at one go, we can use nnotations like @sanity,@smoke,@regression.
@bvt @prod
Feature: Login to production
  In order to perform a successful login into production
  As a user
  I want to enter correct username and correct password

  # When we have repeating steps in various Scenarios, we can use the Background to reduce the duplication.
  # Here the below steps are common for all the Scenarios.
  # --Given user navigates to facebook website
  # --When user validates the homepage title
  Background: 
    Given user navigates to facebook website
    When user validates the homepage title

  Scenario: In order to verify login to facebook production
    #Given user navigates to facebook website
    #When user validates the homepage title
    Then user entered the "valid" username
    And user entered the "valid" password
    And user validates the captcha image
    Then user "shouldbe" successfully logged in

  Scenario: In order to verify login to facebook production
    #Given user navigates to facebook website
    #When user validates the homepage title
    Then user entered the "invalid" username
    And user entered the "invalid" password
    And user validates the captcha image
    Then user "shouldnotbe" successfully logged in
