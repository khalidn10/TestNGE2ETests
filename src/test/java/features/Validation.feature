Feature: Application Validation

Scenario: Validate landing page
Given user is on landing page
Then "Featured Courses header" is displayed in "landing" page

Scenario: Validate login page
Given user is on landing page
When user presses login button
Then "Create an Account link" is displayed in "login" page