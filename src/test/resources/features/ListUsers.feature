Feature: Validate user can get list of users
  Scenario: verify users list is displayed
    Given user wants to call "/users" end point
    And set header type "Authorization" to "Bearer.token"
    When user perform get call
    Then verify status code is 200