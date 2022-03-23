@Api
Feature: Room validation
  Scenario: Get room info and validate
    Given user sets Medunna base url
    When user sends get request and get the response
    And user sets the expected data
    Then user does the validation

