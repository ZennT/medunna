@Appointments_api_validation
  Feature: US_10_API
  Scenario: doctor should be able to see his/her appointment list in api
      When Doctor set Medunna base url
      And Doctor send the GET request and GET the response
      And Doctor deserialize data json to java
      And Doctor saves the patient data to correspondent files
      And Doctor validates expected data with API