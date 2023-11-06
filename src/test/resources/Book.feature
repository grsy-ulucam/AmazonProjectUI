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


    Scenario Outline: See sort by low to high price books
      When Search a "book" in search bar on home page
      And  Should see on book page and click sort by button on book page
      And  Select low to high on book page
      Then Verify "<first book>" on book page

      Examples:
        |       first book          |
        | Annem Sizi Derse Bekliyor |

      Scenario Outline: Choose price 500 and over for search book price
        When Search a "book" in search bar on home page
        And  Click five hundred and over button on book page
        Then User should see "<book>" on book page

        Examples:
          | book|
          | Sticker Book |

