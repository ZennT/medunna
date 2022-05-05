@DBTest
Feature: registrants database validation
  Background:db connection set up
    #bu stepi DB utilsten  createConnection() methodu ile de alabiliriz
    #Given user creates a connection with DB using "jdbc:postgresql://medunna.com:5432/medunna_db" and "medunnadb_user" , "Medunnadb_@129"
    Given user creates a connection with DB


  Scenario Outline: Validate registrant email with DB
  #  Given user sends the query to DB and gets the column data "<query>" and "<columnName>"
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
   # And user saves the DB records in to txt file
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









                # background 'ta data base connection yaptik vede senoaryo outline kullandik
#  Background:db connection set up
#    #bu stepi DB utilsten  createConnection() methodu ile de alabiliriz
#    #Given user creates a connection with DB using "jdbc:postgresql://medunna.com:5432/medunna_db" and "medunnadb_user" , "Medunnadb_@129"
#
##  @DBTest
##  Scenario Outline: db validations
##    Given user sends the query to DB and gets the column data "<query>" and "<columnName>"
##    And user saves the DB records to correspondent files
##    Then user validates DB Registrant data
##
##    Examples: test data
##      | query                  | columnName |
##      | Select * from jhi_user | email      |



