Feature: Test Accessibility Page

  @Regression
  Scenario Outline: User Checks Accessibility Page
#    Given browser is open
#    And user is on login page
#    And user clicks on sign in
    Given user enters <username> and <password>
    And user clicks on login
    And user is navigated to the home page
    And user clicks on Accessibility Button
    Then Accessibility page is displayed
#    Then user closes the browser

    Examples:
      | username             | password        |


