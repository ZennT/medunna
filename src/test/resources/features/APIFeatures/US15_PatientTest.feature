
Feature: PatientApiTest

  @US_15_Api_test @EndToEnd

  Scenario: patient creation test
    Given user provides the necessary path params
    And user sets the expected data
    And user sending the GET request and gets the response
    When user saving the api records to correspondent files
    Then user validating api records