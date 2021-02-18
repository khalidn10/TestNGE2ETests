Feature: Application Navigation

Scenario Outline: Navigate through application
Given user is on landing page
When user presses login button
#Other method of parameterisation
#And user logs into application with username one@somewhere.com and password password1
And user logs into application with <username> and <password>
Then home page is displayed

Examples:
|username				|password	|
|one@somewhere.com abc	|12345		|
|two@somewhere.com abc	|54321		|