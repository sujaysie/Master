package ControlImplementation.Utilities;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Hashtable;

public class ExcelDataReader {

    @DataProvider
    public static Object[][] ReadExcelData(String filepath, String filename, String sheetname) throws IOException {
        File file = new File(filepath + "//" + filename);
        FileInputStream fis = new FileInputStream(file);
        Workbook workbook = new XSSFWorkbook(fis);
        //reading from xlsx XSSFWorkbook and reading from xls HSSFWorkbook
        Sheet sheet = workbook.getSheet(sheetname);
        int rowcount = sheet.getLastRowNum();
        System.out.println("row count " + rowcount);
        Object[][] obj = new Object[rowcount][1];
        Hashtable<String, String> record = null;
        for (int r = 1; r <= rowcount; r++) {
            record = new Hashtable<String, String>();
            Row headerRow = sheet.getRow(0);
            Row row = sheet.getRow(r);
            for (int s = 0; s < row.getLastCellNum(); s++) {
                String key = headerRow.getCell(s).getStringCellValue();
                String value = row.getCell(s).getStringCellValue();
                System.out.println(key + " > " + value);
                record.put(key, value);
                Cell cell = row.getCell(s);
            }

            obj[r - 1][0] = record;
            System.out.println(obj[r - 1][0]);
            System.out.println("");
        }
        return obj;
    }
   /* public static void main(String[] args){
        Object[][] obj = null;
        try {
            obj = ExcelDataReader.getTestData("D:\\TestAutothon\\src\\test\\java\\TestData", "Movies.xlsx", "data");
        }catch (Exception e){
            e.printStackTrace();
        }
    }*/
}