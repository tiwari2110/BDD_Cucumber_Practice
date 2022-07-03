Feature: Test Login Functionality using POM model

  Scenario Outline: Check Login is successfull with valid credential using page object model
    Given Chrome Browser is open
    And user is landed on Test project login page
    When into login form User enters <username> and <password>
    And user clicks on login button in form
    Then User is navigated to home page and able to see logout

    Examples: 
      | username | password |
      | Akash    |    12345 |
      | Rohit    |    12345 |
