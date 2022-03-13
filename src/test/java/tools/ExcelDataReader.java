package tools;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelDataReader {



    public static String[][] getExceldata(File filename,String sheetname) throws IOException {
        FileInputStream fis = new FileInputStream(filename);
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheet(sheetname);
        int noOfRows = sheet.getPhysicalNumberOfRows();
        String[][] data = new String[noOfRows-1][2];
        DataFormatter df = new DataFormatter();
        for (int i = 0; i < noOfRows-1; i++) {
            for (int j = 0; j < 2; j++) {
                data[i][j] = df.formatCellValue(sheet.getRow(i+1).getCell(j)).toString();

            }
        }
//        for (String[] val : data) {
//            System.out.println("vals" + Arrays.toString(val));
//
//        }
        wb.close();
        fis.close();
        return data;
    }

}
