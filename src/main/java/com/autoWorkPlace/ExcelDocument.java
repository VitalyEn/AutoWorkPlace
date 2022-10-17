package com.autoWorkPlace;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ExcelDocument extends FileIo{
    private final String exelFile;
    private ArrayList listRow = new ArrayList();

    public ExcelDocument() {
        //FileIo file = new FileIo();
        FileNameExtensionFilter filter = new FileNameExtensionFilter( "Документ MS Exel, xlsx","xlsx");
        this.chooseFile(filter);
        this.exelFile = this.getFileName();
    }

    public ArrayList readRow(int row, int rowLength) {
            //String result = "";
            InputStream in = null;
            XSSFWorkbook wb = null;
            this.listRow.clear();
            //System.out.println(name);
            try {
                in = Files.newInputStream(Paths.get(this.exelFile));
                wb = new XSSFWorkbook(in);
            } catch (IOException e) {
                e.printStackTrace();
            }
        String sheetName = wb.getSheetName(0);
            int i = 0;
            String cell;
            //String cell = wb.getSheet(sheetName).getRow(0).getCell(i).toString();
           //System.out.println(cell);
        if(wb.getSheet(sheetName).getRow(row) == null) return null;
            for (i = 0; i < rowLength; i++){
                if (wb.getSheet(sheetName).getRow(row).getCell(i) == null) cell = "";
                else
                    cell = wb.getSheet(sheetName).getRow(row).getCell(i).toString();

                    //System.out.println(cell);
                    this.listRow.add(cell);
                    //System.out.println(row);
                    ///System.out.println(listRow);

            }
            return listRow;
    }
}

