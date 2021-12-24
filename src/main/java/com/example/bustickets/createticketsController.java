package com.example.bustickets;

import com.example.bustickets.config.JdbcUtils;
import com.example.bustickets.model.employees;
import com.example.bustickets.model.cars;
import com.example.bustickets.model.tickets;
import com.example.bustickets.services.createticketsServices;
import com.example.bustickets.services.employeeServices;
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
import com.example.bustickets.services.carServices;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class createticketsController implements Initializable {
    // Chuyển đổi screen ( chuyển đổi giữa các file fxml )
    private Stage stage;
    private Scene scene;
    private Parent fxmlLoader;
    // Chuyển sang manager_ticket.fxml
    public void switchToManager_tickets(ActionEvent event) throws IOException {
        fxmlLoader = FXMLLoader.load(getClass().getResource("manager_tickets.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader);
        stage.setScene(scene);
        stage.show();
    }
    // Chuyển sang bookings_tickets.fxml
    public void switchToBookings_tickets(ActionEvent event) throws IOException {
        fxmlLoader = FXMLLoader.load(getClass().getResource("bookings_tickets.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader);
        stage.setScene(scene);
        stage.show();
    }
    // Chuyển sang manage_employees.fxml
    public void switchToManage_employees(ActionEvent event) throws IOException {
        fxmlLoader = FXMLLoader.load(getClass().getResource("manage_employees.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader);
        stage.setScene(scene);
        stage.show();
    }
    // Chuyển sang manage_users.fxml
    public void switchToManage_users(ActionEvent event) throws IOException {
        fxmlLoader = FXMLLoader.load(getClass().getResource("manage_users.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader);
        stage.setScene(scene);
        stage.show();
    }
    // viet code truy xuat sql tai day

    @FXML
    private  ComboBox<cars> carsComboBox;
    @FXML
    private ComboBox<employees> employeesComboBox;
    @FXML
    private TextField txt_giave;
    @FXML
    private DatePicker txt_ngaykhoihanh;
    @FXML
    private TextField txt_thoigiankhoihanh;
    @FXML
    private TextField txt_diemdi;
    @FXML
    private TextField txt_diemden;
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
    }


    public void addTickets(ActionEvent event){
        // alert complete
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("WARNING");
        alert.setContentText("Are you ok ?");
        alert.setHeaderText("This confirmation tickets");
        Optional<ButtonType> result = alert.showAndWait();
        //
        if (result.get() == ButtonType.OK){
            tickets t = new tickets(this.txt_diemdi.getText(), this.txt_diemden.getText(),this.carsComboBox.getSelectionModel().getSelectedItem().getNumber_seat(), this.txt_ngaykhoihanh.getEditor().getText() ,this.txt_giave.getText(),this.employeesComboBox.getSelectionModel().getSelectedItem().getIdemployees(),this.txt_thoigiankhoihanh.getText(),this.carsComboBox.getSelectionModel().getSelectedItem().getIdcars());
            createticketsServices ctS = new createticketsServices();
            try {
                // add data to mysql
                ctS.addSetOfTickets(t);
                // reset fxml
                fxmlLoader = FXMLLoader.load(getClass().getResource("create_tickets.fxml"));
                stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(fxmlLoader);
                stage.setScene(scene);
                stage.show();

            } catch (SQLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("SUCCESSFUL");

        }
        else{
            System.out.println(("ERROR"));
        }

    }
}
