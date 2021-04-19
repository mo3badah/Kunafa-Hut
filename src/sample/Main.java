package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("fxml/signIn.fxml"));
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
}
