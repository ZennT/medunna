Feature: test of doctor request test


  @DocRequestTest
  Scenario:doctor request test
    Given doctor clicks on sign in dropdown
    Then doctor clicks on sign in
    And doctor provides username
    And doctor provides password
    Then doctor clicks on  sign in button
    And doctor clicks on MY PAGES dropdown
    Then doctor clicks on My Appointments
    And doctor clicks on Edit button of a patient
    And doctor clicks on Request A Test button
    And doctor navigates to Test Items page and verifies the page

#   Doctor clicks the test result checkboxes

    Then doctor clicks on Urea checkbox to check
    And doctor clicks on Urea checkbox to uncheck
    Then doctor clicks on Creatinine checkbox to check
    And doctor clicks on Creatinine checkbox to uncheck
    Then doctor clicks on Sodium checkbox to check
    And doctor clicks on Sodium checkbox to uncheck
    Then doctor clicks on Potassium checkbox to check
    And doctor clicks on Potassium checkbox to uncheck
    Then doctor clicks on Total protein checkbox to check
    And doctor clicks on Total protein checkbox to uncheck
    Then doctor clicks on Albumin checkbox to check
    And doctor clicks on Albumin checkbox to uncheck
    Then doctor clicks on Hemoglobin checkbox to check
    And doctor clicks on Hemoglobin checkbox to uncheck






