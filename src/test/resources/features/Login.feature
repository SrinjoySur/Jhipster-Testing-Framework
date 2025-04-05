Feature: Login Action
Background:
  Given User navigates to Login Page
  Scenario Outline: Successful Login with Valid Credentials
    Then Page Title After Successfully Login In will be "Welcome, Java Hipster!"
    When User enters Username "<username>", Password "<password>" and RememberMe "<rememberMe>"
  Examples:
    | username | password | rememberMe|
    | admin    | admin    | true      |
    | user     | user     | true      |
    | admin    | admin    | false      |
    | user     | user     | false      |

    Scenario Outline:Restrict Login to Invalid Credentials
      When User enters Username "<username>", Password "<password>" and RememberMe "<rememberMe>"
      Then Page will display message "Failed to sign in!"
      Examples:
      | username | password | rememberMe |
      | admin    | user     | true       |
      | user     | admin    | false      |
      | admi n   | admin    | false      |