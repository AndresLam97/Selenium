
Feature: Login Feature
  Sub description of the feature

    @LoginPageErrorValidation
    Scenario Outline: Test the error validation of the login page
      Given I landed to the web login page
      When I perform login with input <email> and <password>
      Then The page validate and display error
      Examples:
        | email                    | password         |
        | lamankien1997            | Andres0909861773 |

    @Regression
    Scenario Outline: Test the login page when input correct values
      Given I landed to the web login page
      When I input the correct <email> and <password> to perform login
      Then the page validate and switches to the dashboard page
      Examples:
        | email                   | password         |
        | lamankien1997@gmail.com | Andres0909861773 |


