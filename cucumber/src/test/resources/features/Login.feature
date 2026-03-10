Feature:login functionality:
	Scenario:Successful login with valid credentials(Email:"abc@gmail.com",Password:"abcdef")
		Given use is navigated to the login page
		When user enters valid credentials
		Then user should be navigated to home page