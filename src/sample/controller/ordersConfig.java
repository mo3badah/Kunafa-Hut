package sample.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ResourceBundle;

public class ordersConfig implements Initializable {

    @FXML
    private TableView<ordersTable> ordersTable;

    @FXML
    private TableColumn<ordersTable, Timestamp> Ttime;

    @FXML
    private TableColumn<ordersTable, String> TcashierName;

    @FXML
    private TableColumn<ordersTable, Integer> TnetTotal;

    @FXML
    private TableColumn<ordersTable, Integer> Tdelivery;

    @FXML
    private TableColumn<ordersTable, Double> Tnetprice;

    @FXML
    private TableColumn<ordersTable, Double> Tdisc;

    @FXML
    private TableColumn<ordersTable, Double> Tprice;

    @FXML
    private TableColumn<ordersTable, String > Tlocation;

    @FXML
    private TableColumn<ordersTable, Integer> Tphone;

    @FXML
    private TableColumn<ordersTable, String > TuserName;

    @FXML
    private TableColumn<ordersTable, Integer> TorderNo;

    ObservableList<ordersTable> oblist = FXCollections.observableArrayList();
    public void setOrdersTable(){
        ResultSet dbResAllTotal;
        try {
            String sqlscript = "SELECT * from kunafahut.orderdetails";
            dbResAllTotal = (ResultSet) selling.initializeDB("jdbc:mysql://localhost:3306/KunafaHut?verifyServerCertificate=false&useSSL=true","moreda","moreda2021").executeQuery(sqlscript);
            while (dbResAllTotal.next()) {
                oblist.add(new ordersTable(dbResAllTotal.getInt("orderNo"),dbResAllTotal.getInt("clientPhone"), dbResAllTotal.getInt("delivery"),dbResAllTotal.getInt("totNetPrice"),dbResAllTotal.getDouble("price"),dbResAllTotal.getDouble("totDisc"),dbResAllTotal.getDouble("totPrice"),dbResAllTotal.getTimestamp("orderTime"),dbResAllTotal.getString("clientName"),dbResAllTotal.getString("clientLocation"),dbResAllTotal.getString("cachierName")));
            }
        }catch (Exception e){
            e.getCause();
            e.printStackTrace();
        }
        TorderNo.setCellValueFactory(new PropertyValueFactory<>("orderNo"));
        TuserName.setCellValueFactory(new PropertyValueFactory<>("clientName"));
        Tphone.setCellValueFactory(new PropertyValueFactory<>("clientPhone"));
        Tlocation.setCellValueFactory(new PropertyValueFactory<>("clientLocation"));
        Tprice.setCellValueFactory(new PropertyValueFactory<>("price"));
        Tdisc.setCellValueFactory(new PropertyValueFactory<>("totDisc"));
        Tnetprice.setCellValueFactory(new PropertyValueFactory<>("totPrice"));
        Tdelivery.setCellValueFactory(new PropertyValueFactory<>("delivery"));
        TnetTotal.setCellValueFactory(new PropertyValueFactory<>("totNetPrice"));
        TcashierName.setCellValueFactory(new PropertyValueFactory<>("cachierName"));
        Ttime.setCellValueFactory(new PropertyValueFactory<>("orderTime"));
        ordersTable.setItems(oblist);


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setOrdersTable();
    }
}
