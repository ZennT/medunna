
@UINewPatientCreation @EndToEnd

Feature: new patient creation and information by admin


  Scenario Outline: new patient creation
    Given system is on the main page
    Given system clicks the logIn dropdown
    And system clicks on the first signInButton
    And system provides the userName as "<userName>"
    And system provides the passWord as "<passWord>"
    And system clicks on remember button
    And system clicks on the second signInButton

#    Examples: user info

#      |userName|passWord|
#      |Admin79 |admin|

#  Scenario Outline: system creates a new patient

    And system clicks on items&title button
    And system clicks on patients
    And system clicks on create a new patient button
    And system provides the new patient creation as "<firstname>" and "<lastname>" and "<birthDate>" and "<email>" and "<phone>" and "<gender>" and "<bloodGroup>" and "<address>" and "<description>" and "<user>" and "<country>"
    And system clicks on the save button



#  Scenario Outline: system makes change in the last name

    And system finds on goToLastPageButton
    And system clicks on editLastCreated
#    And system clicks the lastname for change
    And system changes the last name as "<Lastname>"
    And system clicks on saveButton
    And system clicking on lastPatient
#    And system clicks on deleteLastCreated

    Examples: test data
      |userName|passWord | firstname | lastname| birthDate  | email           | phone        | gender | bloodGroup |address        | description|user  |country|Lastname|
      |Admin79|admin| canali       | cosuli     | 05-27-1981 | kayasili@gmail.com | 123-456-7810 | female |    0-      |tall grass cres|  doon      |system|canada |co  |


#    Examples: test data
#      | lastname|
#      | co  |
#

