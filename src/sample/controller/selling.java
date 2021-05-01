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
import javafx.stage.Stage;
import sample.Main;

import java.net.URL;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Observable;
import java.util.ResourceBundle;
import java.text.SimpleDateFormat;
import java.util.Date;

public class selling implements Initializable {
    public static int getIdgenerate() {
        return idgenerate;
    }

    public static void setIdgenerate(int idgenerate) {
        selling.idgenerate = idgenerate;
    }

    public static int idgenerate;

    public static int getIdmod() {
        return idmod;
    }

    public static void setIdmod(int idmod1) {
        idmod = idmod1;
    }

    private static int idmod;

    public static boolean isIsmod() {
        return ismod;
    }

    public static void setIsmod(boolean ismod1) {
        ismod = ismod1;
    }

    private static boolean ismod;
    public static String getCashierName() {
        return cashierName;
    }

    public static void setCashierName(String cashierName) {
        selling.cashierName = cashierName;
    }

    public static String cashierName = "admin";

    @FXML
    private ToggleGroup type;
    @FXML
    private ToggleGroup type3;
    @FXML
    private ToggleGroup type7;
    @FXML
    private TextField onePrice;
    @FXML
    private TextField gramno;
    @FXML
    private TextField piecesno;
    @FXML
    private TextField midno;
    @FXML
    private TextField bigno;
    @FXML
    private TextField newno;
    @FXML
    private TextField Ediscratio;
    @FXML
    private TextField Ediscno;
    @FXML
    private CheckBox Orderdisc;
    @FXML
    private TableView<moderTabel> sellingTable;
    @FXML
    private TableColumn<moderTabel,String> Ttype;
    @FXML
    private TableColumn<moderTabel,String> Tname;
    @FXML
    private TableColumn<moderTabel,Double> Tno;
    @FXML
    private TableColumn<moderTabel,String> Tquantity;
    @FXML
    private TableColumn<moderTabel,Double> Tprice;
    @FXML
    private TableColumn<moderTabel,Double> Tdisc;
    @FXML
    private TableColumn<moderTabel,Double> Tnetprice;
    ObservableList<moderTabel> oblist = FXCollections.observableArrayList();
    @FXML
    private TextField TallTotal;
    @FXML
    private TextField TallDisc;
    @FXML
    private ChoiceBox comboNew;


    // The main data variables
    public String Otype;
    public String Oname;
    public Double Ono;
    public String Oquantity;
    public Double Oprice;
    public Double Odisc;
    public Double Onetprice;
    public Double allTotal;
    public Double allDisc;





    private ResultSet dbResSell;
    private Main main;



    public void initialize(URL location, ResourceBundle resources) {
        setSellingTable();
        initializeCombo();
        System.out.println(checkEmpty());
    }
    public String checkKlasicTypes(ToggleGroup x){
        RadioButton selectedRadioButton = (RadioButton) x.getSelectedToggle();
        return selectedRadioButton.getId();
        //onePrice.setText(toogleGroupValue);
    }
    // Classic Buttons

    public void buttonQuar(javafx.event.ActionEvent actionEvent) throws SQLException {
        Double kilo = 0.0 ;
        String typeId = null;
        try {
            typeId = checkKlasicTypes(type);
        }catch (Exception e){
            String selection = "من فضلك ادخل النوع اولاً ";
            Alert alert = new Alert(Alert.AlertType.ERROR, " " + selection + " !!!", ButtonType.OK);
            alert.showAndWait();
        }
        String sqlscript = "SELECT * from kunafahut.types where id = '" + typeId + "'";
        dbResSell = (ResultSet) initializeDB("jdbc:mysql://localhost:3306/KunafaHut?verifyServerCertificate=false&useSSL=true","moreda","moreda2021").executeQuery(sqlscript);
        while (dbResSell.next()) {
            Otype = dbResSell.getString("type");
            Oname = dbResSell.getString("name");
            kilo = Double.valueOf(dbResSell.getString("big"));
        }
        Ono = .25;
        Oquantity = "كيلو";
        Oprice = kilo/4;
        onePrice.setText(String.valueOf(Oprice));
    }

    public void buttonHalf(javafx.event.ActionEvent actionEvent) throws SQLException {
        Double kilo = 0.0 ;
        String typeId = null;
        try {
            typeId = checkKlasicTypes(type);
        }catch (Exception e){
            String selection = "من فضلك ادخل النوع اولاً ";
            Alert alert = new Alert(Alert.AlertType.ERROR, " " + selection + " !!!", ButtonType.OK);
            alert.showAndWait();
        }
        String sqlscript = "SELECT * from kunafahut.types where id = '" + typeId + "'";
        dbResSell = (ResultSet) initializeDB("jdbc:mysql://localhost:3306/KunafaHut?verifyServerCertificate=false&useSSL=true","moreda","moreda2021").executeQuery(sqlscript);
        while (dbResSell.next()) {
            Otype = dbResSell.getString("type");
            Oname = dbResSell.getString("name");
            kilo = Double.valueOf(dbResSell.getString("big"));
        }
        Ono = .5;
        Oquantity = "كيلو";
        Oprice = kilo/2;
        onePrice.setText(String.valueOf(Oprice));


    }

    public void buttonKilo(javafx.event.ActionEvent actionEvent) throws SQLException {
        Double kilo = 0.0 ;
        String typeId = null;
        try {
            typeId = checkKlasicTypes(type);
        }catch (Exception e){
            String selection = "من فضلك ادخل النوع اولاً ";
            Alert alert = new Alert(Alert.AlertType.ERROR, " " + selection + " !!!", ButtonType.OK);
            alert.showAndWait();
        }
        String sqlscript = "SELECT * from kunafahut.types where id = '" + typeId + "'";
        dbResSell = (ResultSet) initializeDB("jdbc:mysql://localhost:3306/KunafaHut?verifyServerCertificate=false&useSSL=true","moreda","moreda2021").executeQuery(sqlscript);
        while (dbResSell.next()) {
            Otype = dbResSell.getString("type");
            Oname = dbResSell.getString("name");
            kilo = Double.valueOf(dbResSell.getString("big"));
        }
        Ono = 1.0;
        Oquantity = "كيلو";
        Oprice = kilo;
        onePrice.setText(String.valueOf(Oprice));


    }

    public void buttonKiloEnter(javafx.event.ActionEvent actionEvent) throws SQLException {
        Double kilo = 0.0 ;
        Double gramenter = 1000.0 ;
        String typeId = null;
        try {
            gramenter = Double.valueOf(gramno.getText());
        }
        catch (Exception e){
            String selection = "من فضلك ادخل عدد الجرامات صحيح اولاً ";
            Alert alert = new Alert(Alert.AlertType.ERROR, " " + selection + " !!!", ButtonType.OK);
            alert.showAndWait();
        }

        try {
            typeId = checkKlasicTypes(type);
        }catch (Exception e){
            String selection = "من فضلك ادخل النوع اولاً ";
            Alert alert = new Alert(Alert.AlertType.ERROR, " " + selection + " !!!", ButtonType.OK);
            alert.showAndWait();
        }
        String sqlscript = "SELECT * from kunafahut.types where id = '" + typeId + "'";
        dbResSell = (ResultSet) initializeDB("jdbc:mysql://localhost:3306/KunafaHut?verifyServerCertificate=false&useSSL=true","moreda","moreda2021").executeQuery(sqlscript);
        while (dbResSell.next()) {
            Otype = dbResSell.getString("type");
            Oname = dbResSell.getString("name");
            kilo = Double.valueOf(dbResSell.getString("big"));
        }
        Ono = gramenter/1000;
        Oquantity = "كيلو";
        Oprice = kilo*gramenter/1000;
        onePrice.setText(String.valueOf(Oprice));
    }

    public void buttonOnePiece(javafx.event.ActionEvent actionEvent) throws SQLException {
        Double piece = 0.0 ;
        String typeId = null;
        try {
            typeId = checkKlasicTypes(type);
        }catch (Exception e){
            String selection = "من فضلك ادخل النوع اولاً ";
            Alert alert = new Alert(Alert.AlertType.ERROR, " " + selection + " !!!", ButtonType.OK);
            alert.showAndWait();
        }
        String sqlscript = "SELECT * from kunafahut.types where id = '" + typeId + "'";
        dbResSell = (ResultSet) initializeDB("jdbc:mysql://localhost:3306/KunafaHut?verifyServerCertificate=false&useSSL=true","moreda","moreda2021").executeQuery(sqlscript);
        while (dbResSell.next()) {
            Otype = dbResSell.getString("type");
            Oname = dbResSell.getString("name");
            piece = Double.valueOf(dbResSell.getString("medium"));
        }
        Ono = 1.0;
        Oquantity = "قطعة";
        Oprice = piece;
        onePrice.setText(String.valueOf(Oprice));
    }

    public void buttonTwoPieces(javafx.event.ActionEvent actionEvent) throws SQLException {
        Double piece = 0.0 ;
        String typeId = null;
        try {
            typeId = checkKlasicTypes(type);
        }catch (Exception e){
            String selection = "من فضلك ادخل النوع اولاً ";
            Alert alert = new Alert(Alert.AlertType.ERROR, " " + selection + " !!!", ButtonType.OK);
            alert.showAndWait();
        }
        String sqlscript = "SELECT * from kunafahut.types where id = '" + typeId + "'";
        dbResSell = (ResultSet) initializeDB("jdbc:mysql://localhost:3306/KunafaHut?verifyServerCertificate=false&useSSL=true","moreda","moreda2021").executeQuery(sqlscript);
        while (dbResSell.next()) {
            Otype = dbResSell.getString("type");
            Oname = dbResSell.getString("name");
            piece = Double.valueOf(dbResSell.getString("medium"));
        }
        Ono = 2.0;
        Oquantity = "قطعة";
        Oprice = piece*2;
        onePrice.setText(String.valueOf(Oprice));


    }

    public void buttonThreePieces(javafx.event.ActionEvent actionEvent) throws SQLException {
        Double piece = 0.0 ;
        String typeId = null;
        try {
            typeId = checkKlasicTypes(type);
        }catch (Exception e){
            String selection = "من فضلك ادخل النوع اولاً ";
            Alert alert = new Alert(Alert.AlertType.ERROR, " " + selection + " !!!", ButtonType.OK);
            alert.showAndWait();
        }
        String sqlscript = "SELECT * from kunafahut.types where id = '" + typeId + "'";
        dbResSell = (ResultSet) initializeDB("jdbc:mysql://localhost:3306/KunafaHut?verifyServerCertificate=false&useSSL=true","moreda","moreda2021").executeQuery(sqlscript);
        while (dbResSell.next()) {
            Otype = dbResSell.getString("type");
            Oname = dbResSell.getString("name");
            piece = Double.valueOf(dbResSell.getString("medium"));
        }
        Ono = 3.0;
        Oquantity = "قطعة";
        Oprice = piece*3;
        onePrice.setText(String.valueOf(Oprice));


    }

    public void buttonPiecesEnter(javafx.event.ActionEvent actionEvent) throws SQLException {
        Double piece = 0.0 ;
        Double piecesenter = 1.0 ;
        String typeId = null;
        try {
            piecesenter = Double.valueOf(piecesno.getText());
        }
        catch (Exception e){
            String selection = "من فضلك ادخل عدد القطع صحيح اولاً ";
            Alert alert = new Alert(Alert.AlertType.ERROR, " " + selection + " !!!", ButtonType.OK);
            alert.showAndWait();
        }

        try {
            typeId = checkKlasicTypes(type);
        }catch (Exception e){
            String selection = "من فضلك ادخل النوع اولاً ";
            Alert alert = new Alert(Alert.AlertType.ERROR, " " + selection + " !!!", ButtonType.OK);
            alert.showAndWait();
        }
        String sqlscript = "SELECT * from kunafahut.types where id = '" + typeId + "'";
        dbResSell = (ResultSet) initializeDB("jdbc:mysql://localhost:3306/KunafaHut?verifyServerCertificate=false&useSSL=true","moreda","moreda2021").executeQuery(sqlscript);
        while (dbResSell.next()) {
            Otype = dbResSell.getString("type");
            Oname = dbResSell.getString("name");
            piece = Double.valueOf(dbResSell.getString("medium"));
        }
        Ono = piecesenter;
        Oquantity = "قطعة";
        Oprice = piece*piecesenter;
        onePrice.setText(String.valueOf(Oprice));
    }

    // Form, Cups and Mix Buttons
    public void buttonMediumEnter(javafx.event.ActionEvent actionEvent) throws SQLException {
        Double kilo = 0.0;
        Double piecesenter = 1.0;
        String typeId = null;
        try {
            piecesenter = Double.valueOf(midno.getText());
        } catch (Exception e) {
            String selection = "من فضلك ادخل عدد القطع صحيح اولاً ";
            Alert alert = new Alert(Alert.AlertType.ERROR, " " + selection + " !!!", ButtonType.OK);
            alert.showAndWait();
        }

        try {
            typeId = checkKlasicTypes(type3);
        } catch (Exception e) {
            String selection = "من فضلك ادخل النوع اولاً ";
            Alert alert = new Alert(Alert.AlertType.ERROR, " " + selection + " !!!", ButtonType.OK);
            alert.showAndWait();
        }
        if (typeId.equals("added")) {
            Oname = (String) comboNew.getValue();
            String sqlscript = "SELECT * from kunafahut.added where name = '" + Oname + "'";
            dbResSell = (ResultSet) initializeDB("jdbc:mysql://localhost:3306/KunafaHut?verifyServerCertificate=false&useSSL=true", "moreda", "moreda2021").executeQuery(sqlscript);
            while (dbResSell.next()) {
                Otype = dbResSell.getString("type");
                Oquantity = dbResSell.getString("mediumName");
                kilo = Double.valueOf(dbResSell.getString("mediumPrice"));
            }


        } else {

            String sqlscript = "SELECT * from kunafahut.types where id = '" + typeId + "'";
            dbResSell = (ResultSet) initializeDB("jdbc:mysql://localhost:3306/KunafaHut?verifyServerCertificate=false&useSSL=true", "moreda", "moreda2021").executeQuery(sqlscript);
            while (dbResSell.next()) {
                Otype = dbResSell.getString("type");
                Oname = dbResSell.getString("name");
                kilo = Double.valueOf(dbResSell.getString("medium"));
            }

            if (Otype.equals("كوب")) {
                Oquantity = "صغير";
            } else {
                Oquantity = "وسط";
            }
        }
            Ono = piecesenter;
            Oprice = kilo * piecesenter;
            onePrice.setText(String.valueOf(Oprice));
        }


    public void buttonBigEnter(javafx.event.ActionEvent actionEvent) throws SQLException {
        Double kilo = 0.0 ;
        Double piecesenter = 1.0 ;
        String typeId = null;
        try {
            piecesenter = Double.valueOf(bigno.getText());
        }
        catch (Exception e){
            String selection = "من فضلك ادخل عدد القطع صحيح اولاً ";
            Alert alert = new Alert(Alert.AlertType.ERROR, " " + selection + " !!!", ButtonType.OK);
            alert.showAndWait();
        }

        try {
            typeId = checkKlasicTypes(type3);
        }catch (Exception e){
            String selection = "من فضلك ادخل النوع اولاً ";
            Alert alert = new Alert(Alert.AlertType.ERROR, " " + selection + " !!!", ButtonType.OK);
            alert.showAndWait();
        }
        if (typeId.equals("added")) {
            Oname = (String) comboNew.getValue();
            String sqlscript = "SELECT * from kunafahut.added where name = '" + Oname + "'";
            dbResSell = (ResultSet) initializeDB("jdbc:mysql://localhost:3306/KunafaHut?verifyServerCertificate=false&useSSL=true", "moreda", "moreda2021").executeQuery(sqlscript);
            while (dbResSell.next()) {
                Otype = dbResSell.getString("type");
                Oquantity = dbResSell.getString("bigName");
                kilo = Double.valueOf(dbResSell.getString("bigPrice"));
            }
        }
        else {
            String sqlscript = "SELECT * from kunafahut.types where id = '" + typeId + "'";
            dbResSell = (ResultSet) initializeDB("jdbc:mysql://localhost:3306/KunafaHut?verifyServerCertificate=false&useSSL=true", "moreda", "moreda2021").executeQuery(sqlscript);
            while (dbResSell.next()) {
                Otype = dbResSell.getString("type");
                Oname = dbResSell.getString("name");
                kilo = Double.valueOf(dbResSell.getString("big"));
            }
            Ono = piecesenter;
            if (Otype.equals("كوب")) {
                Oquantity = "وسط";
            } else {
                Oquantity = "كبير";
            }
        }
        Ono = piecesenter;
        Oprice = kilo*piecesenter;
        onePrice.setText(String.valueOf(Oprice));
    }

    // New Buttons
    public void buttonOrise(javafx.event.ActionEvent actionEvent) throws SQLException {
        Double kilo = 5.0 ;
        Double piecesenter = 1.0 ;
        String typeId = "Orise";
        try {
            piecesenter = Double.valueOf(newno.getText());
        }
        catch (Exception e){
            String selection = "من فضلك ادخل عدد القطع صحيح اولاً ";
            Alert alert = new Alert(Alert.AlertType.ERROR, " " + selection + " !!!", ButtonType.OK);
            alert.showAndWait();
        }
        String sqlscript = "SELECT * from kunafahut.types where id = '" + typeId + "'";
        dbResSell = (ResultSet) initializeDB("jdbc:mysql://localhost:3306/KunafaHut?verifyServerCertificate=false&useSSL=true","moreda","moreda2021").executeQuery(sqlscript);
        while (dbResSell.next()) {
            Otype = dbResSell.getString("type");
            Oname = dbResSell.getString("name");
            kilo = Double.valueOf(dbResSell.getString("medium"));
        }
        Ono = piecesenter;
        Oquantity = "";
        Oprice = kilo*piecesenter;
        onePrice.setText(String.valueOf(Oprice));
    }

    public void buttonFrise(javafx.event.ActionEvent actionEvent) throws SQLException {
        Double kilo = 6.0 ;
        Double piecesenter = 1.0 ;
        String typeId = "Frise";
        try {
            piecesenter = Double.valueOf(newno.getText());
        }
        catch (Exception e){
            String selection = "من فضلك ادخل عدد القطع صحيح اولاً ";
            Alert alert = new Alert(Alert.AlertType.ERROR, " " + selection + " !!!", ButtonType.OK);
            alert.showAndWait();
        }
        String sqlscript = "SELECT * from kunafahut.types where id = '" + typeId + "'";
        dbResSell = (ResultSet) initializeDB("jdbc:mysql://localhost:3306/KunafaHut?verifyServerCertificate=false&useSSL=true","moreda","moreda2021").executeQuery(sqlscript);
        while (dbResSell.next()) {
            Otype = dbResSell.getString("type");
            Oname = dbResSell.getString("name");
            kilo = Double.valueOf(dbResSell.getString("medium"));
        }
        Ono = piecesenter;
        Oquantity = "";
        Oprice = kilo*piecesenter;
        onePrice.setText(String.valueOf(Oprice));
    }

    public void buttonDislut(javafx.event.ActionEvent actionEvent) throws SQLException {
        Double kilo = 30.0 ;
        Double piecesenter = 1.0 ;
        String typeId = "Dislut";
        try {
            piecesenter = Double.valueOf(newno.getText());
        }
        catch (Exception e){
            String selection = "من فضلك ادخل عدد القطع صحيح اولاً ";
            Alert alert = new Alert(Alert.AlertType.ERROR, " " + selection + " !!!", ButtonType.OK);
            alert.showAndWait();
        }
        String sqlscript = "SELECT * from kunafahut.types where id = '" + typeId + "'";
        dbResSell = (ResultSet) initializeDB("jdbc:mysql://localhost:3306/KunafaHut?verifyServerCertificate=false&useSSL=true","moreda","moreda2021").executeQuery(sqlscript);
        while (dbResSell.next()) {
            Otype = dbResSell.getString("type");
            Oname = dbResSell.getString("name");
            kilo = Double.valueOf(dbResSell.getString("medium"));
        }
        Ono = piecesenter;
        Oquantity = "";
        Oprice = kilo*piecesenter;
        onePrice.setText(String.valueOf(Oprice));
    }

    public void buttonDisnut(javafx.event.ActionEvent actionEvent) throws SQLException {
        Double kilo = 25.0 ;
        Double piecesenter = 1.0 ;
        String typeId = "Disnut";
        try {
            piecesenter = Double.valueOf(newno.getText());
        }
        catch (Exception e){
            String selection = "من فضلك ادخل عدد القطع صحيح اولاً ";
            Alert alert = new Alert(Alert.AlertType.ERROR, " " + selection + " !!!", ButtonType.OK);
            alert.showAndWait();
        }
        String sqlscript = "SELECT * from kunafahut.types where id = '" + typeId + "'";
        dbResSell = (ResultSet) initializeDB("jdbc:mysql://localhost:3306/KunafaHut?verifyServerCertificate=false&useSSL=true","moreda","moreda2021").executeQuery(sqlscript);
        while (dbResSell.next()) {
            Otype = dbResSell.getString("type");
            Oname = dbResSell.getString("name");
            kilo = Double.valueOf(dbResSell.getString("medium"));
        }
        Ono = piecesenter;
        Oquantity = "";
        Oprice = kilo*piecesenter;
        onePrice.setText(String.valueOf(Oprice));
    }

    public void buttoncofee(javafx.event.ActionEvent actionEvent) throws SQLException {
        Double kilo = 8.0 ;
        Double piecesenter = 1.0 ;
        String typeId = "cofee";
        try {
            piecesenter = Double.valueOf(newno.getText());
        }
        catch (Exception e){
            String selection = "من فضلك ادخل عدد القطع صحيح اولاً ";
            Alert alert = new Alert(Alert.AlertType.ERROR, " " + selection + " !!!", ButtonType.OK);
            alert.showAndWait();
        }
        String sqlscript = "SELECT * from kunafahut.types where id = '" + typeId + "'";
        dbResSell = (ResultSet) initializeDB("jdbc:mysql://localhost:3306/KunafaHut?verifyServerCertificate=false&useSSL=true","moreda","moreda2021").executeQuery(sqlscript);
        while (dbResSell.next()) {
            Otype = dbResSell.getString("type");
            Oname = dbResSell.getString("name");
            kilo = Double.valueOf(dbResSell.getString("medium"));
        }
        Ono = piecesenter;
        Oquantity = "";
        Oprice = kilo*piecesenter;
        onePrice.setText(String.valueOf(Oprice));
    }

    public void buttonwater(javafx.event.ActionEvent actionEvent) throws SQLException {
        Double kilo = 4.0 ;
        Double piecesenter = 1.0 ;
        String typeId = "water";
        try {
            piecesenter = Double.valueOf(newno.getText());
        }
        catch (Exception e){
            String selection = "من فضلك ادخل عدد القطع صحيح اولاً ";
            Alert alert = new Alert(Alert.AlertType.ERROR, " " + selection + " !!!", ButtonType.OK);
            alert.showAndWait();
        }
        String sqlscript = "SELECT * from kunafahut.types where id = '" + typeId + "'";
        dbResSell = (ResultSet) initializeDB("jdbc:mysql://localhost:3306/KunafaHut?verifyServerCertificate=false&useSSL=true","moreda","moreda2021").executeQuery(sqlscript);
        while (dbResSell.next()) {
            Otype = dbResSell.getString("type");
            Oname = dbResSell.getString("name");
            kilo = Double.valueOf(dbResSell.getString("medium"));
        }
        Ono = piecesenter;
        Oquantity = "";
        Oprice = kilo*piecesenter;
        onePrice.setText(String.valueOf(Oprice));
    }

    public void buttonpepsi(javafx.event.ActionEvent actionEvent) throws SQLException {
        Double kilo = 6.0 ;
        Double piecesenter = 1.0 ;
        String typeId = "pepsi";
        try {
            piecesenter = Double.valueOf(newno.getText());
        }
        catch (Exception e){
            String selection = "من فضلك ادخل عدد القطع صحيح اولاً ";
            Alert alert = new Alert(Alert.AlertType.ERROR, " " + selection + " !!!", ButtonType.OK);
            alert.showAndWait();
        }
        String sqlscript = "SELECT * from kunafahut.types where id = '" + typeId + "'";
        dbResSell = (ResultSet) initializeDB("jdbc:mysql://localhost:3306/KunafaHut?verifyServerCertificate=false&useSSL=true","moreda","moreda2021").executeQuery(sqlscript);
        while (dbResSell.next()) {
            Otype = dbResSell.getString("type");
            Oname = dbResSell.getString("name");
            kilo = Double.valueOf(dbResSell.getString("medium"));
        }
        Ono = piecesenter;
        Oquantity = "";
        Oprice = kilo*piecesenter;
        onePrice.setText(String.valueOf(Oprice));
    }

    public double returnDisc(double price){
        String typeId;
        double afterDisc = price;
        try {
            typeId = checkKlasicTypes(type7);
           // System.out.println("check"+typeId);
            if (typeId.equals("Cdiscno")){
                try {
                   // System.out.println("discNo");
                    afterDisc = price-Double.valueOf(Ediscno.getText());
                }catch (Exception e){
                    String selection = "من فضلك ادخل رقم الخصم اولاً ";
                    Alert alert = new Alert(Alert.AlertType.ERROR, " " + selection + " !!!", ButtonType.OK);
                    alert.showAndWait();
                }
            }else if (typeId.equals("Cdiscratio")){
                try {
                    if ((!Double.valueOf(Ediscratio.getText()).equals(0.0))){
                       // System.out.println("Cdiscratio");
                        afterDisc = price*(1-Double.valueOf(Ediscratio.getText())/100);
                    }
                }catch (Exception e){
                    String selection = "من فضلك ادخل نسبة الخصم اولاً ";
                    Alert alert = new Alert(Alert.AlertType.ERROR, " " + selection + " !!!", ButtonType.OK);
                    alert.showAndWait();
                }
            }else if (typeId.equals("Free")){
                // System.out.println("Free");
                afterDisc = 0.0;
            }
        }catch (Exception e){
            return afterDisc;
        }

        return afterDisc;
    }

    public void addItem(javafx.event.ActionEvent actionEvent){
        try {
            double price = Double.parseDouble(onePrice.getText());
            Onetprice = returnDisc(price);
            Odisc = Oprice-Onetprice;
            clearDisc();
            // save ItemData in the preorder table
            String sqlscript = "INSERT INTO `kunafahut`.`preorder` (`type`, `name`, `no`, `quantity`, `price`, `disc`, `netPrice`) VALUES ('"+Otype+"','"+Oname+"',"+Ono+",'"+Oquantity+"',"+Oprice+","+Odisc+","+Onetprice+")";
            try {
                initializeDB("jdbc:mysql://localhost:3306/KunafaHut?verifyServerCertificate=false&useSSL=true","moreda","moreda2021").executeUpdate(sqlscript);
                System.out.println("updated successfully!");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("dosen't updated!");
            }
            sellingTable.getItems().clear();
            setSellingTable();
        }catch (Exception e){
            String selection = "من فضلك ادخل ادخل طلب اولاً ";
            Alert alert = new Alert(Alert.AlertType.ERROR, " " + selection + " !!!", ButtonType.OK);
            alert.showAndWait();
        }

    }

    public void clearDisc(){
        for (Toggle t : type7.getToggles()) {
            if (t instanceof RadioButton) {
                ((RadioButton) t).setSelected(false);
            }
        }
        Ediscno.setText("");
        Ediscratio.setText("");
    }

    public void clearAllOthers(){
        for (Toggle t : type.getToggles()) {
            if (t instanceof RadioButton) {
                ((RadioButton) t).setSelected(false);
            }
        }
        for (Toggle t : type3.getToggles()) {
            if (t instanceof RadioButton) {
                ((RadioButton) t).setSelected(false);
            }
        }
        gramno.setText("");
        piecesno.setText("");
        onePrice.setText("");
        midno.setText("1");
        bigno.setText("1");
        newno.setText("1");
    }

    public void dropTableRow(){
        int tableRowId = -1;
        int typed = 0;
        tableRowId = sellingTable.getSelectionModel().getSelectedIndex();
        if (!(tableRowId <= -1)){
            typed = sellingTable.getSelectionModel().getSelectedItem().rowNo;
            String sqlscript = "DELETE FROM `kunafahut`.`preorder` WHERE `rowNo` ="+typed+"";
            try {
                initializeDB("jdbc:mysql://localhost:3306/KunafaHut?verifyServerCertificate=false&useSSL=true","moreda","moreda2021").executeUpdate(sqlscript);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            sellingTable.getItems().clear();
            setSellingTable();
        }else {
            String selection = "من فضلك حدد الصف المراد حذفة ";
            Alert alert = new Alert(Alert.AlertType.ERROR, " " + selection + " !!!", ButtonType.OK);
            alert.showAndWait();
        }
    }

    public void clearAllData(javafx.event.ActionEvent actionEvent){
        clearAllData();
    }
    public  void clearAllData(){
        // clear table data
        String sqlscript = "DELETE FROM `kunafahut`.`preorder`";
        try {
            initializeDB("jdbc:mysql://localhost:3306/KunafaHut?verifyServerCertificate=false&useSSL=true","moreda","moreda2021").executeUpdate(sqlscript);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        sellingTable.getItems().clear();
        setSellingTable();
        // clear other data
        clearDisc();
        clearAllOthers();
    }

    public void setSellingTable(){
        // DB functions
        ResultSet dbResAllTotal;
        ResultSet dbResAllDisc;
        try {
            String sqlscript = "SELECT * from kunafahut.preorder";
            String sqlAllTotal = "SELECT SUM(netPrice) as totalNetPrice from kunafahut.preorder";
            String sqlAllDisc = "SELECT SUM(disc) AS totalDisc from kunafahut.preorder";
            dbResSell = (ResultSet) initializeDB("jdbc:mysql://localhost:3306/KunafaHut?verifyServerCertificate=false&useSSL=true","moreda","moreda2021").executeQuery(sqlscript);
            dbResAllTotal = (ResultSet) initializeDB("jdbc:mysql://localhost:3306/KunafaHut?verifyServerCertificate=false&useSSL=true","moreda","moreda2021").executeQuery(sqlAllTotal);
            dbResAllDisc = (ResultSet) initializeDB("jdbc:mysql://localhost:3306/KunafaHut?verifyServerCertificate=false&useSSL=true","moreda","moreda2021").executeQuery(sqlAllDisc);
            while (dbResAllTotal.next()){
                allTotal = (Double) dbResAllTotal.getDouble("totalNetPrice");
            }
            while (dbResAllDisc.next()){
                allDisc = (Double) dbResAllDisc.getDouble("totalDisc");
            }
            while (dbResSell.next()) {
                oblist.add(new moderTabel(dbResSell.getInt("rowNo"), dbResSell.getString("type"),dbResSell.getString("name"),dbResSell.getDouble("no"),dbResSell.getString("quantity"),dbResSell.getDouble("price"),dbResSell.getDouble("disc"),dbResSell.getDouble("netprice")));
            }
            TallDisc.setText(String.valueOf(allDisc));
            TallTotal.setText(String.valueOf(allTotal));


        }catch (SQLException e){
            e.printStackTrace();
        }



        Ttype.setCellValueFactory(new PropertyValueFactory<>("type"));
        Tname.setCellValueFactory(new PropertyValueFactory<>("name"));
        Tno.setCellValueFactory(new PropertyValueFactory<>("no"));
        Tquantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        Tprice.setCellValueFactory(new PropertyValueFactory<>("price"));
        Tdisc.setCellValueFactory(new PropertyValueFactory<>("disc"));
        Tnetprice.setCellValueFactory(new PropertyValueFactory<>("netprice"));
        sellingTable.setItems(oblist);
    }

    public static Statement initializeDB(String dburl, String dbuser, String dbpass) throws SQLException {
        // DB parameters
        Connection dbconn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded");
            dbconn = DriverManager.getConnection(dburl, dbuser, dbpass);
            System.out.println("DataBase connected");
        } catch (ClassNotFoundException | SQLException var2) {
            System.err.println(var2.getMessage());
        }
        return dbconn.createStatement();

    }
    public void initializeCombo(){
        String sqlscript2 = "SELECT * FROM added ;";
        try {
            ResultSet dbResGetId = (ResultSet) initializeDB("jdbc:mysql://localhost:3306/KunafaHut?verifyServerCertificate=false&useSSL=true", "moreda", "moreda2021").executeQuery(sqlscript2);
            while (dbResGetId.next()){

                comboNew.getItems().addAll(dbResGetId.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void printing2(javafx.event.ActionEvent actionEvent){
        if (checkEmpty()==1){
            try {
                printing();
                Parent userview = FXMLLoader.load(getClass().getResource("../fxml/userdata.fxml"));
                Scene userscene = new Scene(userview);
                Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
                window.setScene(userscene);
                window.show();

            }catch (Exception e){
                e.printStackTrace();
                e.getCause();
            }
        }else {
            String selection = "من فضلك ادخل بيانات الاوردر ";
            Alert alert = new Alert(Alert.AlertType.ERROR, " " + selection + " !!!", ButtonType.OK);
            alert.showAndWait();
        }

    }
    public void printing1(javafx.event.ActionEvent actionEvent){
        if (checkEmpty()==1){
            printing();
            //userdata.bill();
        }else {
            String selection = "من فضلك ادخل بيانات الاوردر ";
            Alert alert = new Alert(Alert.AlertType.ERROR, " " + selection + " !!!", ButtonType.OK);
            alert.showAndWait();
        }

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
    public int checkEmpty(){
        int check = 0;
        try {
            String sendOrderDetails = "SELECT EXISTS (SELECT 1 FROM preorder);";
            ResultSet dbResGetId = (ResultSet) initializeDB("jdbc:mysql://localhost:3306/KunafaHut?verifyServerCertificate=false&useSSL=true", "moreda", "moreda2021").executeQuery(sendOrderDetails);
            while (dbResGetId.next()){

               check = dbResGetId.getInt(1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return check;
    }


    public void printing(){

        int id;
        String sendOrderDetails;
        // generating
        if (ismod){
            id=idmod;
        }
        else {
            setIdgenerate();
            id =idgenerate;
        }

        // set ordet disc
        Double price = allTotal+allDisc;
        if (Orderdisc.isSelected()){
            Double x;
            x = returnDisc(allTotal);
            allDisc += allTotal-x;
            allTotal = x;
            price = allTotal+allDisc;
        }
        // coping data to another Field
        String sendOrderData = "insert into ordersdata (orderNo, type, name, no, quantity, price, disc, netPrice)\n" +
                "select ("+id+"), type, name, no, quantity, price, disc, netPrice from preorder;";
        if (ismod){
             sendOrderDetails = "UPDATE orderdetails set cachierName = '"+cashierName+"',orderTime = CURRENT_TIMESTAMP,price = "+price+", totDisc = "+allDisc+", totPrice = "+allTotal+",totNetPrice = totPrice+delivery where orderNo = "+id+";";

        }else {
             sendOrderDetails = "insert into orderdetails (orderNo, orderTime, cachierName, price, totDisc,totPrice, delivery, totNetPrice,clientName,clientPhone,clientLocation )\n" +
                    "value ("+idgenerate+", CURRENT_TIMESTAMP, '"+cashierName+"', "+price+", "+allDisc+", "+allTotal+",0,totNetPrice = totPrice+delivery,'',0,'');";
        }

        try {
            initializeDB("jdbc:mysql://localhost:3306/KunafaHut?verifyServerCertificate=false&useSSL=true","moreda","moreda2021").executeUpdate(sendOrderData);
            initializeDB("jdbc:mysql://localhost:3306/KunafaHut?verifyServerCertificate=false&useSSL=true","moreda","moreda2021").executeUpdate(sendOrderDetails);

        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();
        }
        clearAllData();
    }

    public void setIdgenerate(){
        // coping data to another Field
        String sqlscript = "SELECT orderNo FROM orderdetails ORDER BY orderNo DESC LIMIT 1;";
        int getId=0;
        try {
            ResultSet dbResGetId = (ResultSet) initializeDB("jdbc:mysql://localhost:3306/KunafaHut?verifyServerCertificate=false&useSSL=true", "moreda", "moreda2021").executeQuery(sqlscript);
            while (dbResGetId.next()){
                getId = (int) dbResGetId.getDouble("orderNo");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String lastGetId;
        Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("yyMMdd");
        String datetime = ft.format(dNow);
        lastGetId = String.valueOf(getId).substring(0,6);
        if (lastGetId.equals(datetime)){
            idgenerate = getId+1;
        }else {
            idgenerate = Integer.valueOf(datetime+"001");
        }
    }
}
