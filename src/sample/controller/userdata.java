package sample.controller;

import com.jfoenix.controls.JFXBadge;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.print.PageLayout;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

import javafx.stage.Stage;
import sample.controller.selling;


public class userdata implements Initializable {
    @FXML
    private AnchorPane userdata;

    @FXML
    private TextField setNow;

    @FXML
    private TextField setId;

    @FXML
    private TextField TuserName;

    @FXML
    private TextField Tphone;

    @FXML
    private TextField Tlocation;

    @FXML
    private TextField Tprice;

    @FXML
    private TextField Tdelivery;

    @FXML
    private TextField TtotDisc;

    @FXML
    private TextField TtotNetPrice;

    @FXML
    private TextField Tprint;
    @FXML
    private static TextArea textArea;

    public static int idgenerate;
    public static Timestamp orderTime;
    public static String username;
    public static int userphone;
    public static String userlocation;
    public static int delivery;
    public static double price;
    public static double totdisc;
    public static int totnetprice;

    private selling selling;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        getGenerated();
        setNow.setText(String.valueOf(orderTime));
        setId.setText(String.valueOf(idgenerate));
        TuserName.setText(String.valueOf(username));
        Tphone.setText(String.valueOf(userphone));
        Tlocation.setText(String.valueOf(userlocation));
        Tprice.setText(String.valueOf(price));
        Tdelivery.setText(String.valueOf(delivery));
        TtotDisc.setText(String.valueOf(totdisc));
        TtotNetPrice.setText(String.valueOf(totnetprice));


    }

    public String  timeNow() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

    public static void getGenerated() {
        int id;
        if (sample.controller.selling.isIsmod()){
            id= sample.controller.selling.getIdmod();
        }
        else {
            id = sample.controller.selling.getIdgenerate();
        }
        // coping data to another Field
        String sqlscript = "SELECT * FROM orderdetails where  orderNo = "+id+";";
        try {
            ResultSet dbResGetId = (ResultSet) initializeDB("jdbc:mysql://localhost:3306/KunafaHut?verifyServerCertificate=false&useSSL=true", "moreda", "moreda2021").executeQuery(sqlscript);
            while (dbResGetId.next()){
                idgenerate = dbResGetId.getInt("orderNo");
                orderTime = dbResGetId.getTimestamp("orderTime");
                username = dbResGetId.getString("clientName");
                userphone = dbResGetId.getInt("clientPhone");
                userlocation = dbResGetId.getString("clientLocation");
                price = dbResGetId.getInt("price");
                totdisc = dbResGetId.getDouble("totDisc");
                delivery = dbResGetId.getInt("delivery");
                totnetprice = dbResGetId.getInt("totNetPrice");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void printing2(javafx.event.ActionEvent actionEvent){
        savingNewData();
        bill();
        /*
        try {
            selling.setIsmod(false);
            Parent userview = FXMLLoader.load(getClass().getResource("../fxml/selling.fxml"));
            Scene userscene = new Scene(userview);
            Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            window.setScene(userscene);
            window.show();

        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
        */
    }

    public void savingNewData(){
        try {
            delivery = Integer.parseInt(Tdelivery.getText());
            username = TuserName.getText();
            userphone = Integer.parseInt((Tphone.getText()));
            userlocation = Tlocation.getText();
        }catch (Exception e){
            e.getCause();
        }
        // coping data to another Field
        String sendOrderDetails = "UPDATE orderdetails set clientName = '"+username+"',clientPhone = "+userphone+",clientLocation = '"+userlocation+"', delivery = "+delivery+", totNetPrice = totPrice+delivery where orderNo = "+idgenerate+";";

        try {
            initializeDB("jdbc:mysql://localhost:3306/KunafaHut?verifyServerCertificate=false&useSSL=true","moreda","moreda2021").executeUpdate(sendOrderDetails);

        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();
        }

    }



    public static Statement initializeDB(String dburl, String dbuser, String dbpass) throws SQLException {
        // DB parameters
        Connection dbconn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            dbconn = DriverManager.getConnection(dburl, dbuser, dbpass);
        } catch (ClassNotFoundException | SQLException var2) {
            System.err.println(var2.getMessage());
        }
        return dbconn.createStatement();

    }
    static String textbill;
    public static void bill(){
        getGenerated();
        textbill ="                          كنافة هت                   "+"\n"+
                "                        رمضان كريم                     "+"\n"+
                "=======================================================\n"+
                "          رقم الاوردر   :      "+idgenerate+" \n"+
                "    الوفت والتاريخ:  "+orderTime+" \n"+
                "=======================================================\n"+
                "         اسم العميل   :          "+username+" \n"+
                "         رقم التليفون :          "+userphone+" \n"+
                "             العنوان  :          "+userlocation+" \n"+
                "=======================================================\n"+
                "  الصنف   "+" \t"+"  الكمية  "+" \t"+"  الخصم  "+" \t"+"اللإجمالي"+" \n";

        String sqlscript = "SELECT * FROM ordersdata where orderNo = "+idgenerate+";";
        try {
            ResultSet dbResGetId = (ResultSet) initializeDB("jdbc:mysql://localhost:3306/KunafaHut?verifyServerCertificate=false&useSSL=true", "moreda", "moreda2021").executeQuery(sqlscript);
            while (dbResGetId.next()){
                String type = dbResGetId.getString("type");
                String name = dbResGetId.getString("name");
                double no = dbResGetId.getDouble("no");
                String quantity = dbResGetId.getString("quantity");
                double discount = dbResGetId.getDouble("disc");
                double total = dbResGetId.getDouble("netPrice");
                textbill+= type+" "+name+"\t"+no+" "+quantity+"\t"+discount+"\t"+total+"\n";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sqlscript2 = "SELECT * FROM orderdetails  where orderNo = "+idgenerate+";";
        try {
            ResultSet dbResGetId = (ResultSet) initializeDB("jdbc:mysql://localhost:3306/KunafaHut?verifyServerCertificate=false&useSSL=true", "moreda", "moreda2021").executeQuery(sqlscript2);
            while (dbResGetId.next()){

                price = dbResGetId.getDouble("price");
                totdisc = dbResGetId.getDouble("totDisc");
                delivery = dbResGetId.getInt("delivery");
                totnetprice = dbResGetId.getInt("totNetPrice");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        textbill+="=======================================================\n"+
                "السعر قبل الخصم :  "+"\t\t\t\t"+price+"\n"+
                "  إجمالي الخصم  :  "+"\t\t\t\t"+totdisc+"\n"+
                "      الدليفري  :  "+"\t\t\t\t"+delivery+"\n"+
                "       الإجمالي  :  "+"\t\t\t\t"+totnetprice+"\n"+
                "=======================================================\n"+
                "            سهرتك تحلي في رمضان مع كنافة هت             "+"\n"+
                " العاشر من رمضان - المجاورة السابعة - امام شبكة المياة  "+"\n"+
                "                          01006318817                    ";
        try {
            //textArea.setText(textbill);
            print();
        }catch (Exception e){
            e.getCause();
            e.printStackTrace();
        }

    }
    private static void print() {

        TextFlow printArea = new TextFlow(new Text(textbill));

        PrinterJob printerJob = PrinterJob.createPrinterJob();

        if (printerJob != null ) {
            PageLayout pageLayout = printerJob.getJobSettings().getPageLayout();
            printArea.setMaxWidth(pageLayout.getPrintableWidth());


            if (printerJob.printPage(printArea)) {
                printerJob.endJob();
                // done printing
            } else {
                System.out.println("Failed to print");
            }
        } else {
            System.out.println("Canceled");
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

    public  void gotoselling(javafx.event.ActionEvent actionEvent){
        try {
            Parent userview = FXMLLoader.load(menuPage.class.getResource("../fxml/selling.fxml"));
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
