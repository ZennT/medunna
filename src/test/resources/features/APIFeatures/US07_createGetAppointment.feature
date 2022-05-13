Feature: Appointment Validation


  Scenario: Creating appointment

    # create appointments

    Given user sets the base url
    When user sets the expected appointment data
    And user creates post request for appointment
    And user saves appointment data to the corresponding file
    Then user validates appointment data

    #fetch appointments using API