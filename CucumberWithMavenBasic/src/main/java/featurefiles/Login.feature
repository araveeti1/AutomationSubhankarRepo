# When we don't want to run all the features at one go, we can use nnotations like @sanity,@smoke,@regression.
@sanity @prod1
Feature: In order to perform a successful login
  As a user
  I want to enter correct username and correct password

  Scenario Outline: In order to verify login to facebook
    Given user navigates to facebook website
    When user validates the homepage title
    Then user entered the "<username>" username
    And user entered the "<password>" password
    And user selects the age category
      | Age      | Location |
      | Below 18 | India    |
      | Above 18 | USA      |
    Then user "<loginType>" successfully logged in

    # We can write multiple scenarios over here again and again.
    # But instead of that, we can parameterize the scenarios as below.
    Examples: 
      | username | password | loginType   |
      | valid    | valid    | shouldbe    |
      | invalid  | invalid  | shouldnotbe |
