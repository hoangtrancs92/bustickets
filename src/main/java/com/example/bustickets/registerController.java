/**
 * Người tạo: Trần Văn Bo
 */
package com.example.bustickets;

import com.example.bustickets.services.AES;
import com.example.bustickets.services.DataValidator;
import com.example.bustickets.model.users;
import com.example.bustickets.services.userServices;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
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
    @FXML DatePicker txtBirthday;
    @FXML RadioButton rButton1;
    @FXML RadioButton rButton2;
    @FXML RadioButton rButton3;
    @FXML Label lblRegisterMessage;
    @FXML Label lblEmailMessage;
    @FXML Label lblPhoneMessage;
    @FXML Label lblConfirmMessage;

    private Stage stage;
    private Scene scene;
    private Parent fxmlLoader;
    public void buttonRegister (ActionEvent event){
        final String secretKey = "12345678";

        String name = usernameField.getText();
        String password = passwordField.getText();
        String confirmPassword = confirmPasswordField.getText();
        String email = EmailField.getText();
        String phone = phoneField.getText();
        String address = addressField.getText();
        String birthday = txtBirthday.getEditor().getText();
        int sex;
        if(rButton1.isSelected()){ //Nam
            sex = 0;
        }else if(rButton2.isSelected()){ // Nữ
            sex = 1;
        }else sex = 3; // Khác
        if(name.isBlank() == false && password.isBlank() == false && confirmPassword.isBlank() == false && address.isBlank() == false && phone.isBlank() == false && email.isBlank() == false && birthday.isBlank() == false || rButton1.isSelected() || rButton2.isSelected() || rButton3.isSelected()){ // kiểm tra Empty

            DataValidator check = new DataValidator() ;
            //check Email
            if (check.checkEmail(EmailField,lblEmailMessage) == false){
                return;
            }
            //check SDT
            if (check.checkSDT(phoneField,lblPhoneMessage) == false){
                return;
            }
            //check password
            if (password.equals(confirmPassword) == false){
                lblConfirmMessage.setText("Mật khẩu không trùng khớp!");
                lblConfirmMessage.setTextFill(Color.RED);
                return;
            }
            //Mã hóa dữ liệu gửi về database
            password = AES.encrypt(password,secretKey);

            users u = new users(name,password, email, phone, address,birthday,sex);
            userServices userSer = new userServices();
            try {
                userSer.addUsers(u);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("THÔNG BÁO");
                alert.setHeaderText("Đăng ký thành công!");
                alert.show();
                //reset màn hình sau khi đăng ký thành công
                fxmlLoader = FXMLLoader.load(getClass().getResource("register.fxml"));
                stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(fxmlLoader);
                stage.setScene(scene);
                stage.show();
            } catch (SQLException | IOException e) {
                e.printStackTrace();
                e.getCause();
            }
        }else{
            lblRegisterMessage.setText("Vui lòng điền đầy đủ thông tin!");
        }

    }


    public void switchToLogin(ActionEvent event) throws IOException {
        fxmlLoader = FXMLLoader.load(getClass().getResource("login.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader);
        stage.setScene(scene);
        stage.show();
    }

    public void CancelRegister (ActionEvent event) {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
    }
}
