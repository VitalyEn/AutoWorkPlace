package com.autoWorkPlace;

import com.autoWorkPlace.FileIo;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ExcelDocument extends FileIo {
    private final String exelFile;
    private ArrayList listRow = new ArrayList();
    private InputStream in = null;
    private XSSFWorkbook wb = null;
    private String sheetName = "";
    private int rowLength = 0;

    public ExcelDocument() {
        //FileIo file = new FileIo();
        FileNameExtensionFilter filter = new FileNameExtensionFilter( "Документ MS Exel, xlsx","xlsx");
        this.chooseFile(filter);
        this.exelFile = this.getFileName();
    }

    public void readStart(){
        //System.out.println(name);
        try {
            this.in = Files.newInputStream(Paths.get(this.exelFile));
            this.wb = new XSSFWorkbook(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.sheetName = wb.getSheetName(0);
        this.rowLength = wb.getSheet(sheetName).getRow(0).getLastCellNum();
    }

    public ArrayList readRow(int row) {
            //String result = "";
        this.listRow.clear();
            int i = 0;
            String cell;
            if (this.wb == null) this.readStart();
            //String cell = wb.getSheet(sheetName).getRow(0).getCell(i).toString();
           //System.out.println(cell);
        if(this.wb.getSheet(this.sheetName).getRow(row) == null) return null;
            for (i = 0; i < this.rowLength; i++){
                if (this.wb.getSheet(this.sheetName).getRow(row).getCell(i) == null) cell = "";
                else
                    cell = this.wb.getSheet(this.sheetName).getRow(row).getCell(i).toString();

                    //System.out.println(cell);
                    this.listRow.add(cell);
                    //System.out.println(row);
                    ///System.out.println(listRow);

            }
            return listRow;
    }
}

