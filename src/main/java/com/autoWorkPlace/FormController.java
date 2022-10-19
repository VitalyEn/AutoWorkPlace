package com.autoWorkPlace;

import com.autoWorkPlace.Accaunt;
import com.autoWorkPlace.ExcelDocument;
import com.autoWorkPlace.WordDocument;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

public class FormController implements Initializable {
    public ObservableList<com.autoWorkPlace.Accaunt> opData = FXCollections.observableArrayList();
    private Integer id;
    private String firstName;
    private String secondName;
    private String fathersName;
    private String birthDate;
    private String birthPlace;
    private String flat;
    private String square;
    private String sertNumber;
    private String regDate;
    private String passportSerie;
    private String passportNumber;
    private String passportOutput;
    private String passportCode;
    private String regAdress;
    private String liveAdress;
    private String phone;
    private String mail;
    private String gasService;
    private HashMap<String, Object> properties = new HashMap<>();

    @FXML
    public Label onSaveText;
    @FXML
    public TableView<com.autoWorkPlace.Accaunt> tableTemplate;
    @FXML
    TableColumn<Accaunt, String> column;
    @FXML
    public TableColumn<com.autoWorkPlace.Accaunt,Integer> tableId;
    @FXML
    public TableColumn<com.autoWorkPlace.Accaunt,String> tableFirstName;
    @FXML
    public TableColumn<com.autoWorkPlace.Accaunt,String> tableSecondName;
    @FXML
    public TableColumn<com.autoWorkPlace.Accaunt,String> tableFathersName;
    @FXML
    public TableColumn<com.autoWorkPlace.Accaunt,String> tableBirthDate;
    @FXML
    public TableColumn<com.autoWorkPlace.Accaunt,String> tableBirthPlace;
    @FXML
    public TableColumn<com.autoWorkPlace.Accaunt,String> tableFlat;
    @FXML
    public TableColumn<com.autoWorkPlace.Accaunt,String> tableSquare;
    @FXML
    public TableColumn<com.autoWorkPlace.Accaunt,String> tableSertNumber;
    @FXML
    public TableColumn<com.autoWorkPlace.Accaunt,String> tableRegDate;
    @FXML
    public TableColumn<com.autoWorkPlace.Accaunt,String> tablePassportSerie;
    @FXML
    public TableColumn<com.autoWorkPlace.Accaunt,String> tablePassportNumber;
    @FXML
    public TableColumn<com.autoWorkPlace.Accaunt,String> tablePassportOutput;
    @FXML
    public TableColumn<com.autoWorkPlace.Accaunt,String> tablePassportCode;
    @FXML
    public TableColumn<com.autoWorkPlace.Accaunt,String> tableRegAdress;
    @FXML
    public TableColumn<com.autoWorkPlace.Accaunt,String> tableLiveAdress;
    @FXML
    public TableColumn<com.autoWorkPlace.Accaunt,String> tablePhone;
    @FXML
    public TableColumn<com.autoWorkPlace.Accaunt,String> tableMail;
    @FXML
    public TableColumn<com.autoWorkPlace.Accaunt,String> tableGasService;

    @FXML
    TableColumn<com.autoWorkPlace.Accaunt, String> tableColumn;
    @FXML
    private TextArea resultText;
    @FXML
    private TextArea templateText;

    private com.autoWorkPlace.ExcelDocument exelFile;
    private com.autoWorkPlace.WordDocument doc;
    private ArrayList<String> dataTemplate;
    private ArrayList<String> columnNames;
    private ArrayList<String> dataList;
    private int rowSize = 18;


    //Инициализация при загрузке формы
    @Override
    public void initialize(URL location, ResourceBundle resources) {
       /* tableId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tableFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        tableSecondName.setCellValueFactory(new PropertyValueFactory<>("secondName"));
        tableFathersName.setCellValueFactory(new PropertyValueFactory<>("fathersName"));
        tableBirthDate.setCellValueFactory(new PropertyValueFactory<>("birthDate"));
        tableBirthPlace.setCellValueFactory(new PropertyValueFactory<>("birthPlace"));
        tableFlat.setCellValueFactory(new PropertyValueFactory<>("flat"));
        tableSquare.setCellValueFactory(new PropertyValueFactory<>("square"));
        tableSertNumber.setCellValueFactory(new PropertyValueFactory<>("sertNumber"));
        tableRegDate.setCellValueFactory(new PropertyValueFactory<>("regDate"));
        tablePassportSerie.setCellValueFactory(new PropertyValueFactory<>("passportSerie"));
        tablePassportNumber.setCellValueFactory(new PropertyValueFactory<>("passportNumber"));
        tablePassportOutput.setCellValueFactory(new PropertyValueFactory<>("passportOutput"));
        tablePassportCode.setCellValueFactory(new PropertyValueFactory<>("passportCode"));
        tableRegAdress.setCellValueFactory(new PropertyValueFactory<>("regAdress"));
        tableLiveAdress.setCellValueFactory(new PropertyValueFactory<>("liveAdress"));
        tablePhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        tableMail.setCellValueFactory(new PropertyValueFactory<>("mail"));
        tableGasService.setCellValueFactory(new PropertyValueFactory<>("gasService"));
        */
    }

    @FXML
    protected void onSelected(){
        //System.out.println("Выбрано");
    }

    @FXML //Обработка кнопки "Сохранить результат"
    protected void onSaveButtonClick() throws IOException {
        if(tableTemplate.getSelectionModel().getSelectedIndex() < 1 || templateText.getText() == ""){
            onSaveText.setText(" Загрузите таблицу данных и шаблон!");
            return;
        }else
        this.replace();
    }

    @FXML //Обработка кнопки "Загрузить шаблон"
    protected void onTemplateButtonClick() {
        templateText.setText(this.readTemplate());
    }

    @FXML //Обработка кнопки "Загрузить список"
    protected void onListButtonClick() {
        this.tableLoad();
    }
    //Загрузка таблицы
    private void tableLoad() {
        // Открытие нового докусента Exel (только первый лист!)
        if (tableTemplate.getItems() != null) tableTemplate.getItems().clear();
        com.autoWorkPlace.ExcelDocument exel = new ExcelDocument();
        int row = 4;
        ArrayList tableHeader = exel.readRow(0);
      //  System.out.println(tableHeader);
        for (int i = 0; i < tableHeader.size(); i++){
            //System.out.println(tableHeader.get(i).toString());
            column = new TableColumn<>();
            column.setCellValueFactory(new PropertyValueFactory<>(tableHeader.get(i).toString()));
            tableTemplate.getColumns().add(i,column);
            tableTemplate.getColumns().get(i).setText(tableHeader.get(i).toString());
        }

        //this.id = row;
        //tableTemplate.getColumns().add(0,tableId);

        while (exel.readRow(row) != null){
            dataTemplate = exel.readRow(row);
           // System.out.println(dataTemplate.toString());

            for (int i = 1; i < tableHeader.size(); i++) {
                this.properties.put("ee","ff");
              //  System.out.println(properties.toString());
            }
            /*
            //System.out.println(dataTemplate.toString());
            this.id = row;
            this.firstName = dataTemplate.get(0);
            this.secondName = dataTemplate.get(1);
            this.fathersName = dataTemplate.get(2);
            this.birthDate = dataTemplate.get(3);
            this.birthPlace = dataTemplate.get(4);
            this.flat = dataTemplate.get(5);
            this.square = dataTemplate.get(6);
            this.sertNumber = dataTemplate.get(7);
            this.regDate = dataTemplate.get(8);
            this.passportSerie = dataTemplate.get(9);
            this.passportNumber = dataTemplate.get(10);
            this.passportOutput = dataTemplate.get(11);
            this.passportCode = dataTemplate.get(12);
            this.regAdress = dataTemplate.get(13);
            this.liveAdress = dataTemplate.get(14);
            this.phone = dataTemplate.get(15);
            this.mail = dataTemplate.get(16);
            this.gasService = dataTemplate.get(17);
*/
            initData();
            for(int i = 0; i < tableHeader.size(); i++){


            }
            tableTemplate.setItems(opData);

            row++;
        }
    }

    private void initData() {

        opData.add(new Accaunt(properties));
    }


    //из класса Controller
    public String readTemplate() {
        this.doc = new WordDocument();
        return doc.getDocFromFile();
    }

    public void replace() {
        //doc.getDocFromFile();

        int idSelected = tableTemplate.getSelectionModel().getSelectedIndex();
        String[] tempRow = new String[rowSize];
        String[] targRow = new String[rowSize];
        for (int i = 0; i < rowSize; i++){
            tempRow[i] = tableTemplate.getColumns().get(i).getCellData(0).toString().trim();
            targRow[i] = tableTemplate.getColumns().get(i).getCellData(idSelected).toString().trim();
            //System.out.println(tempRow[i]+"   "+targRow[i]);
        }

        try {
            resultText.setText(doc.replaceAndWrite(tempRow, targRow));
            onSaveText.setText(" Документ создан");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //System.out.println();
    }

    public String readSource() {
        doc.getDocFromFile();
        return doc.getDocText();
    }
}

