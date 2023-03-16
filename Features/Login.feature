Feature: Login with Valid Credentials

# ctrl+shift+f-alighnment/pretty format[For commenting in feature file we use #]
@sanity 
 Scenario: Successful Login with Credentials
   Given User Launch browser
   And opens URL "http://localhost/opencart/upload/"
   When User navigate to My Account menu
   And click on Login 
   And User enters Email as "wtraining1@gmail.com" and Password as "wt1wt2@"
   And Click on Login button 
   Then User navigates to MyAccount Page
 
 
 