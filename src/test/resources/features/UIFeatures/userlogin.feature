@UIlogin @SmokeTest

Feature: user login feature

  @UIlogin_positive_1
  Scenario Outline: login_with_user_credentials

    Given user is on the login page
    And user clicks on login dropdown icon
    And user clicks on sign in dropdown
    And user sends username "<username>"
    And user sends password "<password>"
    Then user clicks on the sign in dropdown
    Then verify the login is successful
    And user clicks on login dropdown icon
    Then user clicks on sign out

    Examples: credentials
      |username |password |
      |admin79  | admin   |


  @UIlogin_negative_2

  Scenario Outline: login_with_user_credentials

    Given user is on the login page
    And user clicks on login dropdown icon
    And user clicks on sign in dropdown
    And user sends username "<username>"
    And user sends invalid password "<password>" or invalid username "<username>"
    Then user clicks on the sign in dropdown
    Then verify the error message
    Then user clicks on the cancelButton

    Examples: credentials
      |username |password |
      |admin79  |Admin    |
      |admin80  |admin    |

  @UIlogin_negative_3

  Scenario Outline:login_with_updating_email

    Given user is on the login page
    And user clicks on login dropdown icon
    And user clicks on sign in dropdown
    And user sends username "<username>"
    And user sends invalid password "<password>"
    And user clicks on the didYouForgetPassword button
    Then verify enter the email address  message
    And user enters newEmail "<email>"
    And user clicks on the resetPassword button
    Then user should see the newMessage

    Examples: credentials
      |username |password |email        |
      |admin79  |Admin    |chnbul@gmail.com|


  @UIlogin_positive_4
  Scenario: login_with_cancel

    Given user is on the login page
    And user clicks on login dropdown icon
    And user clicks on sign in dropdown
    And user sends username "<username>"
    And user sends password "<password>"
    And user clicks on the cancelButton
    Then verify the login is successful

  @UIlogin_positive_5
  Scenario: login_with_remembering

    Given user is on the login page
    And user clicks on login dropdown icon
    And user clicks on sign in dropdown
    And user sends username "<username>"
    And user sends password "<password>"
    And User  enter before rememberMe button
    Then user clicks on the cancelButton

  @UIlogin_positive_6
  Scenario: login_with_new_account
    Given user is on the login page
    And user clicks on login dropdown icon
    And user clicks on sign in dropdown
    Then user see registerNewAccount button


  @UIlogin_positive_7
  Scenario Outline:  login_with_new_cancel
    Given user is on the login page
    And user clicks on login dropdown icon
    And user clicks on sign in dropdown
    And user sends username "<username>"
    And user sends password "<password>"
    Then user clicks on the sign in dropdown
    Then user clicks on the cancelButton
    Then verify the login is successful
    Examples: credentials
      |username |password  |
      |WadeLakin|cD5uV$#0#!|


