Feature: Selenium Action class scenarios

  @tag1
  Scenario: Validate mouse hour and click action
    Given I launch browser and open base url "http://demo.guru99.com/test/newtours/"
    And I validate the background color of home element
    When I mouseOver the Home link
    Then the background colour of link home should be changed
    