#----------Scenario for Login
# Verify user can Login with valid email, Valid password
# Verify user can't Login with valid email, invalid password
# Verify user can't login with invalid email, valid password
# Verify user can't Login with invalid email, invalid password
# Verify user can't Login with blank email, blank password
# Verify user can't Login with valid email, blank password
# Verify user can't Login with blank email, valid password

#----------Scenario for Register
# Verify user can Register with valid email, valid password, valid confirm password
# Verify user can't Register with an already registered email
# Verify user can't Register with valid email, valid password, invalid confirm password
# Verify user can't Register with valid email, invalid password, valid confirm password
# Verify user can't Register with invalid email, invalid password, invalid confirm password
# Verify user can't Register with invalid email, valid password, invalid confirm password
# Verify user can't Register with invalid email, invalid password, valid confirm password
# Verify user can't Register with blank email
# Verify user can't Register with blank password
# Verify user can't Register with blank confirm password
# Verify user can't Register with blank first name
# Verify user can't Register with blank last name
# Verify user can't Register with blank telephone number

Feature: login

  @smoke
  Scenario Outline: verify user can login with valid email/password
    Given I am on home page
    When I click on Log in "Log in"
    And I see login pop up saying "Sign in to your account"
    And I enter email <email>
    And I enter password <password>
    And I click on Sign in button
    Then I see the welcome message <message>
    Then I see My Account icon "My Account"

    Examples:
      | email               | password | message                                                 |
      | kamranbcs@yahoo.com | zorozoro | Welcome MUHAMMAD KAMRAN You are successfully logged in! |

  @smoke
  Scenario Outline: verify user can't login with valid email, invalid password
    Given I am on home page
    When I click on Log in "Log in"
    And I see login pop up saying "Sign in to your account"
    And I enter email <email>
    And I enter password <password>
    And I click on Sign in button
    Then I see the invalid email or password message <message>

    Examples:
      | email               | password | message                                                     |
      | kamranbcs@yahoo.com | 12345678 | Invalid email or password. Please try again. Attempt 1 of 3 |
      | kamranbcs@yahoo.com | 87654321 | Invalid email or password. Please try again. Attempt 2 of 3 |
