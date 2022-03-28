@UIPatients @RegressionTest
Feature:  patients feature TC001 and TC002


  Scenario Outline: Navigating and editing patients info as admin
    #1_Go to https://medunna.com/home
#2-The user signs in as admin   username: admin79 psw: admin
#3- Navigates to "Items&Titles" and clicks
#4-Selects "Patient" from dropdown menu and clicks
#5-Verify the "Patient" informations are visible

    Given user in on the medunna home page
    And user clicks on login dropdown
    And user signs in as admin user name "<username>" and password as "<password>"
    And navigates to item_title and clicks
    And selects patient from dropdown menu
    Then the patient informaions are visible

   # 6-Click the edit button and verify "Create or Edit a Patient" is visible
     # 7- Update all patient's information and click save button
   # 8- Verify patient is saved

    #CONTINUES FROM the end of 5TH LEVEL OF TC001
    And user clics edit button
    Then user verifies create or edit patient page is on
    And user cleans first name box and sends the first name
    And user cleans the last name box and sends the last name
    And birth date sends the birth date
    And user cleans the email box and sends the email
    And user cleans the phone box and sends the phone number
    And user clicks gender box and selects the gender from dropdown
    And user clicks bood group box and selects the blood group
    And user cleans the address box and provides the address
    And user cleans and updates the description
    And user clicks the user box and selects the second one from the dropdown
    And user clicks the country and selects turkey from the dropdown
    # SELECTING CITY FROM DROPDOWN COULD NOT WORK
    And user clicks the save button
   # Then verity the saved data as A Patient is updated with identifier ID
    Then user signs out


    Examples: test data

      |username|password|
      |admin79  |admin  |


  Scenario Outline: Search patient as staff

       # 1_Go to https://medunna.com/home#
       # 2-The user signs in as staff
       # 3- Navigates to "My Pages" and clicks  "Search Patient" in dropdown menu
       #4- Verify the Patients informations are visible
        #5- Provide the patient's SSN in the search box

    Given user in on the medunna home page
    And user clicks on login dropdown
    And user sign in as staff user name "<username>" and password as "<password>"
    And navigates to my pages and clicks
    And selects search patient from dropdown menu
    And clicks patient ssn box in the search patient page
    Then the staff signs out



    Examples: test data staff

      |username  |password|
      |staff079   |staff  |




   # 1_Go to https://medunna.com/home
   # 2-The user signs in as admin
   # 3- Navigates to "Items&Titles" and clicks
   # 4-Selects "Patient" from dropdown menu and clicks
   # 5-Verify the "Patient" informations are visible
   # 6-Click "Delete" then "Confirm Delete Operation" by reclicking "Delete" on the popup window
   # 7- Verify the record is deleted

  Scenario Outline: Delete patient as admin

       # DELETE CONFIRMATION CAN BE DONE BY ONLY THE USER WHO CREATED THE PATIENT
    Given user in on the medunna home page
    And user clicks on login dropdown
    And user signs in as admin user name "<username>" and password as "<password>"
    And navigates to item_title and clicks
    And selects patient from dropdown menu
    Then the patient informaions are visible
    And click delete and confirm delete operation by reclicking on the popup window
   # Then verify the record is deleted message
    Then user signs out

    Examples: delete test data admin

      |username|password|
      |admin79  |admin  |


  Scenario Outline: Staff can navigate and edit patiens but can not delete

    Given user in on the medunna home page
    And user clicks on login dropdown
    And user sign in as staff user name "<username>" and password as "<password>"
    And navigates to my pages and clicks
    And selects search patient from dropdown menu
    Then the patient informaions are visible

    And user clics edit button
    Then user verifies create or edit patient page is on
    And user cleans first name box and sends the first name
    And user cleans the last name box and sends the last name
    And birth date sends the birth date
    And user cleans the email box and sends the email
    And user cleans the phone box and sends the phone number
    And user clicks gender box and selects the gender from dropdown
    And user clicks bood group box and selects the blood group
    And user cleans the address box and provides the address
    And user cleans and updates the description
    And user clicks the user box and selects the second one from the dropdown
    And user clicks the country and selects turkey from the dropdown
    And user clicks the save button
    Then verity the saved data as A Patient is updated with identifier ID
    Then the staff signs out

    Examples: test data staff

      |username  |password|
      |staff079   |staff  |

  Scenario Outline: The admin can not search a patient
   # 1_Go to https://medunna.com/home
   # 2-The user signs in as admin
    #3- Navigates to "Items&Titles" and clicks
    #4-Selects "Patient" from dropdown menu and clicks
    #5-Verify the "Patient" informations are visible
   # 6- Verify that "Patient SSN" search box does not exist

    Given user in on the medunna home page
    And user clicks on login dropdown
    And user sign in as staff user name "<username>" and password as "<password>"
    And navigates to item_title and clicks
    And selects patient from dropdown menu
    Then the patient informaions are visible
      #Then verifies that the patient ssn search box does not exist
    Then  user signs out


    Examples: search test data admin

      |username|password|
      |admin79  |admin  |




