@AnadoluSigorta
Feature: Anadolu Sigorta Web Production Scenarios(ChromeDriver)
  Background:I get and check mainpage is loaded successfully
    Given I navigate to main url
    When I check 25 titles on the mainpage
    Then I take screenshot and save as "mainpage_loaded_successfully"
    @UAT
Scenario: The Details, What It Includes, Special Services which open respectively on the page related to a product that is randomly clicked, should not be empty.
  Given I go to products tab and click randomly a product
  When  I see the product is loaded successfully
  Then I take screenshot and save as "productpage_loaded_successfully"
  When I check are we at the right page
  Then I should see all informations tabs has their explonations
Then I take screenshot and save as "customer_can_take_informations_about_product"
