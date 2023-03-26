@ui
Feature: Verifies different functionality of Articles and User profiles

  Background:
    Given user logs in with correct username and password

  Scenario: User creates a new article
    Given user creates new article with given details
      | article_title | about                 | path_to_detailed_article | tag              |
      | About ChatGPT | An article on chatGPT | detailedArticle01.txt    | chatgpt_pritshar |
    Then user should be able to verify basic components of article

  Scenario Outline: User edits an article
    Given user creates new article with given details
      | article_title   | about           | path_to_detailed_article | tag              |
      | What is ChatGPT | What is chatGPT | detailedArticle01.txt    | chatgpt_pritshar |
    Given user modifies the title to "<newTitle>"
    Then validates the updated title
    Examples:
      | newTitle        |
      | More on ChatGPT |

  Scenario: User deletes an article
    Given user creates new article with given details
      | article_title | about     | path_to_detailed_article | tag       |
      | World Map     | World Map | detailedArticle01.txt    | world_map |
    And user deletes the article
    Then user validates the article is not visible

  Scenario Outline: Search with tags
    Given user searches with a tag "<tag>"
    Then user should be able to a new tab with the tag name "<tag>"
    Examples:
      | tag    |
      | matrix |

  Scenario: User updates profile settings
    Given user updates bio with the given details
      | short_bio   |
      | A Test User |
    Then user validate short bio as "A Test User"
