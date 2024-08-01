Feature: Non regression scenarios

  @ISTQB_QUIZZ_SCENARIO
  Scenario: ISTQB
    Given I connect to Hightest
    And I go to the ToolBox section
    And I select the ISQTB french quizz
    When I take the French ISTQB Quizz and all my answers are good
    And I give Julien Baroni's email for him to receive the results
    Then content of the header shows message : "Parfait !"

  @CONTACT_MANDATORY_FIELDS_SCENARIO
  Scenario: Mandatory fields
    Given I connect to Hightest
    And I go to the contact section
    When I try to submit a message without filling the mandatory fields
    Then error messages are displayed below the mandatory input fields stating : "Ce champ est obligatoire."

  @CONTACT_INVALID_EMAIL_SCENARIO
  Scenario: Email Format
    Given I connect to Hightest
    And I go to the contact section
    When I try to submit a message without filling the email field with a well formated email
    Then an error message is displayed below the email input field stating : "L’adresse e-mail n’est pas valide."

  @CONTACT_CONFIDENTIALITY_POLICY_NOT_ACCEPTED
  Scenario: Confidentiality policy
    Given I connect to Hightest
    And I go to the contact section
    When I try to submit a message without accepting the confidentiality policy
    Then the submit button is disabled and sending a message is not possible