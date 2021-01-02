package sample.View;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomePage  implements Initializable {


    @FXML
    private VBox vboxHomePage;

    @FXML
    private BorderPane borderPaneHomePage;

    @FXML
    private MenuItem btnMenuPerson;

    @FXML
    private Menu btnMenuExit;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {

    }

    public void pressPersonMenu(ActionEvent actionEvent) throws IOException {


        AnchorPane root = FXMLLoader.load(getClass().getResource("PersonPage.fxml"));

        Scene scene = new Scene(root,300,300);
        borderPaneHomePage.setCenter(root);

        //Stage primary = new Stage();
        //primary.setScene(scene);
        //primary.show();
    }
}
