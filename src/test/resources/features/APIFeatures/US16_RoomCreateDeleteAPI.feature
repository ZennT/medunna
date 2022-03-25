@Api
Feature: Room validation

  Scenario: Room creation
  Given user sets Medunna base url
  When user sends post request to create a room
  And user sends get request for room and get the response
  And user sets room expected data
  Then user does room validation
#  Scenario: Get room info and validate
#    Given user sets Medunna base url
#    When user sends get request and get the response
#    And user sets the expected data
#    Then user does the validation

