package sample;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;
public class Main extends Application {
    Stage primarystage;
    static Parent root;
    private static String sqlUser = "moreda" ;
    private static String sqlPass = "moreda2021";

    public static String getSqlUser() {
        return sqlUser;
    }

    public void setSqlUser(String sqlUser) {
        this.sqlUser = sqlUser;
    }

    public static String getSqlPass() {
        return sqlPass;
    }

    public void setSqlPass(String sqlPass) {
        this.sqlPass = sqlPass;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primarystage = primaryStage;
        root = FXMLLoader.load(getClass().getResource("fxml/signin.fxml"));
        primarystage.setTitle("كنافة هت");
        primarystage.setScene(new Scene(root));
        primarystage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }

    public static String getValidation() {
        final String[] x = {""};
        // create a text input dialog
        TextInputDialog td = new TextInputDialog();
        td.showAndWait();
        x[0] = td.getEditor().getText();
        return x[0];
    }
    public static boolean isEnter(){
        final String pass = "هت2021";
        String x = Main.getValidation();
        if (x.equals(pass)){
            return true;
        }
        else {
            return false;
        }
    }
}
