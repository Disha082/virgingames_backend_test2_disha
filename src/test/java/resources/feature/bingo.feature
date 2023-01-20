Feature: VirginGames

  Scenario: I want to test the data of the virgin games bingo api
    When I send Get request to the Lobby feed endpoint
    And I get Valid Status code "200"
    Then I verify streamName is Adventure



