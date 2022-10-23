package com.autoWorkPlace;

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
    private String street;
    private String house;
    private String block;
    private String flat;
    private String square;
    private String other;

    private HashMap<String, Object> properties;

    @FXML
    public Label onSaveText;
    @FXML
    public TableView<com.autoWorkPlace.Accaunt> tableTemplate;
    @FXML
    public TableColumn<com.autoWorkPlace.Accaunt, String> column;
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
    public TableColumn<Accaunt,String> tableStreet;
    @FXML
    public TableColumn<Accaunt,String> tableHouse;
    @FXML
    public TableColumn<Accaunt,String> tableBlock;
    @FXML
    public TableColumn<com.autoWorkPlace.Accaunt,String> tableFlat;
    @FXML
    public TableColumn<com.autoWorkPlace.Accaunt,String> tableSquare;
    @FXML
    public TableColumn<Accaunt,String> tableOther;

    @FXML
    TableColumn<com.autoWorkPlace.Accaunt, String> tableColumn;
    @FXML
    private TextArea resultText;
    @FXML
    private TextArea templateText;

    private com.autoWorkPlace.ExcelDocument exelFile;
    private com.autoWorkPlace.WordDocument doc;
    @FXML
    private ArrayList<TableColumn<com.autoWorkPlace.Accaunt,String>> columns;
    private ArrayList<String> tableHeader;
    private ArrayList<String> dataTemplate;
    private ArrayList<String> columnNames;
    private ArrayList<String> dataList;
    private int rowSize;


    //Инициализация при загрузке формы
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tableId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tableFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        tableSecondName.setCellValueFactory(new PropertyValueFactory<>("secondName"));
        tableFathersName.setCellValueFactory(new PropertyValueFactory<>("fathersName"));
        tableBirthDate.setCellValueFactory(new PropertyValueFactory<>("birthDate"));
        tableBirthPlace.setCellValueFactory(new PropertyValueFactory<>("birthPlace"));
        tableStreet.setCellValueFactory(new PropertyValueFactory<>("street"));
        tableHouse.setCellValueFactory(new PropertyValueFactory<>("house"));
        tableBlock.setCellValueFactory(new PropertyValueFactory<>("block"));
        tableFlat.setCellValueFactory(new PropertyValueFactory<>("flat"));
        tableSquare.setCellValueFactory(new PropertyValueFactory<>("square"));
        tableOther.setCellValueFactory(new PropertyValueFactory<>("other"));
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

        columns = new ArrayList<>();
        // Открытие нового докусента Exel (только первый лист!)
        if (tableTemplate.getItems() != null) tableTemplate.getItems().clear();
        com.autoWorkPlace.ExcelDocument exel = new ExcelDocument();
        int row = 1;
        tableHeader = exel.readRow(0);
        rowSize = tableHeader.size();

        while (exel.readRow(row) != null){
            String column10 = "";
            dataTemplate = exel.readRow(row);
            for (int i = 10; i < rowSize; i++){
                column10 = column10 + " / " + dataTemplate.get(i);
            }
           // System.out.println(dataTemplate.toString());
properties = new HashMap<>();
            this.id = row;
            this.firstName = dataTemplate.get(0);
            this.secondName = dataTemplate.get(1);
            this.fathersName = dataTemplate.get(2);
            this.birthDate = dataTemplate.get(3);
            this.birthPlace = dataTemplate.get(4);
            this.street = dataTemplate.get(5);
            this.house = dataTemplate.get(6);
            this.block = dataTemplate.get(7);
            this.flat = dataTemplate.get(8);
            this.square = dataTemplate.get(9);
            this.other = column10; // Временно!

            initData();
            tableTemplate.setItems(opData);
            row++;
        }
    }

    private void initData() {
        opData.add(new Accaunt(id,
                firstName,
                secondName,
                fathersName,
                birthDate,
                birthPlace,
                street,
                house,
                block,
                flat,
                square,
                other));
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

