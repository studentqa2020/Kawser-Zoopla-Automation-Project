Feature: Zoopla Automation

Background: User is Logged In
Given User is on Zoopla Webpage
When User click on Signin Buton
And User Enters Credentials and Submit Login
Then User logged in
		 
Scenario: Search Property
Given User is on Search Property page
When User Enters City Name and Search Properties
Then User gets the Properties page
When User Display all Properties prices in desc order
And User Selects Fifth Property
And User Verify Logo
And  User Display Agent name and Phone Num
And User clicks on Sign out button
Then User Signs Out