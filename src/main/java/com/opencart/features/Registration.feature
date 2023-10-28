Feature: Register Flow test Suite

  Scenario: Register Page can be accessed from the Home page
    Given "/" endpoint is accessed
    When registerLink from Header menu is clicked
    Then the current url contains "route=account/register" keyword

  Scenario: Access the Account page after successful registration
    Given "/index.php?route=account/register&language=en-gb" endpoint is accessed
    And registerLink from Header menu is clicked
    When the registration form is populated with valid random data
    And continueButton is clicked
    Then the current url contains "route=account/success" keyword

  Scenario: User remains on Register Page when continue button is not clicked
    Given "/index.php?route=account/register&language=en-gb" endpoint is accessed
    When the registration form is populated with valid random data
    Then the current url contains "route=account/register" keyword




