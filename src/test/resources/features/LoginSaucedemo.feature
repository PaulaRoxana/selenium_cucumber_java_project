Feature: Login tests

  Background: Open page
    Given The User is on "Login Page"

# SMOKE (HAPPY FLOW) -> 1TC
 @SmokeTest
  Scenario Outline: Login with correct Username and correct Password
    When User enters "<correctUsername>" and "<correctPassword>" on "Login Page"
    Then User is navigated on "Home Page"
    Examples:
      | correctUsername | correctPassword |
      | standard_user   | secret_sauce    |
      | locked_out_user | secret_sauce    |
      | problem_user    | secret_sauce    |



# NEGATIVE TESTING (error handling) -> 3TCs
@NegativeTest
  Scenario Outline: Login with incorrect Username or incorrect Password
    When User enters incorrect "<username>" and-or incorrect "<password>" on "Login Page"
    Then Validate the error message for incorrect Username and-or incorrect Password
    Examples:
      | username        | password          |
# correct username / incorrect password
      | standard_user   | secret            |
      | locked_out_user | 1                 |
# incorrect username / correct password
      | problem         | secret_sauce      |
      | performance     | secret_sauce      |
# incorrect username / incorrect password
      | 1234              | =               |
      | dgtshx            | 643w654w654w    |

  @NegativeTest
  Scenario Outline: (Try to) login with missing Username
    When User enters no "<username>" and "<password>" on "Login Page"
    Then Validate the error message for missing Username is correct
    Examples:
      | username        | password     |
      |                 | =            |
      |                 | secret_sauce |

  Scenario Outline: (Try to) login with missing Password
    When User enters "<username>" and no "<password>" on "Login Page"
    Then Validate the error message for missing Password is correct
    Examples:
      | username                | password        |
      | performance_glitch_user |                 |
      | 123nvx                  |                 |