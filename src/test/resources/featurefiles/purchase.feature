Feature: Purchase

  Scenario: successfully purchase
    Given Open home page
    When Select random product
    And Add product to the cart
    And Move to Cart page
    Then Verify product is in the cart
    And Click on place order
    And Fill in purchase details:
      | name      | credit card   |
      | test name | 1234567890123 |
    And Click on purchase
    Then Verify Success message is Thank you for your purchase!
