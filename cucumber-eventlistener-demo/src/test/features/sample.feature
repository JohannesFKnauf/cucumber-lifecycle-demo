Feature: Addition
  Calculator is able to add numbers
  
  Scenario: Small integers
    Given a calculator c
    And an entered number 2
    When adding 2
    Then a result of 4 is returned
