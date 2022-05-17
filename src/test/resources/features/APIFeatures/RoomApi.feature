Feature: Room create read update delete

#end to end , chain scenario
  @RoomApi
  Scenario: Room create
    Given user sets base url for room creation
    When  user sets the expected room data
    And   user sends post request for room creation
    And   user saves data
    Then  user validates room data
    Then  send get request to validate created room
    Then  send put request to update room type
    Then  send get request to validate updated room
    Then  send delete request to delete room
    Then  send get request to validate the room is deleted

