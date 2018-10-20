package com.mycompany.assignment1.main;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.NullPointerException;
import static com.mycompany.assignment1.main.Read.read;

public class Convert {

    public static void convert() throws IOException {
        System.out.println("Creating Excel File...");
        
        //determine file location
        File fileName = new File("C:\\Users\\Acer\\Documents\\NetBeansProjects\\Assignment1\\wikipedia.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Information of Malaysia");

        try {
            // Parse Data into Excel File
            int r = 0;
            for (Data data : read()) {
                Row row = sheet.createRow(r++);
                Cell c1 = row.createCell(0);
                c1.setCellValue(data.getC1());
                Cell c2 = row.createCell(1);
                c2.setCellValue(data.getC2());
            }
            
            // resize the cells
            for (int i = 0; i < 24; i++) {
                sheet.autoSizeColumn(i);
            }
            // create excel file
            FileOutputStream output = new FileOutputStream(fileName);
            workbook.write(output);
            output.close();
            System.out.println("Success!");
            System.out.println("File Location: " + fileName);
        } catch (FileNotFoundException | NullPointerException e) {
            e.printStackTrace();
            System.out.println("Fail!");
        }
    }

}

