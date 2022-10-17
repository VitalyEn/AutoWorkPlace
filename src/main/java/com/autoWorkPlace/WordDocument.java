package com.autoWorkPlace;

import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class WordDocument extends FileIo{
    private String docText;
    private String docFileName;

    public WordDocument(String docFileName){
        this.docFileName = docFileName;
    }

    public WordDocument(){
        //FileIo file = new FileIo();
        FileNameExtensionFilter filter = new FileNameExtensionFilter( "Документ MS Word, docx","docx");
        this.chooseFile(filter);
        this.docFileName = this.getFileName();
    }

    public void setDocText(String docText){
        this.docText = docText;
    }

    public String getDocFromFile(){
        try (XWPFDocument doc = new XWPFDocument(
                 Files.newInputStream(Paths.get(this.docFileName)))) {
            XWPFWordExtractor xwpfWordExtractor = new XWPFWordExtractor(doc);
            this.docText = xwpfWordExtractor.getText();
            return this.docText;
        } catch (IOException e) {
            e.printStackTrace();
            return e.toString();
        }
    }

    public void setDocFileName(String docFileName){
        this.docFileName = docFileName;
    }

    public String getDocText(){
        return this.docText;
    }

    public String replaceAndWrite(String[] template, String[] target) throws IOException {
        //System.out.println(docFileName);
        try (XWPFDocument doc = new XWPFDocument(
                Files.newInputStream(Paths.get(this.docFileName)))
        ) {

            List<XWPFParagraph> xwpfParagraphList = doc.getParagraphs();
            //Iterate over paragraph list and check for the replaceable text in each paragraph
            for (XWPFParagraph xwpfParagraph : xwpfParagraphList) {
                for (XWPFRun xwpfRun : xwpfParagraph.getRuns()) {
                    String docText = xwpfRun.getText(0);
//System.out.println(xwpfParagraph.getText());
                    //replacement and setting position
                    //System.out.println(template.length+" "+target.length);
                    for (int i = 1; i < target.length; i++) {
                        if(docText!=null) {
                            //System.out.println(docText);
                            docText = docText.replaceAll(template[i], target[i]);
                           // System.out.println(docText);
                            xwpfRun.setText(docText, 0);
                        }
                    }
                }
            }
            // save the docs
            try (FileOutputStream out = new FileOutputStream("contract "+target[1]+".docx")) {
                doc.write(out);
            }
            XWPFWordExtractor xwpfWordExtractor = new XWPFWordExtractor(doc);
            this.docText = xwpfWordExtractor.getText();
            //System.out.println(docText);
            return this.docText;
        }
    }
}





