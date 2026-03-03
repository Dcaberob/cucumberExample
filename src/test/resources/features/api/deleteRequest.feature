Feature: Delete request

  @createUser
  Scenario: Delete a user account
    When I DELETE request 'deleteAccount' and send data
      | email    | cabernaldo010788@gmail.com |
      | password | Test1234                   |
    Then The status code is 200