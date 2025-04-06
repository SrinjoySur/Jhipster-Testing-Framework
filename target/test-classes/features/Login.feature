Feature: Login Action
Background:
  Given User navigates to Login Page
  Scenario Template: Successful Login with Valid Credentials
    When User enters Username "<username>", Password "<password>" and RememberMe "<rememberMe>"
    Then Page Title After Successfully Login In will be "Welcome, Java Hipster!"
  Examples:
    | username | password | rememberMe|
    | admin    | admin    | true      |
    | user     | user     | true      |
    | admin    | admin    | false      |
    | user     | user     | false      |

    Scenario Template:Restrict Login to Invalid Credentials
      When User enters Username "<username>", Password "<password>" and RememberMe "<rememberMe>"
      Then Page will display message "Failed to sign in!"
      Examples:
      | username | password | rememberMe |
      | admin    | user     | true       |
      | user     | admin    | false      |
      | admi n   | admin    | false      |
      | user     |u ser     | true       |