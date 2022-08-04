package excel;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

/**
 * Author: khamza@nightwell-logistics.com
 * Date: 7/30/2022
 * Time: 12:40 PM
 */
public class ReadingExcel {
    public static void main(String[] args) throws IOException {
        String excelPath = "src/main/resources/Capital_Cities.xls";

        FileInputStream inputStream = new FileInputStream(excelPath);
        HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
        HSSFSheet sheet = workbook.getSheetAt(0);

        /// FOR LOOP   ////
        int rows = sheet.getLastRowNum();
        int cells = sheet.getRow(1).getLastCellNum();

        for (int i = 0; i < rows; i++) {
            HSSFRow row = sheet.getRow(i);
            for (int j = 0; j < cells; j++) {
                HSSFCell cell = row.getCell(j);
                CellType cellType = cell.getCellType();

                switch (cellType) {
                    case STRING:
                        System.out.print(cell.getStringCellValue()+ "\t");break;
                    case NUMERIC:
                        System.out.print(cell.getNumericCellValue()+ "\t");break;
                    case BOOLEAN:
                        System.out.print(cell.getBooleanCellValue()+ "\t");
                        break;
                }
            }
            System.out.println();
        }

    }
}
