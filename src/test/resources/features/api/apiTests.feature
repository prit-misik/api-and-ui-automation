@api
Feature: Verifies different functionality of APIs

  Background:
    Given new user performs registration

  Scenario: User creates a new article
    Given user creates an article with the following data
      | title     | description | body         | tagList   |
      | Article01 | Article01   | Article body | tag1,tag2 |
    Then user validates the following data from the article
      | title     | description | body         |
      | Article01 | Article01   | Article body |

  Scenario: User marks an article as favourite
    Given user creates an article with the following data
      | title     | description | body         | tagList   |
      | Article01 | Article01   | Article body | tag1,tag2 |
    And the user marks it as favourite

  Scenario: User deletes an article
    Given user creates an article with the following data
      | title     | description | body         | tagList   |
      | Article01 | Article01   | Article body | tag1,tag2 |
    And the user deletes the article