@staff
Feature: test payment_invoice data

  @UILogin
  Scenario Outline: test payment invoice
    Given user sign in with staff credential
    And user clicks my pages dropdown
    And user clicks search patient button
    Then user search patient with snn id "<ssn>" in the search box
    Then user clicks show appointment
    Then user verifies patient's status
    Then user clicks payment_invoice process
    And user see the following fields in the invoice page
#    And user clicks create invoice button
#    And user clicks save button
#    And user verifies the success message
  #  And user search patient with snn id "<ssn>" in the search box
   # Then user clicks show appointment
 #   Then user clicks payment_invoice process
    And user clicks show invoice button
    And user verify invoice page
    And user signout
    Examples: user info
      | ssn         |
      | 199-59-9895 |


  @UILogin
  Scenario Outline: test payment with invalid ssn
    Given user sign in with staff credential
    And user clicks my pages dropdown
    And user clicks search patient button
    Then user search patient with snn id "<ssn>" in the search box
    And user gets no patients found message
    And user signout
    Examples: user info
      | ssn         |
      | 999-59-9895 |
      | 234567789   |

  @UILogin
  Scenario Outline: test payment status unapproved
    Given user sign in with staff credential
    And user clicks my pages dropdown
    And user clicks search patient button
    Then user search patient with snn id "<ssn>" in the search box
    Then user clicks show appointment
    And user verifies patient's "<status>" unapproved not able to create an invoice
    And user signout
    Examples: user info
      | ssn         | status     |
      | 555-65-4587 | UNAPPROVED |

  @UILogin
  Scenario Outline: test payment status cancelled
    Given user sign in with staff credential
    And user clicks my pages dropdown
    And user clicks search patient button
    Then user search patient with snn id "<ssn>" in the search box
    Then user clicks show appointment
    And user verifies patient's "<status>" not able to create an invoice
    And user signout
    Examples: user info
      | ssn         | status    |
      | 555-65-4587 | CANCELLED |


  @UILogin
  Scenario Outline: test payment status completed
    Given user sign in with staff credential
    And user clicks my pages dropdown
    And user clicks search patient button
    Then user search patient with snn id "<ssn>" in the search box
    Then user clicks show appointment
    And user verifies patient's "<status>" to able to create an invoice
    And user signout
    Examples: user info
      | ssn         | status    |
      | 199-59-9895 | COMPLETED |

  @UILogin
  Scenario Outline: test payment status pending
    Given user sign in with staff credential
    And user clicks my pages dropdown
    And user clicks search patient button
    Then user search patient with snn id "<ssn>" in the search box
    Then user clicks show appointment
    And user verifies patient's "<status>" pending to not able to create an invoice
    And user signout
    Examples: user info
      | ssn         | status  |
      | 555-65-4587 | PENDING |

  @UILogin
  Scenario Outline: test payment status
    Given user sign in with staff credential
    And user clicks my pages dropdown
    And user clicks search patient button
    Then user search patient with snn id "<ssn>" in the search box
    Then user clicks show appointment
    And user verifies patient's "<status>"  to create an invoice
    And user signout
    Examples: user info

      | ssn         | status    |
      | 555-65-4587 | COMPLETED |

    #command +option +l codlari duzenlemek icin


  @UILogin
  Scenario Outline: staff edit
    Given user sign in with staff credential
    And user clicks my pages dropdown
    And user clicks search patient button
    Then user search patient with snn id "<ssn>" in the search box
    Then user clicks show appointment
    Then user clicks patient edit button
    Then user selects patient's status
    And user clicks save button
    And user verifies the success message changes
    And user signout

    Examples: user info
      | ssn         |
      | 417-85-5181 |

  @UILogin
  Scenario Outline: show test result
    Given user sign in with staff credential
    And user clicks my pages dropdown
    And user clicks search patient button
    Then user search patient with snn id "<ssn>" in the search box
    Then user clicks show appointment
    And user clicks show test button
    And user clicks view result button
    And user verify test results
    And user signout
    Examples: user info
      | ssn         |
      | 199-59-9895 |

  @UILogin
  Scenario Outline: test physcian
    Given user sign in with staff credential
    And user clicks my pages dropdown
    And user clicks search patient button
    Then user search patient with snn id "<ssn>" in the search box
    Then user clicks show appointment
    And user clicks patient edit button
    And user selects doctor for patient
    And user clicks save button
    And user verifies the success message changes
    And user signout

    Examples: user info
      | ssn         |
      | 199-59-9895 |

  @UILogin
  Scenario Outline: test required field
    Given user sign in with staff credential
    And user clicks my pages dropdown
    And user clicks search patient button
    Then user search patient with snn id "<ssn>" in the search box
    Then user clicks show appointment
    And user clicks patient edit button
    And user leaves blank Anamnesis, Treatment or Diagnosis as required fields
    And user clicks save button
    And user verifies the success message changes
    And user signout

    Examples: user info
      | ssn         |
      | 383-72-3156 |