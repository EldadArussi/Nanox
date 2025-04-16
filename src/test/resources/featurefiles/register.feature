Feature: Register

  Scenario: Successful registration
    Given Open home page
    When Open Sign up pop up
    And Register with valid user details
    And Open Log in pop up
    And Log in with the same user
    Then Verify user is logged in