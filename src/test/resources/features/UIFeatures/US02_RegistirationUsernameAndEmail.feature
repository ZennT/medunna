@UIRegistrationPage @smoke @UIHome
Feature: registration feature

  Background: user is on the registration page
    Given user is on homepage
    Given user clicks sign in register dropdown button
    And user clicks register button
    And user is on registration page and verifies


  @UIRegistration_US002_TC0001_TC0006
  Scenario Outline: positive testing with all valid credentials
    And user provides ssn id "<ssn>"
    Then user provides firstname and lastname "<firstname>" and "<lastname>"
    And user provides username "<username>"
    And user provides email "<email>"
    And user provides the password "<password>"
    And user registers and validates data generation
    Then user sets the data in correspondent files
    Examples:
      | ssn         | firstname | lastname | username    | email           | password   |
      | 170-98-8790 | New User  | last     | hel.ly_can1 | molly6@gmail.com | mollyA123. |

  @UIRegistration_US002_TC0005 @smoke
  Scenario Outline: user should not able register with Username that already used
    And user provides ssn id "<ssn>"
    Then user provides firstname and lastname "<firstname>" and "<lastname>"
    And user provides username that already used "<username>"
    And user provides email "<email>"
    And user provides the password "<password>"
    And user verifies that username already used
    Then capture the screenshot
    Then user sets the data in correspondent files
    Examples:
      | ssn         | firstname | lastname | username    | email         | password |
      | 387-98-8790 | New       | name     | hel.ly_can1 | mol@gmail.com | newA123. |


  @UIRegistration_US002_TC_0011
  Scenario Outline: user should not able register with Email that already used
    And user provides ssn id "<ssn>"
    Then user provides firstname and lastname "<firstname>" and "<lastname>"
    And user provides username "<username>"
    And user provides already used email "<email>"
    And user provides the password "<password>"
    And user verifies that email already used
    Then capture the screenshot
    Then user sets the data in correspondent files
    Examples:
      | ssn         | firstname | lastname | username       | email            | password |
      | 387-98-8790 | Newt      | nameff   | hello.ly5_can1 | molly6@gmail.com | nttA123. |



  @UIRegistrationNegativeTesting_US002_TC0002
  Scenario: user should not able to register with invalid Username
    Given user provides space in username
    And user should see Your username is invalid. text visible and verifies
    And capture the screenshot
    Then close the application



  @UIRegistration_US002_TC0004 @smoke
    Scenario: user should not leave username blank
    And user leaves blank for username of the applicant
    And verifies Your username is required. text visible



  @UIRegistrationNegativeTestingTC_0007_TC_0008_TC_0009_TC_0010
 Scenario Outline: user should not able to register with invalid EmailAddress
    Given user provides invalid "<invalid emailAddress>" and click enter
    And verifies This field is invalid text visible
    And user leaves blank for emailAddress of the applicant
    And verifies Your email is required. text visible
    Then close the application
    Examples:
      | invalid emailAddress |
      | mollygmail.com       |
      | molly@gmail          |
      | mollygmail           |

