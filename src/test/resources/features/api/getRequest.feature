Feature: Get Request

  Scenario: Get all products
    When I GET request 'productsList'
    Then The status code is 200

  Scenario: Get all Brands list
    When I GET request 'brandsList'
    Then The status code is 200

  Scenario: Get User send to email
    When I GET request 'getUserDetailByEmail' and send data
    |email    |   cabernaldo010788@gmail.com|
    Then The status code is 200
