Feature: appointment date test

  @Appointment_Date
  Scenario: test appointment date

    Given user clicks on make an appointment
    And user sees and verifies Appointment DateTime text
    And user clicks on make an appointment
    And user sends the current date
    And user sends a valid date
    Then user verifies the date as mm-day-year
