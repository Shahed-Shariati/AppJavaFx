package sample.View;

import com.jfoenix.controls.JFXTextField;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.awt.event.ActionEvent;

public class LoginPage {

    @FXML
    private JFXTextField txtUserName;

    @FXML
    private Button btnExit;

    @FXML
    void pressBtnExit(ActionEvent event) {

    }

    public void pressBtnExit(javafx.event.ActionEvent actionEvent) {
        Platform.exit();
    }
}
