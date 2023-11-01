Feature: Login Related Test cases

  @run
  Scenario Outline: An error message is displayed when using invalid <affectedAttribute> for login flow
    Given "/index.php?route=account/login&language=en-gb" endpoint is accessed
    When the login form is populated with following details:
      | kotovan85@yahoo.com |
      | ParolaGrea1234!     |
    And the Login button is clicked
    Then the following list of error messages is displayed:
      | Warning: No match for E-Mail Address and/or Password. |
    Examples:
      | email                     | password       | affectedAttribute |
      | kotovan85@yahoo.com       | The Password!1 | password          |
      | plopaoctavian22@yahoo.com | The Password!1 | password          |