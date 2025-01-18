Feature: Home

  Scenario: View Detail Product that exists
    Given user is at the homepage
    Then check if this product exists "Sauce Labs Backpack"
    Then user click on the product "Sauce Labs Backpack"
    Then user is at product detail page

  Scenario: View Detail Product that is not exists
    Given user click on the product "Sauce Labs Backpack"
    Then user is at product detail page
    Then user change the inventory item id url to 99
    Then user will see item not found page