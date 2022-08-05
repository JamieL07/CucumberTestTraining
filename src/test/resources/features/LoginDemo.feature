Feature: Test Login Functionality

  @smoketest
  Scenario Outline: Check login in successful with valid credentials
#    Given browser is open
#    And user is on login page
#    And user clicks on sign in
    Given user enters <username> and <password>
    When user clicks on login
    Then user is navigated to the home page
#    Then user closes the browser

    Examples:
      | username             | password        |


