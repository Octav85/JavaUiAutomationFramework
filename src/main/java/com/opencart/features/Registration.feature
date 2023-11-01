@run
Feature: Register Flow test Suite


  Background:
    Given "/index.php?route=account/register&language=en-gb" endpoint is accessed

  Scenario: Register Page can be accessed from the Home page
    Given "/" endpoint is accessed
    When registerLink from Header menu is clicked
    Then the current url contains "route=account/register" keyword

  Scenario: Access the Account page after successful registration

    And registerLink from Header menu is clicked
    When the registration form is populated with valid random data
    And continueButton is clicked
    Then the current url contains "route=account/success" keyword

  Scenario: User remains on Register Page when continue button is not clicked

    When the registration form is populated with valid random data
    Then the current url contains "route=account/register" keyword

  @run
  Scenario Outline: An error message is displayed when invalid firstName is used for register flow
    And the register form is populated with following data:
      | firstName | <firstName>    |
      | lastName  | <lastName>     |
      | email     | <emailData>    |
      | password  | <passwordData> |
      |           |                |
    When continueButton is clicked
    Then the following list of error messages is displayed:
      | <impacted attribute> must be between 1 and 32 characters! |
    Examples:
      | impacted attribute | firstName                          | lastName                            | emailData | passwordData |
      | First Name         | 1213146478997735598887897787217564 | Random                              | Random    | Random       |
      | Last Name          | firstName                          | 12131464789977355988877287742121121 | Random    | Random       |






