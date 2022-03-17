Feature: Update appointment by doctor
Background: common steps
  Given user is on the login page
  When user clicks on login dropdown icon
  And user clicks on sign in dropdown
  And user provides  doctor username
  And user provides doctor password
  And user clicks on the sign in button
  And Doctor navigates to My Pages segment
  And Doctor clicks on My appointments
  And Doctor clicks on Edit button
  Then doctor selects appointment date from datefrom and dateto


  Scenario:Update My Appointments by doctor

    Given Doctor verifies patient's info id, start and end date, status, physician and patient are present
    And Doctor fills in required fields, anemnesis, treatment, diagnosis
    Then Doctor clicks on Save button
    Then Doctor verifies appointment saved successfully
    Then Doctor clicks on Sign out button



  Scenario:Update My Appointments by doctor

    Given Doctor verifies patient's info id, start and end date, status, physician and patient are present
    And Doctor fills in required fields, anemnesis, treatment, diagnosis
    And Doctor fills in optional fields precription and description
    Then Doctor clicks on Save button
    Then Doctor verifies appointment saved successfully
    Then Doctor clicks on Sign out button


@negative
  Scenario:Update My Appointments by doctor

    Given Doctor leaves anamnesis field blank
    And Doctor verifies this field is required
    And Doctor leaves treatment field blank
    And Doctor verifies this field is required
    And Doctor leaves diagnosis field blank
    And Doctor verifies this field is required
    Then Doctor clicks on Save button
  Then Doctor clicks on Sign out button

