@user_setting_page
Feature: user setting feature

  Scenario Outline: Sign in with username and password
    Given user on the Medunna Sign in  Page
    And user enters username "<username>"
    And user enters password  "<password>"
    And user clicks sign in button

    Examples:
      |username   |password |
      |C.hernandez|123456   |



    Scenario: negative test case
      And firstname should not be blank
      And lastname should not be blank
      And e-mail should not be created without @ sign and . extension
      And email should not be blank


  Scenario: positive test case
    Given user click on setting page
    And user verify Name
    And user verify Lastname
    And user verify Email
