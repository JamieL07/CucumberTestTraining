Feature: Test Login Functionality

  Scenario Outline: Check login in successful with valid credentials
    Given browser is open
    And user is on login page
    And user clicks on sign in
    When user enters <username> and <password>
    And user clicks on login
    Then user is navigated to the home page

    Examples:
      | username             | password        |
