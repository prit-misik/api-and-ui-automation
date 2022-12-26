Feature: Add a computer feature tests

  @Smoke
  Scenario: Verify display elements of add computer page
    Given user goes to add computer page
    Then User verifies the header of add computer page
    Then User verifies name field
    Then User verifies introduced field
    Then User verifies discontinued field
    Then User verifies company field
    Then User verifies create computer button
    Then User verifies cancel button

    @Smoke
    @Regrssion
    Scenario: Check create computer functionality
      Given user goes to add computer page
      Given User adds a new computer
      Then user submits following computer details
        | name    | introduced  |  discontinued  |  company |
        | Comp02  | 2021-01-01  |  2021-01-10    |   IBM    |
      Then User verifies success message for product "Comp02"

  @Regrssion
  Scenario: Check error message for not providing mandatory field
    Given user goes to add computer page
    Given User adds a new computer
    Then user submits following computer details
      | introduced  |  discontinued  |  company |
      | 2021-01-01  |  2021-01-10    |   IBM    |
    Then User verifies failure mesage

  @Regrssion
  Scenario: Check create computer by providing only mandatory field
    Given user goes to add computer page
    Given User adds a new computer
    Then user submits following computer details
      | name    |
      | Comp03  |
    Then User verifies success message for product "Comp03"

  @Regrssion
  Scenario: Check error message with wrong date format
    Given user goes to add computer page
    Given User adds a new computer
    Then user submits following computer details
      | name    | introduced  |
      | Comp04  | 2021/01/01  |
    Then User verifies error message for date

  @Regrssion
  Scenario: Check cancel button functionality
    Given user goes to add computer page
    Then User clicks on cancel button
    Then verify user is on dashboard