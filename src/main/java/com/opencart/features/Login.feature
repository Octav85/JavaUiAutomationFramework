Feature: Login Related Test cases

  @run
  Scenario Outline: An error message is displayed when using invalid <affectedAttribute> for login flow
    Given "/index.php?route=account/login&language=en-gb" endpoint is accessed
    When the following form from "LoginPage" is populated as follow:
      | inputEmail    | <username> |
      | inputPassword | <password> |
    And the "loginButton" from "LoginPage"is clicked
    Then the following list of error messages is displayed:
      | Warning: No match for E-Mail Address and/or Password. |
    Examples:
      | username                  | password       | affectedAttribute |
      | kotovan85@yahoo.com       | The Password!1 | password          |
      | plopaoctavian22@yahoo.com | The Password!1 | password          |

  @regression
  Scenario Outline: Successful login with valid credentials
    Given "/index.php?route=account/login&language=en-gb" endpoint is accessed
    When the following form from "LoginPage" is populated as follow:
      | inputEmail    | <username> |
      | inputPassword | <password> |
  And the "loginButton" from "LoginPage"is clicked
    Then the current url contains "account" keyword
    Examples:
      | username                  | password   |
      | kotovan85@yahoo.com       | dshaf4jasf |
      | plopaoctavian22@yahoo.com | dtereyhgh  |