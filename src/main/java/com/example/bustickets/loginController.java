package com.example.bustickets;
import com.example.bustickets.config.JdbcUtils;
import com.example.bustickets.model.users;
import com.example.bustickets.services.AES;
import com.example.bustickets.services.userServices;
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
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class loginController implements Initializable {
    final String secretKey = "12345678";

    @FXML
    private Label LoginMessage;
    @FXML
    private Button btnCancelLogin;
    @FXML
    private TextField txtUsername;
    @FXML
    private PasswordField passwordField;
    private Stage stage;
    private Scene scene;
    private Parent fxmlLoader;

    public void LoginButton(ActionEvent event) throws SQLException {
        if (txtUsername.getText().isBlank() == false && passwordField.getText().isBlank() == false) {
            Connection conn = JdbcUtils.getCnn();
            try {
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT users.* FROM bustickets_db.users WHERE users.password is not null");
                while (rs.next()) {
                    String password = rs.getString("password");
                    password = AES.decrypt(password, secretKey);
                    if (rs.getString("email").equals(txtUsername.getText()) && password.equals(passwordField.getText())) {
//                        LoginMessage.setText("Đăng nhập thành công!");
//                        LoginMessage.setTextFill(Color.GREEN);

                            //Chuyển Scene
                            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                            FXMLLoader loader = new FXMLLoader();
                            loader.setLocation(getClass().getResource("bookings_tickets.fxml"));
                            Parent userViewParent = loader.load();
                            Scene scene = new Scene(userViewParent);
                            stage.setScene(scene);
                            bookingsController controller = loader.getController();
                            users u = new users(rs.getInt("iduser"), rs.getString("name"), password,
                                    rs.getString("email"), rs.getString("phone"),
                                    rs.getString("address"), rs.getString("birthday"),
                                    rs.getInt("sex"),rs.getInt("role"));
                            controller.getUser(u);
                            stage.setScene(scene);
                            stage.show();

                    } else {
                        LoginMessage.setText("Email hoặc mật khẩu không đúng. Vui lòng thử lại!");
                    }
                }
                stm.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            LoginMessage.setText("Đăng nhập thất bại. Vui lòng điền đầy đủ thông tin!");

        }
    }

    public void CancelLogin(ActionEvent event) {
        Stage stage = (Stage) btnCancelLogin.getScene().getWindow();
        stage.close();
    }

    //Chuyển đến trang đăng ký
    public void switchToRegister(ActionEvent event) throws IOException {
        fxmlLoader = FXMLLoader.load(getClass().getResource("register.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }
}
