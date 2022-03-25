@appointment_verification
Feature: appointment feature
  Scenario: doctor can see their appointments list and time slots on My Appointments
    Given doctor go to on the Medunna Sign in  Page
    And doctor provides username
    And doctor provides password
    And doctor clicks sign in button
    And doctor clicks MY PAGES
    And doctor clicks My Appointments
    And doctor needs to be in Appointments page
    And doctor selects Appointment date from datefrom and dateto
    And doctor should see appointment details









