Feature: Login Action

  Scenario: Successful Login with Valid Credentials
    Given User is on Home Page
    When User Navigate to LogIn Page
    And User enters Username <username>, Password <password> and RememberMe<rememberMe>:
    | username | password | rememberMe|
    | admin    | admin    | true      |
    | user     | user     | true      |
    Then Message displayed Login Successfully
