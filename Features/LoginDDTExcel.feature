Feature: Login Data Driven with Excel

  Scenario Outline: Login Data Driven Excel
    Given User Launch browser
    And opens URL "http://localhost/opencart/upload/"
    When User navigate to My Account menu
    And click on Login
    Then check User navigates to My Account Page by passing Email and Password with excel row "<row_index>"

    Examples:
      |row_index|
      |1|
      |2|
      |3|
