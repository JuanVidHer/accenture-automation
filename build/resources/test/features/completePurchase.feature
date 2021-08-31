Feature: Complete purchase

  Scenario: All items purchase successful
    Given the user is on the Swag login page
    And the user enters valid credentials
    When the user selects all available items
    And the user checkouts the purchase
    And the user fills out the shipment form with first name 'Juan Jose', last name 'Vidal Hernandez' and zip code '31016'
    And the user confirms information is correct
    Then successful purchase message is shown
