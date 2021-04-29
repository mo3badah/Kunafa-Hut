package sample.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class itemConfig implements Initializable {

    @FXML
    private TableView<itemTable2> itemTabel2;

    @FXML
    private TableColumn<itemTable2, Double> Tbig2;

    @FXML
    private TableColumn<itemTable2, String> Tbigname2;

    @FXML
    private TableColumn<itemTable2, Double> Tmedium2;

    @FXML
    private TableColumn<itemTable2, String> TmediumName2;

    @FXML
    private TableColumn<itemTable2, String> Tname2;

    @FXML
    private TableColumn<itemTable2, String> Ttype2;

    @FXML
    private TextField insType2;

    @FXML
    private TextField insName2;

    @FXML
    private TextField insMediumName2;

    @FXML
    private TextField insMedium2;

    @FXML
    private TextField insBigName2;

    @FXML
    private TextField insBig2;

    @FXML
    private TableView<itemTable1> itemTabel1;

    @FXML
    private TableColumn<itemTable1, Double> Tbig1;

    @FXML
    private TableColumn<itemTable1, Double> Tmedium1;

    @FXML
    private TableColumn<itemTable1, String> Tname1;

    @FXML
    private TableColumn<itemTable1, String> Ttype1;
    ObservableList<itemTable1> oblist1 = FXCollections.observableArrayList();
    ObservableList<itemTable2> oblist2 = FXCollections.observableArrayList();

    @FXML
    private TextField insType1;

    @FXML
    private TextField insName1;

    @FXML
    private TextField insMedium1;

    @FXML
    private TextField insBig1;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setUsersTable();

    }
    public void setUsersTable(){
        ResultSet dbResAllTotal;
        ResultSet dbResAllTotal2;
        try {
            String sqlscript = "SELECT * from kunafahut.types";
            String sqlscript2 = "SELECT * from kunafahut.added";
            dbResAllTotal = (ResultSet) selling.initializeDB("jdbc:mysql://localhost:3306/KunafaHut?verifyServerCertificate=false&useSSL=true","moreda","moreda2021").executeQuery(sqlscript);
            dbResAllTotal2 = (ResultSet) selling.initializeDB("jdbc:mysql://localhost:3306/KunafaHut?verifyServerCertificate=false&useSSL=true","moreda","moreda2021").executeQuery(sqlscript2);

            while (dbResAllTotal.next()) {
                oblist1.add(new itemTable1(dbResAllTotal.getString("type"),dbResAllTotal.getString("name"), dbResAllTotal.getDouble("big"),dbResAllTotal.getDouble("medium")));
            }
            while (dbResAllTotal2.next()) {
                oblist2.add(new itemTable2(dbResAllTotal2.getString("type"),dbResAllTotal2.getString("name"),dbResAllTotal2.getString("mediumName"),dbResAllTotal2.getString("bigName"), dbResAllTotal2.getDouble("mediumPrice"),dbResAllTotal2.getDouble("bigPrice")));
            }

        }catch (Exception e){
            e.getCause();
        }
        Ttype1.setCellValueFactory(new PropertyValueFactory<>("type"));
        Tname1.setCellValueFactory(new PropertyValueFactory<>("name"));
        Tbig1.setCellValueFactory(new PropertyValueFactory<>("big"));
        Tmedium1.setCellValueFactory(new PropertyValueFactory<>("medium"));
        itemTabel1.setItems(oblist1);

        Ttype2.setCellValueFactory(new PropertyValueFactory<>("type"));
        Tname2.setCellValueFactory(new PropertyValueFactory<>("name"));
        TmediumName2.setCellValueFactory(new PropertyValueFactory<>("mediumName"));
        Tbigname2.setCellValueFactory(new PropertyValueFactory<>("bigName"));
        Tmedium2.setCellValueFactory(new PropertyValueFactory<>("mediumPrice"));
        Tbig2.setCellValueFactory(new PropertyValueFactory<>("bigPrice"));
        itemTabel2.setItems(oblist2);
    }

}
