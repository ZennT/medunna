Feature: Room validation

  @Room
    @PostRoom
  Scenario: Api post request to create Room
  Given user sets path params to create room
  When user sets expected data for new room creation
  When user sends post request and gets response to create a room
  And user saves room records to corresponding files
  Then user does room validation

#  Scenario: Get room info and validate
#    Given user sets Medunna base url
#    When user sends get request and get the response
#    And user sets the expected data
#    Then user does the validation

  @Room
    @GetRoom
  Scenario: Api get request to create Room
    Given user sends get request to read room data
    And user deserializes room data to Java
    And user saves room data to correspondent file
    Then user validates expected new created room records with Api



