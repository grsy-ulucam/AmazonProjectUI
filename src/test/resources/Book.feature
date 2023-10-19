Feature: Add a product the basket

  Background: Login Amazon
    Given Go to Amazon Website

  Scenario Outline:Add first book the basket
    When Search a "<product>" in search bar on home page
    Then Verify book in search on book page
    When Click first book on book page
    And  Click add the basket on basket page
    Then Verify text about add the basket on basket page
    Examples:
      | product |
      | book    |

  Scenario Outline:Add last book the basket
    When Search a "book" in search bar on home page
    And  Click last book on book page
    And  Click quantity button and select two on basket page
    And  Click add the basket on basket page
    And  Click  the basket on basket page
    Then Verify "<quantity>" equals two basket page
    Examples:
      | quantity |
      |   2      |

