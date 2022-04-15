Feature: Appointment validation
  @@ApointmentApi
Scenario: Creating appointment
  Given user sets the base url
  When user sets the expected appointment data
  And user creates post request for appointment
  And user saves appointment data to correspondent file
  Then user validates appointment data