Feature: Dashborad realted feature tests

  @Smoke
  Scenario Outline: Verify display elements of dashboard page
    Then User verifies the header of the dashboard page
    Then User verifies searchBox is visible
    Then User verifies search submit is clickable
    Then User verifies table is present
    Then user verifies table header "<Header>"
    Then User verifies add new computer link clickable
    Then User verifies next button
    Then User verifies prev button

    Examples:
      | Header        |
      | Computer name |
      | Introduced    |
      | Discontinued  |
      | Company       |

  @Smoke
  @Regression
  Scenario Outline: Check search functionality
    Given User searches the productName "<productName>"
    Then User verifies "<productName>" present in table
    Then User clicks on "<productName>"
    Then User Verifies details "<productName>"
    Examples:
      | productName |
      | ARRA        |

  @Regression
  Scenario Outline: Check search functionality with invalid product
    Given User searches the productName "<productName>"
    Then User Verifies text "Nothing to display"
    Examples:
      | productName |
      | zzzz        |

  @Smoke
  @Regression
  Scenario: Check add a new computer functionality
    Given User adds a new computer
    Then User verifies page header
    Then user submits following computer details
      | name     | introduced | discontinued | company |
      | NewAge01 | 2021-01-01 | 2021-01-10   | IBM     |
    Then User verifies success message for product "NewAge01"
