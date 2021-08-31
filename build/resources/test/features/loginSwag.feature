Feature: Login in Swag website

  Background:
    Given the user is on the Swag login page

  Scenario: Login Successful valid credentials
    When the user enters valid credentials
    Then the user navigates successfully to 'PRODUCTS' page

  Scenario: Login Unsuccessful invalid credentials
    When the user enters invalid credentials
    Then the pages shows an error message

