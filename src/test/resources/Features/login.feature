Feature: Feature to test login functionality

  @Smoke
  Scenario: Check login is successfull with valid credentials
    Given User is on login page
    When user enters username and password
    And clicks on login button
    Then user is navigated to the home page

