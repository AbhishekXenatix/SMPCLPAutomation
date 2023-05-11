Feature: Send ping issue command
  Scenario: open browser and send command
    Given open the site url
    When send issue command
    Then The report window appeared with expected result
