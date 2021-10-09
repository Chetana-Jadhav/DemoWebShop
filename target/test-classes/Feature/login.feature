Feature: User is able to login
@login
  Scenario: User is able to login with valid credentials
    Given I have on the landing page of the application
    And I click on login link and navigate to login page
    When I enter valid email as "pooja@test.com" and valid password as "pooja@123"
    And I click on login button
    Then I should be navigated to home page from login page

  @login
  Scenario: User is not able to login with invalid credentials
     Given I have on the landing page of the application
     And I click on login link and navigate to login page
     When I enter valid email as "pooja@test.com" and invalid password as "pooja@123456"
     And I click on login button
     Then I should not be navigated to home page from login page