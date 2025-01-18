Feature: Login

  Scenario: Login with valid username and password
    Given user is on login page
    When user input username with "standard_user"
    And user input password with "secret_sauce"
    And user click login button
    Then user is at the homepage

  Scenario: Login with invalid username or password
    Given user is on login page
    When user input username with "standard_user"
    And user input password with "random_password"
    And user click login button
    Then user will show error message "Epic sadface: Username and password do not match any user in this service"