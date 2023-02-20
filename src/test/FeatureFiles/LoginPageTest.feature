Feature: Login Feature

  Địt con mọe tụi bây

  Background: eo biet ghi gi o day

  Scenario: Perform login with invalid data
    Given landed to the web login page
    When perform login by input <username> and <password>
    Then display error base on the invalid data
    Example:
      username  | password
