package com.example.bustickets;

import com.example.bustickets.model.users;
import com.example.bustickets.services.userServices;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class registerController {
    @FXML TextField usernameField;
    @FXML TextField EmailField;
    @FXML TextField addressField;
    @FXML TextField phoneField;
    @FXML PasswordField passwordField;
    @FXML PasswordField confirmPasswordField;
    @FXML Button btnClose;
    @FXML DatePicker birthday;
    @FXML RadioButton rButton1;
    @FXML RadioButton rButton2;
    @FXML RadioButton rButton3;
    private Stage stage;
    private Scene scene;
    private Parent fxmlLoader;


    public void buttonRegister (ActionEvent event){
        int sex;
        if(rButton1.isSelected()){
            sex = 0;
        }else if(rButton2.isSelected()){
            sex = 1;
        }else sex = 3;

        
        users u = new users(this.usernameField, this.passwordField, this.EmailField, this.phoneField, this.addressField,this.birthday,sex);
        userServices userSer = new userServices();
        try {
            userSer.addUsers(u);
            //reset
            fxmlLoader = FXMLLoader.load(getClass().getResource("regiser.fxml"));
            stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(fxmlLoader);
            stage.setScene(scene);
            stage.show();
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
    }

    public void CancelRegister (ActionEvent event) {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
    }
}
