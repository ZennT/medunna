Feature:  Room database validation
  Scenario:Room db validation
    Given User connects to the database
    And user sends new room query to DB and gets the column data
    And User validates new room landed on db
    Then User sends query to delete from  db

