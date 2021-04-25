package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("fxml/selling.fxml"));
        primaryStage.setTitle("كنافة هت");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);


    }
    public void userData(){
        try {
            Stage userDataStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("fxml/userdata.fxml"));
            userDataStage.setTitle("كنافة هت");
            userDataStage.setScene(new Scene(root));
            userDataStage.show();


        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }

    }
    public void initializeDB(String dburl,String dbuser,String dbpass) {
        // DB parameters
        Connection dbconn;
        Statement dbstm;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded");
            dbconn = DriverManager.getConnection(dburl, dbuser, dbpass);
            System.out.println("DataBase connected");
            dbstm = dbconn.createStatement();
        } catch (ClassNotFoundException | SQLException var2) {
            System.err.println(var2.getMessage());
        }

    }
}
