Feature: Hamster training

  Scenario: Hamster repeats trick immediately after reward
    Given a trained hamster
    When I make the hamster jump through a burning loop
    And I reward him with a honey cracker
    Then the hamster will be happy
    And the hamster will be ready to just do it again

  Scenario: Missing reward disappoints the hamster
    Given a trained hamster
    When I make the hamster jump through a burning loop
    And I do not react
    Then the hamster will be sad
    And the hamster will decline another jump
