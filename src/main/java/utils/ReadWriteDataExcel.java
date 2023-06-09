package utils;


import org.apache.poi.ss.usermodel.*;


public class ReadWriteDataExcel {
    public ReadWriteDataExcel() {}
    public static void verifyDataInExcelBookAll(Workbook workbook1, Workbook workbook2, int columnNumForFirst, int columnNumForSecond) {
        // Since we have already verified that both work books have same number of sheets so iteration can be done against any workbook sheet count
        int sheetCounts = workbook1.getNumberOfSheets();
        // So we will iterate through sheet by sheet
        for (int i = 0; i < sheetCounts; i++) {
            // Get sheet at same index of both work books
            Sheet s1 = workbook1.getSheetAt(i);
            Sheet s2 = workbook2.getSheetAt(i);
            // Iterating through each row
            int rowCounts = s1.getPhysicalNumberOfRows();

            for (int j = 0; j < rowCounts; j++) {
                // Iterating through each cell
                int cellCounts = s1.getRow(j).getPhysicalNumberOfCells();

                // Getting individual cell
                Cell c1 = s1.getRow(j).getCell(columnNumForFirst);
                Cell c11 = s2.getRow(j).getCell(columnNumForSecond);

                String v1 = "";
                String v11 = "";
                    // Since cell have types and need to use different methods
                    if (c1.getCellType() == CellType.STRING) {
                        v1 = c1.getStringCellValue();
                        v11 = c11.getStringCellValue();
                    }
                    if (v1.equals(v11)) {
                        ScenarioCache.getCacheScenario().log("its matched : " + v1 + "  --> with -->" + v11);
                    } else {
                        ScenarioCache.getCacheScenario().log("its not matched : " + v1 + " with " + v11);
                    }
                }
            }
        }











}

