Feature: Add a product the basket

  Background: Login Amazon
    Given Go to Amazon Website

    Scenario Outline:Add a book the basket
      When Search a "<product>" in search bar on home page
      Then Verify book in search on result page
      When Click first book on result page
      And  Click add the basket on basket page
      Then Verify text about add the basket on basket page
      Examples:
        | product |
        | book    |

