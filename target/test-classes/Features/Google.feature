Feature: Google Search feature
  
  @tag123
  Scenario: Google search bar test
    Given I launch browser and open google url
    And I enter a string "Java" in the search box
    And I verified the list of options populted for entered string
  
  @tag124
  Scenario Outline: Verify login with valid credential
    Given I launch browser and open base url "https://demo.guru99.com/test/login.html"
    When I enter email id as <email> and password as <password>
    And I clicked on login button
    Then I should be successfully logged in
    
    Examples:
      |email    |password  |
      |"gajanan"|"sanap123"|
      |"Ajinkya"|"hiw123"  |
  