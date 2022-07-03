Feature: Feature to test google search function

  Scenario: Validate google search is working
    Given Browser is open
    And user is on google search page
    When user enter tet in search box
    And Hit Enter
    Then user is navigated to search result
