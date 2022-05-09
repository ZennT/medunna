Feature: Appointment create read update delete
  @Appointments_validation
  Scenario: appointment create
    Given user sets base url for appointment creation
    And user creates appointment data
    And user sends post request for appointment creation
    Then user validates appointment
