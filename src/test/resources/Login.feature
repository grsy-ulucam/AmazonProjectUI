Feature: Amazon Login Steps

  Background: Precondition Steps
    Given Go to Amazon Website
    Given Click to account button

  @positive @login
  Scenario: Login Amazon Page 1
    When  Enter valid email and click continue button
    And   Enter valid password and click sing in button
    Then  See your username on Home Page

  @negative @login
  Scenario Outline:Login Amazon  Page 2
    When  Enter invalid  "<email>" and click continue button
    Then  Verify error mesaj after continue button

    Examples:
      | email                    |
      | gursoyulucam.04gmail.com |
      | gursoyulucam.@gmail.com  |


  @negative @login
  Scenario Outline:Login Amazon Page 3
    When  Enter valid email and click continue button
    And   Enter invalid "<password>" and click sing in button
    Then  Verify error mesaj after sing in button

    Examples:
      | password   |
      | Fatma      |
      | Fatma.34@  |








