Feature: Validate update user endpoint
  Scenario: verify creation of new user
    Given user wants to call "/users" end point
    And set header type "Authorization" to "Bearer.token"
    And set header type "Content-Type" to "application/json"
    And set request body from the file "Create_User.json"
    When user perform post call
    Then verify status code is 201
    And verify user id is not empty
    And user stores created user id into "user.id";
    And user wants to call "/users/@id" end point
    And set request body from the file "Update_User.json"
    When user perform put call
    Then verify status code is 200