Feature: Room api study

  Scenario: Room post
   Given user sets base url for room creation
    When User sets the expected data for a new room
    And  User sends post request and gets response for a new room
    And  User validates the new room
    And  User sends get request to reach newly created room
    And  User sends put request to update new room
