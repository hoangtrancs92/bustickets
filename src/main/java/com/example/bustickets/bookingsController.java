package com.example.bustickets;
import com.example.bustickets.model.detail_tickets;
import com.example.bustickets.model.tickets;
import com.example.bustickets.model.users;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.ResourceBundle;

public class bookingsController implements Initializable {

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
    @FXML
    private GridPane grid;
    @FXML
    private GridPane seat_grid;
    @FXML
    private ScrollPane scroll;
    @FXML
    private Button muave_button;


    private Mylistener mylistener;
    private MyListenner_bookingsSeats myListenner_bookingsSeats;

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
    // Chuyển đổi screen ( chuyển đổi giữa các file fxml )
    private Stage stage;
    private Scene scene;
    private Parent fxmlLoader;

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
    // viet code truy xuat sql tai day

    @FXML
    void themchongoi_button(ActionEvent event) throws IOException {

        detail_tickets dt = new detail_tickets();
//        ArrayList<String> cloneArraylist;
//        cloneArraylist = myListenner_bookingsSeats.onClickListener_bookingsSeats(dt);
        System.out.println("enter");
//        for(int i =1;i <=cloneArraylist.size()-1;i++){
//            System.out.println(cloneArraylist.get(i));
//        }
        System.out.println("S ="+arrayList);
    }
    ///   ********* /////
    ArrayList<String> arrayList = new ArrayList<>();
    ///   ********* /////
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
                muave_button.setStyle("-fx-opacity: 1");
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
                                Items2Controller.setData(dtK.ShowdetailTickets(ticket).get(i),myListenner_bookingsSeats);
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
        // Xu ly xu kien ve


        //xu ly them cho ngoi vao sql


        myListenner_bookingsSeats = new MyListenner_bookingsSeats() {
            @Override
            public ArrayList<String> onClickListener_bookingsSeats(detail_tickets detailTickets) throws IOException {

                if(arrayList.size()==0){
                    int idlocve =detailTickets.getId_tickets();
                    arrayList.add(String.valueOf(idlocve));
                }
                arrayList.add(detailTickets.getIddetail_tickets()) ;
                if(arrayList.size()!=0 && Integer.parseInt(arrayList.get(0)) != detailTickets.getId_tickets()){
                    System.out.println("da thay doi loc ve");
                    arrayList.removeAll(arrayList);
                    System.out.println("sau khi da xoa het loc cu");
                    if(arrayList.size()==0){
                        arrayList.add(String.valueOf(detailTickets.getId_tickets()));
                        arrayList.add(detailTickets.getIddetail_tickets());
                    }
                }
                for (int i =1; i < arrayList.size();i++){
                    int occurrences = Collections.frequency(arrayList, arrayList.get(i));
                    System.out.println("do dai arraylist hien tai: "+arrayList.size());
                    if(occurrences%2==0){
                        arrayList.remove(i);
                        for (int j =0; j<=arrayList.size();j++){
                            if(detailTickets.getIddetail_tickets().equals(arrayList.get(j))==true){
                                arrayList.remove(j);
                                System.out.println("xoa lan 2");
                            }
                        }
                        System.out.println("do dai da xoa het=" + arrayList.size());
                    }
                }
                System.out.println(arrayList);
                return arrayList;
            }
        };

        //Xu ly them cho ngoi vao sql



        // Xuat ra man hinh cac ve con kha dung
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
