Feature: Login Demo with Background step

Background: User is logged in and on home page
Given User <username> is logged in

Scenario Outline: Test User is able to see save button
Then User is able to see save button 

Scenario: Test user is able to see logout button
Then User is able to see logout button


Examples: 
      | username |
      |Akash|

