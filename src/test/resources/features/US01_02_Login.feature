
Feature: As a user, I should be able to login using any of the credentials provided
AC: user should enter valid credentials
    user should enter invalid credentials

  Background: For all scenario, user is on the login page of Swag Labs
    Given user is on the login page of the Swag Labs

    #positive scenario
  Scenario: Login as standard user
    When users enter username valid username "standard_user"
    And user enter valid password "secret_sauce"
    And user click log in button
    Then user should see the products inventory "Products" page title

    #Bugs on items image
  Scenario: Login as problem_user
    When users enter username valid username "problem_user"
    And user enter valid password "secret_sauce"
    And user click log in button
    Then user should see the products inventory "Products" page title

    #Bugs glitch for 10 second
  Scenario: Login as performance_glitch_user
    When users enter username valid username "performance_glitch_user"
    And user enter valid password "secret_sauce"
    And user click log in button
    Then user should see the products inventory "Products" page title

    #negative scenario
  Scenario: Login as locked_out_user
    When users enter username valid username "locked_out_user"
    And user enter valid password "secret_sauce"
    And user click log in button
    Then user should see "Epic sadface: Sorry, this user has been locked out." message locked out

  Scenario: Login as invalid username and invalid password
    When users enter username invalid username
      | user1      |
      | user_user2 |
    And user enter invalid password
      | secret123 |
      | sauce123  |
    And user click log in button
    Then user should see "Epic sadface: Username and password do not match any user in this service" message

  Scenario: User login with out enter username
    And user click log in button
    Then user should see "Epic sadface: Username is required" username error message

  Scenario: User login with out enter password
    When users enter username valid username "standard_user"
    And user click log in button
    Then user should see "Epic sadface: Password is required" password error message