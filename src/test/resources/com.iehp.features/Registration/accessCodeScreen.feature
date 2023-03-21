@registration @accessCodeScreen
Feature: To complete the registration flow for IEHP user

  @accessCodeScreen @smoke
  Scenario: Navigate to registration step 1

    Given User tap "gettingStarted" button in "Registration" page
    And  User fills "iehpNumber" text field in "Registration" page
    And User tap "dateOfBirth" button in "Registration" page
    And User select "dateOfBirth" in "Common" page
    Then User tap "confirm" button in "Registration" page
    And User tap "termsAndConditions" button in "Registration" page
    And User tap "nextInIEHP" button in "Registration" page
    And User fills "emailAddress" text field in "Registration" page
    And User fills "confirmEmailAddress" text field in "Registration" page
    And User tap "emailAddress" button in "Registration" page
    Then User taps "emailHeader" button in "Registration" page
    Then User tap "nextInEmail" button in "Registration" page
    And User fills "password" text field in "Registration" page
    And User fills "confirmPassword" text field in "Registration" page
    Then User tap "password" button in "Registration" page
    Then User taps "passwordHeader" button in "Registration" page
    Then User tap "submitButton" button in "Registration" page
    And User enters "ssnOrPhone" using common page
    Then User taps "verificationHeader" button in "Registration" page
    And User tap "nextInEmail" button in "Registration" page
    Then Verify "accessCodeScreenHeader" text is displayed in "Registration" page
    And User fills "accessCode" text field in "Registration" page
    Then User taps "accessCodeScreenHeader" button in "Registration" page


