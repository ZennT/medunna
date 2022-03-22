Feature: Admin creates edits deletes room

  Scenario: Admin creates a room negative case
    Given user is on the login page
    When User signs in as admin
    And User clicks on Room cta under My Links
    And User clicks on Create a new room
    And User leaves room number field blank
    And User chooses TWIN on Room Type dropdown
    And User sets current status by clicking on Status checkbox
    And User leaves price field blank
    And User enters description
    And User enters created date
    And User clicks on Save button
    Then This field is required message appears under required field textbox

    Scenario: Admin creates a room positive case
    Given User enters room number
      And User chooses TWIN on Room Type dropdown
      And User sets current status by clicking on Status checkbox
      And User enters price
      And User enters description
      And User enters created date
      And User clicks on Save button
      Then User verifies the room is created successfully

      Scenario: Admin edits and deletes the room
        Given User clicks on last page button
        When User clicks on Edit button
        And User updates room number
        And User chooses DELUXE as room type
        And User updates price
        And User updates description
        And User clicks on Save button
        And User clicks on delete button
        And User confirms delete on pop up message
        Then User verifies room is deleted successfully



