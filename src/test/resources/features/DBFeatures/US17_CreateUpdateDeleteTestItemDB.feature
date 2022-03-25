
@US17_DBTest
Feature: DB Test Items validation

  Background: db connection set up
    Given user creates the connection with DB using "jdbc:postgresql://medunna.com:5432/medunna_db" and "medunnadb_user" , "Medunnadb_@129"

  @US17_DBTest
  Scenario Outline: db validations
    Given user sends query to DB and gets the column data "<query>" and "<columnName>"
    And user saves DB records to correspondent files
    Then user validates DB test item data

    Examples:  test data
      |query                     |columnName     |
      |Select * from c_test_item |name           |


