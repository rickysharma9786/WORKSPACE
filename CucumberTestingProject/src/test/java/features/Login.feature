Feature: Login to the application under test.

 Verify if user is able to Login in to the site r not

Scenario: Login to the application Linkedin.com

	Given Open Chrome browser and launch the application
	When User click on the SignIn Button
	When User enters the username and password onto the UserName and password field
	When  User clicks on the Login button
	Then Validate if the user login is successful
	Then Close the browser