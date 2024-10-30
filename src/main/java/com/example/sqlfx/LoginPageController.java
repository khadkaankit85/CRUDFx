package com.example.sqlfx;

import com.example.DAO.UserDAO;
import com.example.model.User;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginPageController {

    public Text userNameLabel;
    public TextField usernameTextField;
    public TextField passwordTextField;
    public Label msgTextField;

    static  HelloController newcon;
    public Label signinLabel;
    public Label loggedInLabel;

    public  void  initialiseHelloController(){
        if(newcon==null) {
            System.out.println("new instance of hellocontroller in login page controller created");
            newcon = new HelloController();
        }
    }

    public void onGoToDatabasePage() {
        initialiseHelloController();
      newcon.changeSceneToAnother("hello-view.fxml",loggedInLabel);

    }

    public void onLogOutButtonPress() {
        initialiseHelloController();

        newcon.changeSceneToAnother("login-view.fxml",loggedInLabel);

    }

    public void onLoginButtonPress() throws SQLException {
        String userInputUsername=usernameTextField.getText();
        String userInputPassword=passwordTextField.getText();
        if (userInputPassword.length()<4 || userInputUsername.length()<4){
             msgTextField.setText("too short, try again");
        }
        else{
            msgTextField.setText("");
            UserDAO userdao=new UserDAO();
            userdao.startConnection();

            User user=new User(userInputUsername);
             ResultSet resultSet= userdao.getPasswordQueryResultset(user);

            if (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");

                if(userInputPassword.equals(password) && userInputUsername.equals(username)){
                    initialiseHelloController();

                    newcon.changeSceneToAnother("loggedin-view.fxml",signinLabel);
                }
                else{
                    msgTextField.setText("Incorrect password");
                }

            }
        }

    }
}
