package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.jetbrains.annotations.NotNull;

public class Main extends Application {

    @Override
    public void start(@NotNull Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("View/LoginPage.fxml"));
        primaryStage.setTitle("ورود به برنامه");
        primaryStage.setScene(new Scene(root, 430, 240));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
