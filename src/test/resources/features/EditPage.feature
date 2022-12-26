Feature: Dashborad realted feature tests

  @Smoke
  Scenario: Verify display elements of add computer page
    Given user goes to add computer page
    Then User verifies the header of edit computer page
    Then User verifies name field
    Then User verifies introduced field
    Then User verifies discontinued field
    Then User verifies company field
    Then User verifies create computer button
    Then User verifies cancel button
    Then Usr veries delete computer button

  @Smoke
  @Regression
  Scenario Outline: Check edit functionality
    Given User searches the productName "<productName>"
    Then User verifies "<productName>" present in table
    Then User clicks on "<productName>"
    Then User Verifies details "<productName>"
    Then user submits following computer details
      | name   | introduced | discontinued | company |
      | Comp02 | 2021-01-01 | 2021-01-10   | IBM     |
    Then User verifies updation success message for product "Comp02"
    Examples:
      | productName |
      | ARRA        |

  @Smoke
  @Regression
  Scenario Outline: Check delete functionality
    Given User searches the productName "<productName>"
    Then User verifies "<productName>" present in table
    Then User clicks on "<productName>"
    Then User deletes the product
    Then User verifies deletion message for product "Comp02"
    Examples:
      | productName |
      | ARRA        |

  @Regrssion
  Scenario: Check error message with wrong date format
    Then User clicks on "<productName>"
    Then user submits following computer details
      | name    | introduced  |
      | Comp04  | 2021/01/01  |
    Then User verifies error message for date