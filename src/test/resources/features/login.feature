Feature: Login Functionality

  Background: 
    Given open "chrome" browser
    When launch site
    #When navigate to login page
    Then verify login page is displayed

  Scenario Outline: Login with valid username and valid password
    When enter valid username "<username>" into username field
    And enter valid password "secret_sauce" into password field
    And click on login button
    And verify login success
    Then close browser

    Examples: 
      | username                |
      | standard_user           |
      | problem_user            |
      | performance_glitch_user |

  Scenario: Login with invalid username and valid password
    When enter invalid username "ravinder" into username field
    Then enter valid password "secret_sauce" into password field
    And click on login button
    And verify login failure
    Then close browser

  Scenario: Login with valid username and invalid password
    When enter valid username "standard_user" into username field
    Then enter invalid password "xyz@123" into password field
    And click on login button
    And verify login failure
    Then close browser

  Scenario: Login with valid username and blank password
    When enter valid username "performance_glitch_user" into username field
    Then enter blank password into password field
    And click on login button
    And verify login failure
    Then close browser

  Scenario: Login with blank username and valid password
    When enter blank username into username field
    Then enter valid password "secret_sauce" into password field
    And click on login button
    And verify login failure
    Then close browser
