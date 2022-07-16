Feature: Test Login Functionality using Page factory model

  Scenario Outline: Check Login is successfull with valid credential using page factory model
    Given Page factory Chrome Browser is open
    And Page factory user is landed on Test project login page
    When Page factory into login form User enters <username> and <password>
    And Page factory user clicks on login button in form
    Then Page factory User is navigated to home page and able to see logout

    Examples: 
      | username | password |
      | Rohit    |    12345 |
