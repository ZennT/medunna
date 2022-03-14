Feature: End To End
  @EndToEnd
    @UIRegistration
  Scenario Outline: test multiple test data for registrant positive test
    Given user provides ssn id "<ssn>"
    And user provides firstname and lastname "<firstname>" and "<lastname>"
    And user provides username "<username>"
    And user provides email "<email>"
    And user provides the password "<password>"
    Then user registers and validates data generation
    Then user sets the data in correspondent files
    Given user sends the query to DB and gets the column data "<query>" and "<columnName>"
    And user saves the DB records to correspondent files
    Then user gets DB records and validates the ssn

    Examples: user info
      |ssn|firstname|lastname|username|email|password|query|columnName|
      |883-05-6700|Sema|last|tea908797|kerim5@gmail.com|Util123.|Select * from jhi_user|ssn|



