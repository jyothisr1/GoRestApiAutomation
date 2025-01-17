Feature: Validate delete user endpoint
  Scenario: verify deleting an user
    Given user wants to call "/users" end point
    And set header type "Authorization" to "Bearer.token"
    And set header type "Content-Type" to "application/json"
    And set request body from the file "Create_user.json"
    When user perform post call
    Then verify status code is 201
    And verify user id is not empty
    And user stores created user id into "user.id";
    And user wants to call "/users/@id" end point
    When user perform delete call
    Then verify status code is 204