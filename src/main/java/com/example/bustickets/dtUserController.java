package com.example.bustickets;

import com.example.bustickets.alerts.totalMoney;
import com.example.bustickets.model.users;
import com.example.bustickets.services.TotalMoneyServices;
import com.example.bustickets.services.managerticketsServices;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class dtUserController implements Initializable {
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

    private void setTable_view(){
        TotalMoneyServices totalMoneyServices = new TotalMoneyServices();
        name_cl.setCellValueFactory(new PropertyValueFactory<>("name"));
        phone_cl.setCellValueFactory(new PropertyValueFactory<>("phone"));
        idbooking_cl.setCellValueFactory(new PropertyValueFactory<>("idbookings"));
        idseat_cl.setCellValueFactory(new PropertyValueFactory<>("iddetail_tickets"));
        price_cl.setCellValueFactory(new PropertyValueFactory<>("price"));
        dateStart_cl.setCellValueFactory(new PropertyValueFactory<>("date_start"));
        timeStart_cl.setCellValueFactory(new PropertyValueFactory<>("time_start"));
        carName_cl.setCellValueFactory(new PropertyValueFactory<>("code_car"));
        table_view.setItems((totalMoneyServices.observableList(user)));
    }

    public users getUser(users u){
        user.setIdusers(u.getIdusers());
        user.setName(u.getName());
        user.setAddress(u.getAddress());
        user.setSex(u.getSex());
        user.setEmail(u.getEmail());
        user.setBirthday(u.getBirthday());
        user.setPhone(u.getPhone());
        user.setRole(u.getRole());
        lblName.setText( u.getName());
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
            lblName.setText(u.getName());
            lblID.setText(String.valueOf("ID: " + u.getIdusers()));
            setTable_view();

        }else if(user.getRole() == 2){
            managerUser_button.setDisable(true);
            managerUser_button.setStyle("-fx-opacity: 0");
            managerEmploy_button.setDisable(true);
            managerEmploy_button.setStyle("-fx-opacity: 0");
            lblName.setText(u.getName());
            lblID.setText(String.valueOf("ID: " + u.getIdusers()));
            setTable_view();
        }else{
            lblName.setText(u.getName());
            lblID.setText(String.valueOf("ID: " + u.getIdusers()));;}
            setTable_view();
        return user;
    }
    //Nút đăng xuất
    public void Logout(ActionEvent event) throws IOException {
        fxmlLoader = FXMLLoader.load(getClass().getResource("login.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader);
        stage.setScene(scene);
        stage.show();
    }


    // Chuyển đổi screen ( chuyển đổi giữa các file fxml )
    private Stage stage;
    private Scene scene;
    private Parent fxmlLoader;
    // Chuyển sang create_tickets.fxml
    public void switchToCreate_tickets(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("create_tickets.fxml"));
        Parent userViewParent = loader.load();
        Scene scene = new Scene(userViewParent);
        stage.setScene(scene);
        createticketsController controller = loader.getController();
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
    // viet code truy xuat sql tai day
    @FXML
    private TableView<totalMoney> table_view;
    @FXML
    private TableColumn<totalMoney, String> name_cl;

    @FXML
    private TableColumn<totalMoney, String> phone_cl;

    @FXML
    private TableColumn<totalMoney, Integer> price_cl;

    @FXML
    private TableColumn<totalMoney, String> timeStart_cl;

    @FXML
    private TableColumn<totalMoney, String> carName_cl;

    @FXML
    private TableColumn<totalMoney, String> dateStart_cl;

    @FXML
    private TableColumn<totalMoney, Integer> idbooking_cl;

    @FXML
    private TableColumn<totalMoney, String> idseat_cl;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}
