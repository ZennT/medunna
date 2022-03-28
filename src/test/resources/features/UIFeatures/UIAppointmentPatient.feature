@AppointmentTotal
Feature: appointments test



  @UIAppointment @RegressionTest
  Scenario Outline: test appointments
    Given user clicks on make an appointment
    And user provides the appointment name "<firstname>"
    And user provides the appointment lastname "<lastname>"
    And user provides ssn and email "<SSN>" and "<email>"
    When user provides the phone number "<phoneNumber>"
#    And user provides the date "<date>"
    Then user requests appointment and verifies the success message
    Then user clicks on signin dropdown
    Then user clicks on register button
    Then user enters ssn number as "<SSN>"
    Then user enters firstname as firstname as "<firstname>" and lastname as "<lastname>"
    Then user enters username as "<username>"
    Then user enters email as "<email>"
    Then user enters new passport as "<password>"
    Then user confirms password as "<password>"
    Then user clicks on register2 button
    Then user clicks on signin2 dropdown
    Then user clicks on Sign in button
    Then user enters username2 as "<username>"
    Then user enters password2 as "<password>"
    Then user clicks on Sign in2 button and verifies signin

    Examples: test data
      | firstname | lastname | SSN         | email          | phoneNumber  | username | password     |
      | C         | I        | 200-56-2407 | cixa@ma.c657om | 222-333-4444 | ci7009bc | abcdefpG122. |

  @UIAppointment
  Scenario Outline: negative ssn test
    Given user clicks on make an appointment
    And user provides invalid ssn as "<ssn>"
    And user verifies the ssn error message

    Examples: invalid ssn data
      |ssn            |
      | 999-66-3456  |
      | 189-65-78k?  |
      |  189657890   |
      | 34567-67-90  |

  @UIAppointment
  Scenario Outline: negative email test
    Given user clicks on make an appointment
    And user provides invalid email as "<email>"
    And user verifies the email error message

    Examples:  invalid email data
      |email|
      |  cigmailcom   |
      |   ci@gmailcom  |
      |   cigmail.com  |

  @UIAppointment
  Scenario Outline: negative phone number test
    Given user clicks on make an appointment
    And user provides invalid phone number as "<phoneNumber>"
    And user verifies the phone number error message

    Examples:  invalid phone number data
      |phoneNumber|
      |1234-56-7899   |
      |123-4567-899 |
      |123456789  |
      |123-456-78999 |

  @UIAppointment
  Scenario: blank test
    Given user clicks on make an appointment
    And user keeps firstname blank and verifies error message
    And user keeps lastname blank and verifies error message
    And user keeps ssn blank and verifies error message
    And user keeps email blank and verifies error message
    And user keeps phonenumber blank and verifies error message

