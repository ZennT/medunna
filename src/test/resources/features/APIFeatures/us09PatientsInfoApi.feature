@PatientInfoApi
Feature: Test all patient info

  @ValidatePatient
  Scenario: Get patient info and validate
    Given set the Base Url
    And send the GET request and get the response
    And set the expected data
    Then do validation