package com.example.bustickets;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.Connection;
import java.util.Date;

public class signUpController {
    @FXML private Label lblUsername;
    @FXML private Label lblPassword;
    @FXML private Label lblConfirmPassword;
    @FXML private Label lblEmail;
    @FXML private Label lblAddress;
    @FXML private Label lblPhone;
    @FXML private Label lblSex;
    @FXML private Label lblBirthday;
    @FXML private RadioButton rdoMale;
    @FXML private RadioButton rdoFemale;
    @FXML private RadioButton rdoOther;
    @FXML private TextField txtUsername;
    @FXML private TextField txtEmail;
    @FXML private Number numPhone;
    @FXML private PasswordField Password;
    @FXML private PasswordField ConfirmPassword;
    @FXML private Date dateBirth;
    @FXML private Button btnSignUp;
    @FXML private Button btnCancel;

}
