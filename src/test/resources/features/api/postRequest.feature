Feature: Post Request

  Scenario: Post search product
    When I POST request 'searchProduct' and send body
      | search_product | top |
    Then The status code is 200

#    implement the after hook delete user
  Scenario: Create a user account
    When I POST request 'createAccount' and send body
      | name          | test                       |
      | email         | cabernaldo010788@gmail.com |
      | password      | test123                    |
      | title         | Mr                         |
      | birth_date    | 01                         |
      | birth_month   | 07                         |
      | birth_year    | 1988                       |
      | firstname     | test                       |
      | lastname      | automation                 |
      | company       | test automation            |
      | address1      | street test                |
      | country       | unite states               |
      | zipcode       | 0000                       |
      | state         | cba                        |
      | city          | cba                        |
      | mobile_number | 001112255                  |
    Then The status code is 200
    Then The body contain
      | responseCode | 201           |
      | message      | User created! |