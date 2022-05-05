@DBTest
Feature: registrants database validation
  Background:db connection set up
    Given user creates a connection with DB


  Scenario Outline: Validate registrant email with DB
    And user selects all "email" column data from table
    And user validates registrant "<email>" with the database
    Then close the database connection

    Examples:
      | email                |
      | system@localhost     |
      | apl@email.com        |
      | hasta@email.com      |
      | deatly@gmail.com     |
      | mustafa@qa.team      |



  Scenario Outline: Validate registrant SSN ids with DB
    And user selects all ssn "ssn" column data
    Then user validates registrant "<ssn>" ids with the database
    Then close the database connection

    Examples:
      |ssn        |
      |527-87-5703|
      |691-81-5313|
      |383-06-4367|




  Scenario Outline: Validate registrant username/login ids with DB
    And user selects all username "login" column data
    Then user validates registrant username "<login>" with the database
    Then close the database connection

    Examples:
      | login           |
      | titocruickshank |
      | user2           |
      | ilknur          |
      | agokkus         |
      | hena            |









