package sample.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.awt.*;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ResourceBundle;



public class userConfig implements Initializable {
    private String adminPass  = "KunafaHut";
    @FXML
    private TableView<userTabel> usersTable;

    @FXML
    private TableColumn<userTabel, Timestamp> Ttime;

    @FXML
    private TableColumn<userTabel, Integer> Tphone;

    @FXML
    private TableColumn<userTabel, String> Tname;


    @FXML
    private TextField TuserName;

    @FXML
    private TextField Tuserphone;

    @FXML
    private TextField Tuserpass;
    ObservableList<userTabel> oblist = FXCollections.observableArrayList();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setUsersTable();

    }
    public void setUsersTable(){
        ResultSet dbResAllTotal;
        try {
            String sqlscript = "SELECT * from kunafahut.user";
            dbResAllTotal = (ResultSet) selling.initializeDB("jdbc:mysql://localhost:3306/KunafaHut?verifyServerCertificate=false&useSSL=true","moreda","moreda2021").executeQuery(sqlscript);
            while (dbResAllTotal.next()) {
                oblist.add(new userTabel(dbResAllTotal.getString("username"),dbResAllTotal.getString("password"), dbResAllTotal.getInt("phone"),dbResAllTotal.getTimestamp("create_time")));
            }

        }catch (Exception e){
            e.getCause();
        }
        Tname.setCellValueFactory(new PropertyValueFactory<>("username"));
        Tphone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        Ttime.setCellValueFactory(new PropertyValueFactory<>("create_time"));
        usersTable.setItems(oblist);
    }
    public void menuPage(javafx.event.ActionEvent actionEvent){

        try {
            Parent userview = FXMLLoader.load(menuPage.class.getResource("../fxml/menuPage.fxml"));
            Scene userscene = new Scene(userview);
            Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            window.setScene(userscene);
            window.show();

        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }

    }
}
