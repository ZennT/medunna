@register @smoke @regression
Feature:test all registrant data
  @UIHome
  Scenario Outline: US001_01 test multiple test data for registrant positive test
    Given user verifies on home page
    Given user clicks sign in register dropdown button
    And user clicks register button
    And user provides ssn id "<ssn>"
    And user provides firstname and lastname "<firstname>" and "<lastname>"
    And user provides username "<username>"
    And user provides email "<email>"
    And user provides the password "<password>"
    Then user registers and validates data generation
    Then capture the screenshot
    Then user sets the data in correspondent files

    Examples: user info
      |ssn|firstname|lastname|username|email|password|
      |883-05-6700|Sema|last|tea908797|ke778arim5@gmail.com|Util123.|

  @UIRegistration
  Scenario Outline: test multiple test data for registrant ssn validation
    Given verify land on registration page
    And user enters already used ssn number "<ssn>"
    And user provides firstname and lastname "<firstname>" and "<lastname>"
    And user provides username "<username>"
    And user provides email "<email>"
    And user provides the password "<password>"
    Then capture the screenshot
    Then user clicks register button and validate ssn id already registered

    Examples: user info
      |ssn|firstname|lastname|username|email|password|
      |883-05-6705|Ela|last|team101|kalinm5@gmail.com|Utilisateur123.|


  @UIRegistration
  Scenario Outline: register with invalid ssn
    Given user enters invalid ssn number "<ssn>" and clicks enter
    And verify your ssn is invalid text visible
    Examples: user info
      |ssn        |
      |999-66-3456|
      |000-90-9090|
      |189-65-78k?|
      |189657890  |
      |34567-67-90|
      |123-45-789 |

  @UIRegistration
  Scenario:  register with blank ssn
    Given user leaves ssn textbox blank
    And verify your ssn is required visible

  @UIRegistration
  Scenario: register with blank firstname
    Given user leaves firstname textbox blank and press enter
    And verify your name is required visible

  @UIRegistration
  Scenario: register with blank lastname
    Given user leaves lastname textbox blank and press enter
    And verify your lastname is required visible

  @UIRegistration
  Scenario: register with blank password
    Given user leaves password blank and press enter
    And verify your password is required visible

  @UIRegistration
  Scenario: register with blank confirmation password
    Given user leaves  confirmation password blank and press enter
    And verify your confirmation password is required visible

  @UIRegistration
  Scenario Outline: register with invalid password
    And user provides the new password "<password>"
    And verify password length less than the specified range in password
    Examples: password info
      |password|
      |123|
      |abc|
      |Ab?|

  @UIRegistration
  Scenario Outline: register with invalid password confirmation password
    And user provides the password confirmation "<passwordConfirmation>"
    And verify password confirmation length less than the specified range in password
    Examples: password info
      |passwordConfirmation|
      |123|
      |abc|
      |Ab?|

  @UIRegistration
  Scenario Outline: user should not enter the characters more than the specified range password
    Given user provides the new password "<password>"
    And verify user cannot enter the characters more than the specified range
    Examples: password info
      |password|
      |123456789012345678909........|

    @UIRegistration
    Scenario Outline: Password at least 7 characters long and contains two different char for a stronger password
      Given user provides the new password "<password>"
      Then user validate the password strength "<level strength>"
      Then capture the screenshot
      Examples: password info
        |password   |level strength |
        |Asd12.     |1              |
        |Asd12..    |4              |
        |Ab1.       |1              |
        |password   |1              |
        |password1  |2              |
        |password+  |2              |
        |password1+ |3              |
        |PASSWORD   |1              |
        |PASSWORd   |2              |
        |PASSWORD12 |2              |
        |Password   |2              |
        |Password1  |3              |
        |Password1+ |4              |
        |aaaaaaA    |2              |
        |123456U    |2              |
        |..??@.U    |2              |
        |12345678   |1              |
        |......a    |2              |
        |123456a    |2              |
        |...1234    |2              |


  #failed-expected result and actual result not same
   @UIRegistration
  Scenario Outline: Password at least 7 characters long and two different char for a stronger password bug
    Given user provides the new password "<password>"
    Then user validate the password strength "<level strength>"
    Then capture the screenshot
    Examples: password info
      |password   |level strength |
      |1234567@   |2              |
      |aaaaaaa#   |2              |
      |aaaaaaa@#  |2              |
      |2222 2222  |2              |




  @UIRegistration
  Scenario Outline: test password confirmation
    Given user provides the new password "<password>"
    And  user provides the password confirmation "<passwordConfirmation>"
    Examples:
      |password |passwordConfirmation |
      |medunna  |medunna              |


  @UIRegistration
  Scenario Outline: test password confirmation negative
    Given user provides the new password "<password>"
    And user provides the password confirmation "<passwordConfirmation>"
    And verify the password and its confirmation do not match message
    Examples:
      |password |passwordConfirmation |
      |medunna567  |medunna5          |


