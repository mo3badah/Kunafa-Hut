package sample.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

import java.sql.*;

import javafx.scene.paint.Color;


public class signIn implements Initializable {
    // DB parameters
    private String dburl = "jdbc:mysql://localhost:3306/KunafaHut?verifyServerCertificate=false&useSSL=true";
    private String dbuser = "moreda";
    private String dbpass = "moreda2021";
    private Connection dbconn;
    private Statement dbstm;
    private ResultSet dbres;
    private ResultSet dbresLog;


    public String userdata;
    @FXML
    private TextField userName;
    @FXML
    private PasswordField password;
    @FXML
    private Button signButton;
    @FXML
    private Label loginText;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


    public void buttonAlert(javafx.event.ActionEvent actionEvent) throws SQLException {

        //       loginText.setText("you enter the sign in button successfully");
        dbconn = DriverManager.getConnection(dburl, dbuser, dbpass);
        dbstm = dbconn.createStatement();
        dbres = dbstm.executeQuery("SELECT * from kunafahut.user");
        while (dbres.next()) {
            String username = dbres.getString(1);
            String phone = dbres.getString(2);
            String password = dbres.getString(3);
            String timedate = dbres.getString(4);
            userdata += "username : " + username + " phone: " + phone + " password: " + password + " timedate: " + timedate + " .\n";
        }
        System.out.println(userdata);
        if (userName.getText().isEmpty() == true) {
            loginText.setText("please enter the user name and password");
        } else try {
            try {
                dbresLog = dbstm.executeQuery("SELECT * from kunafahut.user where username = '" + userName.getText() + "' AND password = '" + password.getText() + "'");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            String databaseUsername = "";
            String databasePassword = "";
            while (dbresLog.next()) {
                databaseUsername = dbresLog.getString("username");
                databasePassword = dbresLog.getString("password");
            }
            System.out.println(databaseUsername + "\n" + databasePassword + "\n" + password);


            if (userName.getText().equals(databaseUsername) && password.getText().equals(databasePassword)) {
                loginText.setText("Congratulation you had already signed in");
                loginText.setTextFill(Color.GREEN);
            } else {
                loginText.setText("Please try again");
                loginText.setTextFill(Color.RED);

            }

        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();
        }
    }
}
