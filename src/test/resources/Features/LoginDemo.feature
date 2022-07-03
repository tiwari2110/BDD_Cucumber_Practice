Feature: Test Login Functionality

  Scenario Outline: Check Login is successfull with valid credential
    Given Chrom Browser is open
    And user is on Test project login page
    When User enters <username> and <password>
    And user clicks on login button
    Then User is navigated to home page

    Examples: 
      | username | password |
      | Akash    |    12345 |
      | Rohit    |    12345 |
