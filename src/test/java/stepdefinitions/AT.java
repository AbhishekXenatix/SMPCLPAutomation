package stepdefinitions;

import org.apache.commons.io.FileUtils;
import utils.WebUI;

import java.io.*;
import java.nio.file.Files;

public class AT {

    public static String fromCommandCenterExcelFiles= "C:\\Users\\Abhishek_Gupta3\\Downloads\\TestDataDemo\\Mtr_10001528_Hist.xlsx";
    public static String fromLogsColumn ="C:\\Users\\Abhishek_Gupta3\\Downloads\\TestDataDemo\\LP2-10001528.xlsx";
    public static String  toAzureCloud="AllFiles";

    public static void main(String[] args)  {
        copy(fromCommandCenterExcelFiles, toAzureCloud);
         copy(fromLogsColumn, toAzureCloud);

    }

    public static void copy(String from , String to)  {
        File srcFile = new File(from);
        if (srcFile.exists()){
            File destFile = new File(to + File.separator + srcFile.getName());
           try (InputStream is = new FileInputStream(srcFile); OutputStream os = new FileOutputStream(destFile)){
               int len ;
               float srcFileSize = is.available() / 1000.0f;
               float totalCopied = 0.0f;
               byte[] srcBytes = new byte[102400];
               while ((len = is.read(srcBytes)) > 0){
                   os.write(srcBytes, 0, len);
                   totalCopied += len;
                   System.out.println("\rCopied.." +totalCopied / 1000.0f + "kb/" +srcFileSize + "kb");
                   WebUI.sleep(1);
               }
                } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }











}
