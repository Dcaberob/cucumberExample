Feature: Get Request

  Scenario: Get all products
    When I GET request 'productList'
    Then The status code is 200