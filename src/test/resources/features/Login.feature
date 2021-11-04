
Feature: As a user I want to be able to login under different roles



  Background: common steps
    Given user is on the login page

  @positive_login
  Scenario: Login as a standard_user
    When user logs in
    Then user should see first backpack

  @positive_login
  Scenario: Login as a performance_glitch_user
    When user logs in as a "performance_glitch_user"
    Then user waits a while and should see first backpack

  @positive_login
  Scenario: Login as a problem_user
    When user logs in as a "problem_user"
    Then user should see dog picture

  @negative_login
  Scenario: Login as a  locked_out_user
    When user logs in as a "locked_out_user"
    Then user should get warning message

  @negative_login
  Scenario: Invalid password
    When user logs in with "performance_glitch_user" username and "wrong" password
    Then user verifies that "Epic sadface: Username and password do not match any user in this service" message is displayed

  @negative_login
  Scenario: Empty password
    When user logs in with "standard_user" username and no password
    Then user verifies that "Epic sadface: Password is required" message is displayed

  @negative_login
  Scenario: Empty username
    When user logs in with no username but valid password
    Then user verifies that "Epic sadface: Username is required" message is displayed



  @positive_scenario_outline
  Scenario Outline: Parametrized login as <role>
    When user logs in as a "<role>"
    Then user should see first backpack


    Examples:
      | role                    |
      |performance_glitch_user  |
      | standard_user           |


