$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/SearchCars.feature");
formatter.feature({
  "name": "Acceptance Testing to validate that",
  "description": "\tthe search car option is working fine.\n\tIn order to validate that \n\tthe search car page is working fine\nWe will do the Acceptance Testing.",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@Search-Cars"
    }
  ]
});
formatter.scenario({
  "name": "Vaidate Search Cars page",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Search-Cars"
    },
    {
      "name": "@Search-Cars-Positive"
    }
  ]
});
formatter.step({
  "name": "I am on the homepage of \"https://www.carsguide.com.au/\" website",
  "keyword": "Given "
});
formatter.match({
  "location": "SearchCarsPositiveStep.i_am_on_the_homepage_of_website(String)"
});
formatter.result({
  "error_message": "java.lang.NullPointerException\r\n\tat utils.SeleniumDriverClass.openPage(SeleniumDriverClass.java:41)\r\n\tat steps.SearchCarsPositiveStep.i_am_on_the_homepage_of_website(SearchCarsPositiveStep.java:21)\r\n\tat ✽.I am on the homepage of \"https://www.carsguide.com.au/\" website(src/test/resources/features/SearchCars.feature:10)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "I move my cursor on menu bar",
  "rows": [
    {
      "cells": [
        "Menu"
      ]
    },
    {
      "cells": [
        "buy + sell"
      ]
    },
    {
      "cells": [
        "reviews"
      ]
    },
    {
      "cells": [
        "news"
      ]
    },
    {
      "cells": [
        "advice"
      ]
    },
    {
      "cells": [
        "pricing + specs"
      ]
    }
  ],
  "keyword": "When "
});
formatter.match({
  "location": "SearchCarsPositiveStep.i_move_my_cursor_on_menu_bar(String\u003e)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "I click on Search Cars linktext",
  "keyword": "Then "
});
formatter.match({
  "location": "SearchCarsPositiveStep.i_click_on_Search_Cars_linktext()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "I select make as \"BMW\" from CarMaker dropdown",
  "keyword": "And "
});
formatter.match({
  "location": "SearchCarsPositiveStep.i_select_make_from_CarMaker_dropdown(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "I select the model as \"1 SERIES\" from CarModel dropdown",
  "keyword": "And "
});
formatter.match({
  "location": "SearchCarsPositiveStep.i_select_the_model_from_CarModel_dropdown(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "I select the location as \"Australia\" from CarLocation dropdown",
  "keyword": "And "
});
formatter.match({
  "location": "SearchCarsPositiveStep.i_select_the_location_from_CarLocation_dropdown(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "I select price as \"$10,000\" from CarPrice dropdown",
  "keyword": "And "
});
formatter.match({
  "location": "SearchCarsPositiveStep.i_select_price_from_CarPrice_dropdown(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "I click on Find_My_Next_Car button",
  "keyword": "And "
});
formatter.match({
  "location": "SearchCarsPositiveStep.i_click_on_Find_My_Next_Car_button()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "I should see the list of searched cars",
  "keyword": "Then "
});
formatter.match({
  "location": "SearchCarsPositiveStep.i_should_see_the_list_of_searched_cars()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "The page title should be \"Bmw 1 Series Under 10000 for Sale | carsguide\"",
  "keyword": "And "
});
formatter.match({
  "location": "SearchCarsPositiveStep.the_page_title_should_be(String)"
});
formatter.result({
  "status": "skipped"
});
});