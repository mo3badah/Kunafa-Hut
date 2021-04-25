package sample.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.*;
import java.util.Observable;
import java.util.ResourceBundle;


public class selling implements Initializable {
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

    public void initialize(URL location, ResourceBundle resources) {
        setSellingTable();
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
            kilo = Double.valueOf(dbResSell.getString("kilo/big"));
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
            kilo = Double.valueOf(dbResSell.getString("kilo/big"));
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
            kilo = Double.valueOf(dbResSell.getString("kilo/big"));
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
            kilo = Double.valueOf(dbResSell.getString("kilo/big"));
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
            piece = Double.valueOf(dbResSell.getString("piece/medium"));
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
            piece = Double.valueOf(dbResSell.getString("piece/medium"));
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
            piece = Double.valueOf(dbResSell.getString("piece/medium"));
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
            piece = Double.valueOf(dbResSell.getString("piece/medium"));
        }
        Ono = piecesenter;
        Oquantity = "قطعة";
        Oprice = piece*piecesenter;
        onePrice.setText(String.valueOf(Oprice));
    }

    // Form, Cups and Mix Buttons
    public void buttonMediumEnter(javafx.event.ActionEvent actionEvent) throws SQLException {
        Double kilo = 0.0 ;
        Double piecesenter = 1.0 ;
        String typeId = null;
        try {
            piecesenter = Double.valueOf(midno.getText());
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
        String sqlscript = "SELECT * from kunafahut.types where id = '" + typeId + "'";
        dbResSell = (ResultSet) initializeDB("jdbc:mysql://localhost:3306/KunafaHut?verifyServerCertificate=false&useSSL=true","moreda","moreda2021").executeQuery(sqlscript);
        while (dbResSell.next()) {
            Otype = dbResSell.getString("type");
            Oname = dbResSell.getString("name");
            kilo = Double.valueOf(dbResSell.getString("piece/medium"));
        }
        Ono = piecesenter;
        if (Otype.equals("كوب")){
            Oquantity = "صغير";
        }else {
            Oquantity = "وسط";
        }
        Oprice = kilo*piecesenter;
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
        String sqlscript = "SELECT * from kunafahut.types where id = '" + typeId + "'";
        dbResSell = (ResultSet) initializeDB("jdbc:mysql://localhost:3306/KunafaHut?verifyServerCertificate=false&useSSL=true","moreda","moreda2021").executeQuery(sqlscript);
        while (dbResSell.next()) {
            Otype = dbResSell.getString("type");
            Oname = dbResSell.getString("name");
            kilo = Double.valueOf(dbResSell.getString("kilo/big"));
        }
        Ono = piecesenter;
        if (Otype.equals("كوب")){
            Oquantity = "وسط";
        }else {
            Oquantity = "كبير";
        }
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
            kilo = Double.valueOf(dbResSell.getString("piece/medium"));
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
            kilo = Double.valueOf(dbResSell.getString("piece/medium"));
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
            kilo = Double.valueOf(dbResSell.getString("piece/medium"));
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
            kilo = Double.valueOf(dbResSell.getString("piece/medium"));
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
            kilo = Double.valueOf(dbResSell.getString("piece/medium"));
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
            kilo = Double.valueOf(dbResSell.getString("piece/medium"));
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
            kilo = Double.valueOf(dbResSell.getString("piece/medium"));
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
        }
        sellingTable.getItems().clear();
        setSellingTable();
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
                System.out.println("updated successfully!");
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


    public Statement initializeDB(String dburl,String dbuser,String dbpass) throws SQLException {
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




}
