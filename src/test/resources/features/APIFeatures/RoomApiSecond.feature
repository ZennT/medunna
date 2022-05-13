@RoomApiSecond
Feature: Room api study
  Scenario: Room post
   Given User sets base url for new room creation
    When User sets the expected data for a new room
    And  User sends post request and gets response for a new room
    And  User validates the new room
    And  User sends get request to reach newly created room
    And  User sends put request to update new room
   Then User deletes created room
   Then User verifies that created room is deleted
