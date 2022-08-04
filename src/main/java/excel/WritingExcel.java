package excel;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: khamza@nightwell-logistics.com
 * Date: 7/30/2022
 * Time: 3:03 PM
 */

// WORK --> Sheet --> Rows --> Cells
public class WritingExcel {
    public static void main(String[] args) throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Employee Info");

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(101L, "John", "Engineer"));
        employees.add(new Employee(102L, "Alex", "Manager"));
        employees.add(new Employee(103L, "Smith", "Developer"));

        int rows = employees.size();
        int cells = 3;

        for (int i = 0; i < employees.size(); i++) {
            HSSFRow row = sheet.createRow(i);

            Employee employee = employees.get(i);
            row.createCell(0).setCellValue(employee.getId());
            row.createCell(1).setCellValue(employee.getName());
            row.createCell(2).setCellValue(employee.getJob());
        }

        String filePath = "src/main/resources/employee.xls";
        FileOutputStream fileOutputStream = new FileOutputStream(filePath);
        workbook.write(fileOutputStream);
        fileOutputStream.close();
        System.out.println("Employee saved!");

    }
}
