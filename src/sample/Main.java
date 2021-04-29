package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.EventObject;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main extends Application {
    Stage primarystage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        primarystage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("fxml/ordersConfig.fxml"));
        primarystage.setTitle("كنافة هت");
        primarystage.setScene(new Scene(root));
        primarystage.show();

    }


    public static void main(String[] args) {
        launch(args);


    }
    public void userData(){



    }
    public static void showuserdata() throws IOException {
        FXMLLoader loader= new FXMLLoader();
        loader.setLocation(Main.class.getResource("fxml/signIn.fxml"));
        BorderPane userdata = loader.load();
        Stage userdatastage;



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
