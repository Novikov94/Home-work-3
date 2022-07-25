Feature: Smoke
  As a user
  I want to test all main site functionality
  So that I can be sure that site works correctly

Scenario Outline: error message is displayed upon registration with invalid email pattern

Given Github '<homePage>' is opened
When user enters “invalid123” into email field
Then error message below email field should be displayed

  Examples:
    | homePage          |
    | https://github.com|


Scenario Outline: message under password field indicates a completeness of password requirements

Given Github '<homePage>' is opened
When user enters “AAA” into password field
Then “at least 15 characters” message should be marked red
And “a lowercase letter” message should be marked red
When user enters “AAAaaa” into password field
Then “at least 15 characters” message should be marked red

  Examples:
    | homePage          |
    | https://github.com|


Scenario Outline: error message is displayed upon registration with already existent username

Given Github '<homePage>' is opened
And at least one username is already registered in application
When user enters already existent username into username field
Then error message below username field should be displayed
And suggested usernames in error message contains the username entered

  Examples:
    | homePage          |
    | https://github.com|