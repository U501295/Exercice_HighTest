Feature: Send email with results

  @Exercice
  Scenario: good answers
    Given I connect to Hightest
    And I go to the ToolBox section
    When I take the French ISTQB Quizz and all my answers are good
    And I give Julien Baroni's email for him to receive the results
    When I connect to LinkedIn
    And I open the results Julien Baroni sent me
    Then then content of the results indicates "20 question(s) sur 20, soit 100 % de réussite"