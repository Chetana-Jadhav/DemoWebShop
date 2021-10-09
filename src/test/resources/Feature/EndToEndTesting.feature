Feature: End to end user journey

  Scenario: End to End User journey for buying a product
    Given I have on the landing page of the application
    * I register as a new user
    * I search for a product
    * I add the product to the basket with quantity as "2"
    * I navigate to the cart
    * I checkout the cart
    * I add billing address as below and proceed next
      | FirstName  | Shahrukh |
      | SecondName | Khan     |
      | Country    | India    |
      | City       | Mumbai   |
      | Address    | Manant   |
      | zipCode    | 32244    |
      | phone      | 34335    |
    * I select shipping address same as Billing address and proceed next
    * I select Shipping Method as Next Day Air and proceed next
    * I select payment method as Purchase Order and proceed next
    * I enter Payment Number as "12345" and process next
    When I enter confirm order
    Then Order is successfully placed and Thank you message is displayed
    And Order number is displayed