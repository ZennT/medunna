Feature: Update appointment by doctor

  Scenario:Update My Appointments by doctor
    Given user is on the login page
    When user clicks on login dropdown icon
    And user clicks on sign in dropdown
    And user provides  doctor username
    And user provides doctor password
    And user clicks on the sign in button

    And Doctor navigates to My Pages segment
    And Doctor clicks on My appointments
    And Doctor clicks on Edit button
    And Doctor verifies patient's info id, start and end date, status, physician and patient are present
    And Doctor selects status as Pending from dropdown
    And Doctor fills in required fields, anemnesis, treatment, diagnosis
    Then Doctor clicks on Save button
    Then Doctor verifies appointment saved successfully
