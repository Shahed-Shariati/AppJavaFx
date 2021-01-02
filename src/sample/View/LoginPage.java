package sample.View;

import com.jfoenix.controls.JFXTextField;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sample.DataBase.DataBase;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginPage  {
    private Connection connection;
    private Statement statement ;
    //private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private boolean checkPassUser = false;


    private void DataBaseConnect()
    {
        try
        {
            connection = DataBase.DataBaseConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select UserLoginName,UserLoginPassword from UserInfo");

            System.out.println("Connected");
        }catch (SQLException e)
        {
            System.out.println(e);

        }

    }

    private void  Login() throws SQLException, IOException {
        if(txtUserName.getText().trim().isEmpty() && txtPassword.getText().trim().isEmpty())
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("title");
            alert.setContentText("Enter User & Passwoed:");
            alert.showAndWait();

        } else {

            try {
                String userName;
                String passWord;

                DataBaseConnect();
                while (resultSet.next()) {
                    userName = resultSet.getNString(1);
                    passWord = resultSet.getString(2);
                    if (txtUserName.getText().compareTo(userName) == 0 && txtPassword.getText().compareTo(passWord) == 0) {
                        checkPassUser = true;

                        resultSet.close();
                        statement.close();
                        connection.close();
                        break;
                    }
                }
            } catch (SQLException e) {

                resultSet.close();
                statement.close();
                connection.close();
                System.out.println("Close Connection");

            }
        }
        if(checkPassUser)
        {
            System.out.println("hello");
            Stage stage = (Stage) btnSingIn.getScene().getWindow();
            stage.close();
            Stage primarystage = new Stage();
            AnchorPane root = FXMLLoader.<AnchorPane>load(getClass().getResource("HomePage.fxml"));
            Scene scene = new Scene(root,1345,700);
            primarystage.setScene(scene);
            primarystage.show();

        }else
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("title");
            alert.setContentText("UserName or Password is incorrect");
            alert.showAndWait();

        }


    }
    private void AlertLoginPage(String type,String title,String text)
    {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(text);
        alert.showAndWait();

    }



    @FXML
    private JFXTextField txtUserName;

    @FXML
    private Button btnExit;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private Button btnSingIn;

    @FXML
    void pressBtnSingIn(ActionEvent event) {
          }

    @FXML
    void pressBtnExit(ActionEvent event) {
    }



    public void pressBtnExit(javafx.event.ActionEvent actionEvent)
    {
        Platform.exit();
    }

    public void pressBtnSingIn(javafx.event.ActionEvent actionEvent ) throws IOException, SQLException
    {
        Login();
    }






    public void enterBtnSingIn(KeyEvent keyEvent) throws IOException, SQLException
    {

    }




    public void pressKeyLoginPage(KeyEvent event) throws IOException, SQLException {
        if(event.getCode() == KeyCode.ESCAPE )
        {
            Platform.exit();
        }else if(event.getCode() == KeyCode.F)
        {
            Login();
        }
    }
}



