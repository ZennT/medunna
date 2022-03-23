
Feature: TestItems Api functionalities
  @TestItemApi
  @ApiPostTestItem
  Scenario: Api post request to create test item
    Given user sets the path params to create test item
    And user sets expected data
    And user send Post request for test item and gets response
    And user saves the test item records
    Then user validates test item record with Api



  @TestItemApi
  @ApiGetTestItem
  Scenario: Api get request for test item
    Given user sends the get request for test items data
    And user deserializes test items data to Java
    And user saves the test items data to correspondent file
    Then user validates expected test item records with Api


