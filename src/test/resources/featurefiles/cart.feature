Feature: Cart

  Background:
    Given Open home page
    When Select random product
    And Add product to the cart
    And Move to Cart page

  Scenario: Add product to cart
    Then Verify product is in the cart

  Scenario: Delete product from cart
    And Delete product from the cart
    Then Verify product is not in the cart


