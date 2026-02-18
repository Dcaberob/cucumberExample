Feature: Get Request

  Scenario: Get all products
    When I Get request
    Then I expect 200 status code