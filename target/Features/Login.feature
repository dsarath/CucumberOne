Feature: LoginFeature
  This feature deals with the login functionality of the application

	Scenario: Login with the correct username and password
    Given I navigate to the login page
    And I enter the username as admin and password as password
    When I click login button
    Then I should see the userform page

  Scenario: Login with the correct username and password using dataTable
    Given I navigate to the login page
    And I enter the data for login
      | username | password      |
      | admin    | adminPassword |
    When I click login button
    Then I should see the userform page

  Scenario Outline: Login with the correct username and password using scenario outline
    Given I navigate to the login page
    And I enter <username> and <password>
    When I click login button
    Then I should see the userform page

    Examples: 
      | username | password      |
      | admin    | adminPassword |
      | teste    | teste         |
