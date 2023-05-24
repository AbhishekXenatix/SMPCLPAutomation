Feature: Send ping issue command
  Scenario: open browser and send command
    Given open the site url
    When send issue command
    Then The report window appeared with expected result


#
#  Scenario Outline: Search Meter number
#    Given open the browser
#    When search from <SheetName> and <MeterRow> for meter number
#    Then Appeared with expected result
#    Examples:
#      | SheetName   | MeterRow |
#      | Information | 1        |
#      | Information | 0        |
#      | Information | 2        |




