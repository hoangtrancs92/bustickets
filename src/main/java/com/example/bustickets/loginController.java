package com.example.bustickets;
import com.example.bustickets.config.JdbcUtils;
import com.example.bustickets.model.admin;
import com.example.bustickets.services.AES;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class loginController implements Initializable {
    final String secretKey = "12345678";

    @FXML private Label LoginMessage;
    @FXML private Button btnCancelLogin;
    @FXML private TextField txtUsername;
    @FXML private PasswordField passwordField;
    private Stage stage;
    private Scene scene;
    private Parent fxmlLoader;
    public void LoginButton (ActionEvent event) throws SQLException {
        if(txtUsername.getText().isBlank() == false && passwordField.getText().isBlank() == false){
            validateLogin();
        }else{
            LoginMessage.setText("Đăng nhập thất bại. Xin thử lại!");

        }
    }

    public void CancelLogin (ActionEvent event) {
        Stage stage = (Stage) btnCancelLogin.getScene().getWindow();
        stage.close();
    }
    //Chuyển đến trang đăng ký
    public void switchToRegister(ActionEvent event) throws IOException {
        fxmlLoader = FXMLLoader.load(getClass().getResource("register.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }

    public void validateLogin() throws SQLException {
        Connection conn = JdbcUtils.getCnn();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM users");
            while (rs.next()){
                String password = rs.getString("password");
                password = AES.decrypt(password,secretKey);
                if(rs.getString("email").equals(txtUsername.getText()) && password.equals(passwordField.getText())){
                    LoginMessage.setText("Đăng nhập thành công!");
                    LoginMessage.setTextFill(Color.GREEN);
                }else {
                    LoginMessage.setText("Email hoặc mật khẩu không đúng. Vui lòng thử lại!");
                }
            }
            stm.close();
        }catch(Exception e){
            e.printStackTrace();
            }
        }
}
