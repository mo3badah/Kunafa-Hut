package sample.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import static sample.controller.userdata.userphone;

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
    public void update1(javafx.event.ActionEvent actionEvent){
        String type =insName1.getText();
        String name =insName1.getText();
        Double big = Double.valueOf(insBig1.getText());
        Double medium = Double.valueOf(insMedium1.getText());
        if (type.isEmpty() || name.isEmpty() || big.isNaN() || medium.isNaN()) {
            String selection = "من فضلك ادخل كل الخانات صحيحة اولاً ";
            Alert alert = new Alert(Alert.AlertType.ERROR, " " + selection + " !!!", ButtonType.OK);
            alert.showAndWait();
        }
        else {
            // coping data to another Field
            String sendOrderDetails = "UPDATE types set type = '"+type+"',name = '"+name+"', medium = "+medium+",big = "+big+" where type ='"+type+"' And name='"+name+"';";
            System.out.println(big+" "+medium);
            try {
                selling.initializeDB("jdbc:mysql://localhost:3306/KunafaHut?verifyServerCertificate=false&useSSL=true","moreda","moreda2021").executeUpdate(sendOrderDetails);
            } catch (SQLException e) {
                e.printStackTrace();
                e.getCause();
            }
            itemTabel1.getItems().clear();
            itemTabel2.getItems().clear();
            setUsersTable();
        }

    }
    public void fetchItem1(MouseEvent actionEvent){
        int tableRowId = -1;
        String type = "";
        String name = "";
        tableRowId = itemTabel1.getSelectionModel().getSelectedIndex();
        if (!(tableRowId <= -1)) {
            type = itemTabel1.getSelectionModel().getSelectedItem().type;
            name = itemTabel1.getSelectionModel().getSelectedItem().name;
            ResultSet dbResAllTotal;
            try {
                String sqlscript = "SELECT * from kunafahut.types where type='"+type+"' And name='"+name+"';";

                dbResAllTotal = (ResultSet) selling.initializeDB("jdbc:mysql://localhost:3306/KunafaHut?verifyServerCertificate=false&useSSL=true","moreda","moreda2021").executeQuery(sqlscript);

                while (dbResAllTotal.next()) {
                    insType1.setText(dbResAllTotal.getString("type"));
                    insName1.setText(dbResAllTotal.getString("name"));
                    insBig1.setText(String.valueOf(dbResAllTotal.getDouble("big")));
                    insMedium1.setText(String.valueOf(dbResAllTotal.getDouble("medium")));
                }

            }catch (Exception e){
                e.getCause();
            }
        }
    }
    public void fetchItem2(MouseEvent actionEvent){
        int tableRowId = -1;
        String type = "";
        String name = "";
        tableRowId = itemTabel1.getSelectionModel().getSelectedIndex();
        if (!(tableRowId <= -1)) {
            type = itemTabel2.getSelectionModel().getSelectedItem().type;
            name = itemTabel2.getSelectionModel().getSelectedItem().name;
            ResultSet dbResAllTotal;
            try {
                String sqlscript = "SELECT * from kunafahut.added where type='"+type+"' And name='"+name+"';";

                dbResAllTotal = (ResultSet) selling.initializeDB("jdbc:mysql://localhost:3306/KunafaHut?verifyServerCertificate=false&useSSL=true","moreda","moreda2021").executeQuery(sqlscript);

                while (dbResAllTotal.next()) {
                    insType2.setText(dbResAllTotal.getString("type"));
                    insName2.setText(dbResAllTotal.getString("name"));
                    insMediumName2.setText(dbResAllTotal.getString("mediumName"));
                    insBigName2.setText(dbResAllTotal.getString("bigName"));
                    insBig2.setText(String.valueOf(dbResAllTotal.getDouble("bigPrice")));
                    insMedium2.setText(String.valueOf(dbResAllTotal.getDouble("mediumPrice")));
                }

            }catch (Exception e){
                e.getCause();
            }
        }
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
