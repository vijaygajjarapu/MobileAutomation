@emailScreen @registration
Feature: To verify the Email screen in the Registration flow for IEHP user

  @emailScreen @smoke
  Scenario: Verify the Email screen in the Registration flow

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


