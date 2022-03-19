@US_0013UITestResultAndImpatient @UIHome
Feature: Test results and Inpatient feature
  Background: User is on the homepage for sign in as an Doctor
    Given user is on homepage
    And user clicks on sign in register dropdown
    And user clicks on sign in dropdown

  @US_0013TC_0001
  Scenario Outline: Doctor should able to see Test Results
    Given Doctor provide valid "<username>" and "<password>"
    And Doctor clicks on sign in button
    And Doctor clicks on My Pages dropdown
    And Doctor clicks on My Appointments
    And doctor selects appointment date from "<dateFrom>" and "<dateTo>"
    And Doctor clicks on Edit button for patient
    And Doctor clicks on Show Test Result button
    And Doctor clicks on View Result button
    And capture the screenshot
    Then Doctor should see and verify all test information
    Then Doctor clicks on Sign out button
    And capture the screenshot
    Then close the application
    Examples:
      | username | password | dateFrom | dateTo |
      | doctor79 | doctor | 03-12-2022 |  03-25-2022  |


  @US_0013TC_0002
  Scenario Outline: Doctor should able to request Impatient
     Given Doctor provide valid "<username>" and "<password>"
    And Doctor clicks on sign in button
    And Doctor clicks on My Pages dropdown
    And Doctor clicks on My Appointments
    And doctor selects appointment date from "<dateFrom>" and "<dateTo>"
    And Doctor clicks on Edit button for patient
    And Doctor clicks on Request Inpatient button
    Then Doctor Verifies message "InPatient request already done for this appointment"
    And capture the screenshot
    Then Doctor clicks on Sign out button
    Then close the application
    Examples:
      | username | password | dateFrom | dateTo |
      | doctor79 | doctor | 03-12-2022 |  03-25-2022  |
