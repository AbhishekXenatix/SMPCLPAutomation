package utils;



import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;



import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class CompareExcel{
    //static Logger log = Logger.getLogger(String.valueOf(CompareExcel.class));
   static Log log= new Log();

   public static void VerifyExcel() throws IOException {


        ExtentReports extentReports = new ExtentReports();
        File file = new File(System.getProperty("user.dir"),"Reports/CucumberReports/ExtentReport.html");
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
        extentReports.attachReporter(sparkReporter);

       // FileInputStream fileInputStream1 = new FileInputStream("FilesExcel\\LP114004656.xlsx");
        FileInputStream fileInputStream1 = new FileInputStream("AllFiles\\LP2-10001528.xlsx");
        XSSFWorkbook workbook1 = new XSSFWorkbook(fileInputStream1);
        //XSSFSheet worksheet1 = workbook1.getSheet("LP 14004656");
        XSSFSheet worksheet1 = workbook1.getSheet("001");
        int rowCount1= worksheet1.getPhysicalNumberOfRows();
        WebUI.sleep(1);

        //FileInputStream fileInputStream2 = new FileInputStream("FilesExcel\\Interval Data Export-14004656.xlsx");
        FileInputStream fileInputStream2 = new FileInputStream("AllFiles\\Mtr_10001528_Hist.xlsx");
        XSSFWorkbook workbook2 = new XSSFWorkbook(fileInputStream2);
        //XSSFSheet worksheet2 = workbook2.getSheet("Intervals-14004656");
        XSSFSheet worksheet2 = workbook2.getSheet("Mtr_10001528_Hist");
        int rowCount2= worksheet2.getPhysicalNumberOfRows();
        WebUI.sleep(1);



        if(rowCount1 == rowCount2) {
            for (int i = 1; i < rowCount1; i++) {
                XSSFRow row1 = worksheet1.getRow(i);
                XSSFRow row2 = worksheet2.getRow(i);
                //------------------------------ Exp Wh Total and +kWh --------------------------
                String ExPWhTotal = "";
                XSSFCell ExpWh = row1.getCell(2);

                if (ExpWh != null) {
                    ExpWh.setCellType(CellType.STRING);
                    ExPWhTotal = ExpWh.getStringCellValue();
                }
                String kWhTotal = "";
                XSSFCell kWh = row2.getCell(3);

                if (kWh != null) {
                    kWh.setCellType(CellType.STRING);
                    kWhTotal = kWh.getStringCellValue();

                   // String formula = kWh.getStringCellValue();
                   // System.out.println(formula);

                    try {
                        //Double num = Double.valueOf(formula);
                        //Long j = Math.round(num*1);
                        //kWhTotal = Long.toString(j);
                    }catch (NumberFormatException exception){
                        exception.printStackTrace();
                    }

                }

                if(!ExPWhTotal.equals(kWhTotal))
                {
                   // System.out.println("[ERROR] :"+"Diference found for id (Sheet1) " + idstr1 + "| Sheet 1 id = " + idstr1+ " | Sheet 2 id = " + idstr2);

                    log.info("Diference for ExpWh (Sheet1) " + ExPWhTotal +  "| Sheet 2 +kWh = " + kWhTotal);
                   // System.out.println("Diference for ExpWh (Sheet1) " + ExPWhTotal + "  Sheet 1 ExpWh = " + ExPWhTotal+ "| Sheet 2 +kWh = " + kWhTotal);
                    extentReports.createTest("Check the Result").
                            log(Status.INFO,"[Processing] :"+"ExPWhTotal " + ExPWhTotal + "=> Sheet1 ExPWhTotal  = " + ExPWhTotal+ " Sheet 2 kWh = " + kWhTotal);
                   extentReports.flush();

                }
                else if (ExPWhTotal.equals(kWhTotal))
                {

                    //extentReports.createTest("Check the Result").
                    //log(Status.INFO,"[Processing] :"+"ExPWhTotal " + ExPWhTotal + "=> Sheet1 ExPWhTotal  = " + ExPWhTotal+ " Sheet 2 kWh = " + kWhTotal);
                    //extentReports.flush();
                    //Desktop.getDesktop().browse(new File("Reports/CucumberReports/ExtentReport.html").toURI());
                    // System.out.println("[Processing] :"+"ID " + idstr1 + "=> Sheet 1 id = " + idstr1+ " Sheet 2 id = " + idstr2);
                    log.info("[Processing] :"+"ExPWhTotal " + ExPWhTotal + "=> Sheet1 ExPWhTotal  = " + ExPWhTotal+ " Sheet 2 kWh = " + kWhTotal);
                   // System.out.println("\"[Processing] :\"+\"ExPWhTotal \" + ExPWhTotal + \"=> Sheet1 ExPWhTotal  = \" + ExPWhTotal+ \" Sheet 2 kWh = \" + kWhTotal");

                }


                //------------------------------ End ID ---------------------------------

                // ------------------------------ comapring Name --------------------------
               /* String namestr1 = "";
                XSSFCell name1 = row1.getCell(1);
                if (name1 != null) {
                    name1.setCellType(CellType.STRING);
                    namestr1 = name1.getStringCellValue();
                }


                String namestr2 = "";
                XSSFCell name2 = row2.getCell(1);
                if (name2 != null) {
                    name2.setCellType(CellType.STRING);
                    namestr2 = name2.getStringCellValue();
                }

                if(!namestr1.equals(namestr2))
                {
                    System.out.println("[ERROR] :"+"Diference found for id (Sheet1) " + idstr1 + " | Sheet 1 name = " + namestr1+ "| Sheet 2 name = " + namestr2);
                    //test.log(LogStatus.ERROR,"Diference for id (Sheet1) " + idstr1 + " | Sheet 1 name = " + namestr1+ "| Sheet 2 name = " + namestr2);
                }
                //------------------------------ End Name Comparison---------------------------------

                // ------------------------------ comapring branch --------------------------
                String branchstr1 = "";
                XSSFCell branch1 = row1.getCell(2);
                if (branch1 != null) {
                    branch1.setCellType(CellType.STRING);
                    branchstr1 = branch1.getStringCellValue();
                }


                String branchstr2 = "";
                XSSFCell branch2 = row2.getCell(2);
                if (branch2 != null) {
                    branch2.setCellType(CellType.STRING);
                    branchstr2 = branch2.getStringCellValue();
                }

                if(!branchstr1.equals(branchstr2))
                {
                    System.out.println("[ERROR] :"+"Diference found for id (Sheet1) " + idstr1 + "| Sheet 1 branch = " + branchstr1+ "| Sheet 2 branch = " + branchstr2);
                   // test.log(LogStatus.ERROR,"Diference for id (Sheet1) " + idstr1 + "| Sheet 1 branch = " + branchstr1+ "| Sheet 2 branch = " + branchstr2);
                }
                //------------------------------ End branch Comparison---------------------------------

                // ------------------------------ comapring marks --------------------------
                String marksstr1 = "";
                XSSFCell marks1 = row1.getCell(3);
                if (marks1 != null) {
                    marks1.setCellType(CellType.STRING);
                    marksstr1 = marks1.getStringCellValue();
                }


                String marksstr2 = "";
                XSSFCell marks2 = row2.getCell(3);
                if (marks2 != null) {
                    marks2.setCellType(CellType.STRING);
                    marksstr2 = marks2.getStringCellValue();
                }

                if(!marksstr1.equals(marksstr2))
                {
                    System.out.println("[ERROR] :"+"Diference found for id (Sheet1) " + idstr1 + " | Sheet 1 marks = " + marksstr1+ " | Sheet 2 marks = " + marksstr2);
                   // test.log(LogStatus.ERROR,"Diference for id (Sheet) " + idstr1 + " | Sheet 1 marks = " + marksstr1+ " | Sheet 2 marks = " + marksstr2);
                }
                //------------------------------ End marks Comparison---------------------------------

                // ------------------------------ comapring city --------------------------
                String citystr1 = "";
                XSSFCell city1 = row1.getCell(4);
                if (city1 != null) {
                    city1.setCellType(CellType.STRING);
                    citystr1 = city1.getStringCellValue();
                }


                String citystr2 = "";
                XSSFCell city2 = row2.getCell(4);
                if (city2 != null) {
                    city2.setCellType(CellType.STRING);
                    citystr2 = city2.getStringCellValue();
                }

                if(!citystr1.equals(citystr2))
                {
                    System.out.println("[ERROR] :"+"Diference found for id (Sheet1) " + idstr1 + " | Sheet 1 city = " + citystr1+ " | Sheet 2 city = " + citystr2);
                   // test.log(LogStatus.ERROR,"Diference for id (Sheet1) " + idstr1 + " | Sheet 1 city = " + citystr1+ " | Sheet 2 city = " + citystr2);
                }*/
                //------------------------------ End city Comparison---------------------------------

              // System.out.println("[Processing] :"+"ID " + idstr1 + "=> Sheet 1 id = " + idstr1+ " Sheet 2 id = " + idstr2);

            }

           log.info("Completed Successfully");


        }

        else {
           // test.log(LogStatus.ERROR,"Row count 1=" + rowCount1 + " Rocunt 2 = " + rowCount2);

            System.out.println("Row count 1=" + rowCount1 + " Rocunt 2 = " + rowCount2);
        }


    }
}