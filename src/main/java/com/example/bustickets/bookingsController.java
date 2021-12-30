package com.example.bustickets;
import com.example.bustickets.model.tickets;
import com.example.bustickets.services.bookingsServices;
import com.example.bustickets.services.detailticketsServices;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class bookingsController implements Initializable {
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
    // Chuyển sang Create_tickets.fxml
    public void switchToCreate_tickets(ActionEvent event) throws IOException {
        fxmlLoader = FXMLLoader.load(getClass().getResource("create_tickets.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader);
        stage.setScene(scene);
        stage.show();
    }
    // viet code truy xuat sql tai day

    @FXML
    private GridPane grid;

    @FXML
    private GridPane seat_grid;

    @FXML
    private ScrollPane scroll;

    private Mylistener mylistener;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        int column = -1;
        int row = 1;


        bookingsServices bkS = new bookingsServices();
        detailticketsServices dtK = new detailticketsServices();
        // Xu ly su kien click ve
        mylistener = new Mylistener() {
            @Override
            public void onClickListener(tickets ticket) throws IOException {
                int column_items_2 = -1;
                int row_items_2 = 1;
                int count =0;
                try {
                            if(ticket.getIdtickets() == dtK.ShowdetailTickets(ticket).get(0).getId_tickets())
                            {
                                for (int i =0; i < dtK.ShowdetailTickets(ticket).size();i++){
                                FXMLLoader fxmlLoader = new FXMLLoader();
                                fxmlLoader.setLocation(getClass().getResource("items_2.fxml"));
                                AnchorPane anchorPane1 = fxmlLoader.load();
                                items2Controller Items2Controller = fxmlLoader.getController();
                                Items2Controller.setData(dtK.ShowdetailTickets(ticket).get(i));
                                column_items_2++;
                                if (column_items_2 == 4) {
                                    column_items_2 = 0;
                                    row_items_2++;
                                }

                                seat_grid.add(anchorPane1, column_items_2, row_items_2); //(child,column,row)
                                //set grid width
                                seat_grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                                seat_grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                                seat_grid.setMaxWidth(Region.USE_PREF_SIZE);

                                //set grid height
                                seat_grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                                seat_grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                                seat_grid.setMaxHeight(Region.USE_PREF_SIZE);

                                GridPane.setMargin(anchorPane1, new Insets(20));
                                seat_grid.setPadding(new Insets(40));
                            }
                        }

                } catch (SQLException e) {
                    e.printStackTrace();
                }



            }
        };


        try {
            for (int i = 0;i< bkS.detailTickets().size();i++){
                Date date = new Date();
                String dateS = bkS.detailTickets().get(i).getDate_start();
                Date date_start = new SimpleDateFormat("dd/MM/yyyy").parse(dateS);
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("items.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                itemsController itemController = fxmlLoader.getController();
                if (date_start.after(date)) {
                    itemController.setData(bkS.detailTickets().get(i),mylistener);
                    column++;
                    if (column == 3) {
                        column = 0;
                        row++;
                    }

                    grid.add(anchorPane, column, row); //(child,column,row)
                    //set grid width
                    grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                    grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                    grid.setMaxWidth(Region.USE_PREF_SIZE);

                    //set grid height
                    grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                    grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                    grid.setMaxHeight(Region.USE_PREF_SIZE);

                    GridPane.setMargin(anchorPane, new Insets(20));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }













}
