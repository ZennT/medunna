Feature: Appointment create read update delete
  @AppointmentApi2
  Scenario: Appointment create
    Given user sets base url for appointment creation
    When  user creates appointment data
    And   user sends post request for appointment creation
    Then  user validates appointment

