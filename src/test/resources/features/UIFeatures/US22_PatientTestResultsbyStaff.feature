@TestResult @RegressionTest
Feature: Staff feature

  Scenario Outline: Staff login and search patient by SSN
    Given staff is on the Medunna Sign in  Page
    And staff enters username "<username>"
    And staff enters password  "<password>"
    And staff clicks sign in button
    And staff clicks MY PAGES dropdown
    And staff clicks on Search Patient
    And staff clicks on Patient SSN text box
    And staff enters patient SSN
    And staff verifies visibility of patients information
    And staff  navigates to Show Appointments
    And staff clicks on Show Test and views result test
    And staff edit patients test result and test description
    Then staff saves the changes
    Then staff verifies success message
    Then staff should view or update the test  in Test Result page
    Then staff clicks on sign out button
    Examples:
      |username   |password |
      |staff079   |staff    |

  #Scenario: Staff searches patients test results

    #Given staff  navigates to Show Appointments
   # And staff clicks on Show Test and views result test
    #And staff edit patients test result and test description
    #Then staff saves the changes
    #Then staff verifies success message
    #Then staff should view or update the test  in Test Result page
    #Then staff clicks on sign out button