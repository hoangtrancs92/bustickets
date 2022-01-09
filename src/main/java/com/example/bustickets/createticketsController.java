package com.example.bustickets;
import com.example.bustickets.alerts.alert;
import com.example.bustickets.model.*;
import com.example.bustickets.config.JdbcUtils;
import com.example.bustickets.services.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class createticketsController implements Initializable {
    // Chuyển đổi screen ( chuyển đổi giữa các file fxml )
    private Stage stage;
    private Scene scene;
    private Parent fxmlLoader;


    //Hiển thị và lấy dữ liệu user
    @FXML
    private Label lblName;
    @FXML
    private Label lblID;
    @FXML
    private Button createTickets_button;
    @FXML
    private Button managerUser_button;
    @FXML
    private Button managerEmploy_button;
    @FXML
    private Button managerTicket_button;
    users user = new users();

    public void getUser(users u){
        user.setIdusers(u.getIdusers());
        user.setName(u.getName());
        user.setAddress(u.getAddress());
        user.setSex(u.getSex());
        user.setEmail(u.getEmail());
        user.setBirthday(u.getBirthday());
        user.setPhone(u.getPhone());
        user.setRole(u.getRole());
        lblName.setText("Name " + u.getName());
        lblID.setText(String.valueOf("ID: " + u.getIdusers()));
        if(user.getRole() == 1){
            createTickets_button.setDisable(true);
            createTickets_button.setStyle("-fx-opacity: 0");
            managerTicket_button.setDisable(true);
            managerTicket_button.setStyle("-fx-opacity:0");
            managerUser_button.setDisable(true);
            managerUser_button.setStyle("-fx-opacity: 0");
            managerEmploy_button.setDisable(true);
            managerEmploy_button.setStyle("-fx-opacity: 0");
            lblName.setText("Name " + u.getName());
            lblID.setText(String.valueOf("ID: " + u.getIdusers()));
        }else if(user.getRole() == 2){
            managerUser_button.setDisable(true);
            managerUser_button.setStyle("-fx-opacity: 0");
            managerEmploy_button.setDisable(true);
            managerEmploy_button.setStyle("-fx-opacity: 0");
            lblName.setText("Name " + u.getName());
            lblID.setText(String.valueOf("ID: " + u.getIdusers()));
        }else{
            lblName.setText("Name " + u.getName());
            lblID.setText(String.valueOf("ID: " + u.getIdusers()));;}
    }
    //Nút đăng xuất
    public void Logout(ActionEvent event) throws IOException {
        fxmlLoader = FXMLLoader.load(getClass().getResource("login.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader);
        stage.setScene(scene);
        stage.show();
    }


    // Chuyển sang manager_ticket.fxml
    public void switchToManager_tickets(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("manager_tickets.fxml"));
        Parent userViewParent = loader.load();
        Scene scene = new Scene(userViewParent);
        stage.setScene(scene);
        managerticketsController controller = loader.getController();
        controller.getUser(user);
        stage.setScene(scene);
        stage.show();
    }
    // Chuyển sang bookings_tickets.fxml
    public void switchToBookings_tickets(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("bookings_tickets.fxml"));
        Parent userViewParent = loader.load();
        Scene scene = new Scene(userViewParent);
        stage.setScene(scene);
        bookingsController controller = loader.getController();
        controller.getUser(user);
        stage.setScene(scene);
        stage.show();
    }
    // Chuyển sang manage_employees.fxml
    public void switchToManage_employees(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("manage_employees.fxml"));
        Parent userViewParent = loader.load();
        Scene scene = new Scene(userViewParent);
        stage.setScene(scene);
        manageremployeesController controller = loader.getController();
        controller.getUser(user);
        stage.setScene(scene);
        stage.show();
    }
    // Chuyển sang manage_users.fxml
    public void switchToManage_users(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("manage_users.fxml"));
        Parent userViewParent = loader.load();
        Scene scene = new Scene(userViewParent);
        stage.setScene(scene);
        manageruserController controller = loader.getController();
        controller.getUser(user);
        stage.setScene(scene);
        stage.show();
    }
    // viet code truy xuat sql tai day

    @FXML
    private ComboBox<starting_points> StartPoint_cbbox;
    @FXML
    private  ComboBox<cars> carsComboBox;
    @FXML
    private ComboBox<users> employeesComboBox;
    @FXML
    private ComboBox<finishing_points> endPoint_cbbox;
    @FXML
    private ComboBox<time> time_comboBox;
    @FXML
    private TextField txt_giave;
    @FXML
    private DatePicker txt_ngaykhoihanh;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // ComboBox cars
        carServices s = new carServices();
        try {
            this.carsComboBox.setItems(FXCollections.observableList(s.getCars()));
        } catch (SQLException e) {
            Logger.getLogger(createticketsController.class.getName()).log(Level.SEVERE, (String) null);
        }
        // ComboBox employee
        employeeServices eS = new employeeServices();
        try {
            this.employeesComboBox.setItems(FXCollections.observableList(eS.getEmployees()));
        } catch (SQLException e) {
            Logger.getLogger(createticketsController.class.getName()).log(Level.SEVERE, (String) null);
        }
        // ComboBox starting_point
        startServices stS = new startServices();
        try {
            this.StartPoint_cbbox.setItems(FXCollections.observableList(stS.getPoint()));
        } catch (SQLException e) {
            Logger.getLogger(createticketsController.class.getName()).log(Level.SEVERE, (String) null);
        }
        //ComboBox finishing_point
        finishServices fnS = new finishServices();
        try {
            this.endPoint_cbbox.setItems(FXCollections.observableList(fnS.getPointEnd()));
        } catch (SQLException e) {
            Logger.getLogger(createticketsController.class.getName()).log(Level.SEVERE, (String) null);
        }
        //ComboBox time
        timeServices tm = new timeServices();
        try {
            this.time_comboBox.setItems(FXCollections.observableList(tm.getTime()));
        } catch (SQLException e) {
            Logger.getLogger(createticketsController.class.getName()).log(Level.SEVERE, (String) null);
        }

        // force the field to be numeric only
        // Chặn chữ trong text field
        this.txt_giave.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    txt_giave.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

    }





    public void addTickets(ActionEvent event) throws SQLException, InterruptedException, ParseException {


        // alert complete
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("WARNING");
        alert.setContentText("Are you ok ?");
        alert.setHeaderText("This confirmation tickets");


        Date date = new Date();
        System.out.println(date);
        Date date_start = new SimpleDateFormat("dd/MM/yyyy").parse(txt_ngaykhoihanh.getEditor().getText());
        Optional<ButtonType> result = alert.showAndWait();
        //
        if (result.get() == ButtonType.OK){
            if(date_start.after(date)){
                tickets t = new tickets(this.StartPoint_cbbox.getSelectionModel().getSelectedItem().getStart(), this.endPoint_cbbox.getSelectionModel().getSelectedItem().getFinish(),this.carsComboBox.getSelectionModel().getSelectedItem().getNumber_seat(), this.txt_ngaykhoihanh.getEditor().getText() ,this.txt_giave.getText(),this.employeesComboBox.getSelectionModel().getSelectedItem().getIdusers(),this.time_comboBox.getSelectionModel().getSelectedItem().getTime(),this.carsComboBox.getSelectionModel().getSelectedItem().getIdcars());
                createticketsServices ctS = new createticketsServices();
                try {
                    // add data to mysql
                    ctS.addSetOfTickets(t);

                } catch (SQLException e) {
                    e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
                }

                // Auto create detail_tickets ( dua tren so cho ngoi )
                createticketsServices st = new createticketsServices();
                for(int i = 0; i < st.idSetOffTickets().size();i++){
                    for (int j =this.carsComboBox.getSelectionModel().getSelectedItem().getNumber_seat(); j >0;j--){
                        detail_tickets dt = new detail_tickets(UUID.randomUUID().toString(),st.idSetOffTickets().get(i).getIdtickets());
                        System.out.println(dt.getIddetail_tickets());
                        System.out.println(dt.getId_tickets());
                        detailticketsServices dtS = new detailticketsServices();
                        System.out.println(dtS);
                        dtS.AddDetailTickets(dt);
                    }

                }
                Thread.sleep(1000);
                System.out.println("SUCCESSFUL");
                txt_giave.clear();
                StartPoint_cbbox.valueProperty().set(null);
                txt_ngaykhoihanh.valueProperty().set(null);
                carsComboBox.valueProperty().set(null);
                employeesComboBox.valueProperty().set(null);
                endPoint_cbbox.valueProperty().set(null);
                time_comboBox.valueProperty().set(null);
            }
            else {
                alert al = new alert();
                al.showAlertWithWarningHeaderText_Createtickets();
            }

        }
        else
        {
            System.out.println(("ERROR"));
        }
    }
}
