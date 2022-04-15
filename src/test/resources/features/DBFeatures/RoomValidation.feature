Feature:Room validation
  @RoomApi
  Scenario: Validate created room
    Given create room by using post request
    And connect to database
    Then validate that room is landed in db