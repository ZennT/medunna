@PatientInfoApi
Feature: Test all patient info

  @ValidatePatient
  Scenario: Get patient info and validate
    Given set the base url
    And send the get request and get response
    And set the expected data
    Then do validation