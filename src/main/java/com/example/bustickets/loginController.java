package com.example.bustickets;
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
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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

    public void LoginButton(ActionEvent event) throws SQLException, IOException {
        userServices userSer = new userServices();
        if (txtUsername.getText().isBlank() == false && passwordField.getText().isBlank() == false) {
            List<users> userList = userSer.getUser();
            for (int i = 0; i < userList.size(); i++) {
               String password = userList.get(i).getPassword();
               password = AES.decrypt(password,secretKey);
                if(userList.get(i).getEmail().equals(txtUsername.getText()) && password.equals(passwordField.getText())){
                    //Chuyển Scene
                            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                            FXMLLoader loader = new FXMLLoader();
                            loader.setLocation(getClass().getResource("bookings_tickets.fxml"));
                            Parent userViewParent = loader.load();
                            Scene scene = new Scene(userViewParent);
                            stage.setScene(scene);
                            bookingsController controller = loader.getController();
                            users u = userSer.getUserById(userList.get(i).getIdusers());
                            controller.getUser(u);
                            stage.setScene(scene);
                            stage.show();
                }else {
                    LoginMessage.setText("Email hoặc mật khẩu không đúng. Vui lòng thử lại!");
                }
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
