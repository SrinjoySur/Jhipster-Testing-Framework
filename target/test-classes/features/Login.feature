Feature: Login Action
this will be setUp before all scenarios
this will be torn down after all scenarios
  Scenario Outline: Successful Login with Valid Credentials
    Given User navigates to Login Page
    When User enters Username "<username>", Password "<password>" and RememberMe "<rememberMe>":
    Then Page Title After Successfully Login In will be "Welcome, Java Hipster!"
Examples:
  | username | password | rememberMe|
  | admin    | admin    | true      |
  | user     | user     | true      |