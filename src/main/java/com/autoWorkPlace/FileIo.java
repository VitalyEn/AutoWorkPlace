package com.autoWorkPlace;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class FileIo {
    private String fileName;
    private String textData;
    private final List<String> fileContent = new ArrayList<>();

    public FileIo(String fileName){
        this.fileName = fileName;
    }

    public FileIo(){}

    public void chooseFile(FileNameExtensionFilter filter) {
        JFileChooser fileOpen = new JFileChooser();
        fileOpen.setFileFilter(filter);
        int ret = fileOpen.showDialog(null, "Открыть файл");

        if (ret == JFileChooser.APPROVE_OPTION) {
            this.fileName = fileOpen.getSelectedFile().getAbsolutePath();
        }
    }

    public boolean writeToFile(String textData){
        this.textData = textData;
        try {
            FileWriter writer = new FileWriter(fileName, true);
            writer.write(textData);
            writer.append('\n');
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    public void readFromFileToList(){
        try {
            InputStreamReader fr = new InputStreamReader(new FileInputStream(fileName), StandardCharsets.UTF_8);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null){
                this.fileContent.add(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getTextData() {
        return textData;
    }

    public void setTextData(String textData) {
        this.textData = textData;
    }

    public String getFileContent(int i) {
        return fileContent.get(i);
    }

    public int getContentSize(){
        return fileContent.size();
    }
}
