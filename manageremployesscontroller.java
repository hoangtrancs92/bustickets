package com.example.bustickets;

import com.example.bustickets.model.tickets;
import com.example.bustickets.services.managerticketsServices;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class manageremployesscontroller implements Initializable {
    // Chuyển đổi screen ( chuyển đổi giữa các file fxml )
    private Stage stage;
    private Scene scene;
    private Parent fxmlLoader;
    // Chuyển sang create_employees.fxml
    public void switchToCreate_tickets(@NotNull ActionEvent event) throws IOException {
        fxmlLoader = FXMLLoader.load(getClass().getResource("create_tickets.fxml"));
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
    // Chuyển sang manager_ticket.fxml
    public void switchToManager_tickets(ActionEvent event) throws IOException {
        fxmlLoader = FXMLLoader.load(getClass().getResource("manager_tickets.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader);
        stage.setScene(scene);
        stage.show();
    }
    // viet code truy xuat sql tai day
    @FXML
    private TableView<tickets> tableView;
    @FXML
    private TableColumn<tickets, String> col_idemployees;
    @FXML
    TableColumn<tickets, Integer> col_name;
    @FXML
    TableColumn<tickets,String> col_email;
    @FXML
    TableColumn<tickets,String> col_password;
    @FXML
    TableColumn<tickets,String> col_stores_id;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        managerticketsServices mng = new managerticketsServices();
        col_idemployees.setCellValueFactory(new PropertyValueFactory<>("idemployees"));
        col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        col_email.setCellValueFactory(new PropertyValueFactory<>("email"));
        col_password.setCellValueFactory(new PropertyValueFactory<>("password"));
        col_stores_id.setCellValueFactory(new PropertyValueFactory<>("stores_id"));
        tableView.setItems((mng.observableList()));
    }
}

