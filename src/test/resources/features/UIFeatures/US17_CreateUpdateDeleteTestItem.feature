
@loginTest
Feature:

  @UI_login_positive1
  Scenario Outline: Verifying user login with correct username and password

    Given User navigates to the home page
#    And user clicks sign in button at the home page and navigates to sign in page
    Then user verifies that sign in page header is visible
    And user enters username "<username>" and password "<password>"
    And user clicks sign in button
    And user verifies that sign in is successful


    Examples: credentials
      |username |password |
      |admin79  | admin   |

  @UI_login_positive2
  Scenario Outline: Verifying user itemsTitles

    Then user clicks on the ItemTitles dropdown
    And user clicks on the testItem dropdown
    And user clicks on the createNewTestItem dropdown
    And user provides a  test name "<testName>"
    Then user enters a description "<descriptionNote>"
    And user enters  a price "<currentPrice>"
    And user enter a min value "<minValue>"
    And User enters a max value "<maxValue>"

    Then user clicks on save button
    And user verifies that saving is successful
    And user clicks last arrow button
    And user clicks last itemNumber
    And user clicks delete button
    And user clicks confirmDelete button
    Then user verifies itemDeleteMessage
    And user clicks on login dropdown icon
    Then user clicks on sign out




    Examples: credentials
      |username |password |testName |descriptionNote |currentPrice|minValue|maxValue |
      |admin79  | admin   |dihanlin  |     mg/ml      |   120     | 80  |   130   |

