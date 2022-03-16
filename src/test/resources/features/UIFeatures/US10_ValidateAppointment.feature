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
    @appointments_api_doctor
    Scenario: doctor should be able to see his/her appointment list in api
      Given user sends get request to the "https://medunna.com/api/appointments/bydateandId?fromDate=2022-03-07&toDate=2022-03-10&userId=10097"
      Then status code should be 200
      And response format should be "application/json"
      And response body should include expected information







