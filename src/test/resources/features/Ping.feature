Feature: Send ping issue command


@Test098
  Scenario Outline: Search Meter number
    Given open the browser
    When search from <SheetName> and <MeterRow> for meter number
    Then Appeared with expected result
    Examples:
      | SheetName   | MeterRow |
      | Information | 1        |
      | Information | 0        |
      | Information | 2        |




