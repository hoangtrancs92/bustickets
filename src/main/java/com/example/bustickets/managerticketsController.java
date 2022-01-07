package com.example.bustickets;
import com.example.bustickets.model.tickets;
import com.example.bustickets.model.users;
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
import com.example.bustickets.services.managerticketsServices;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class managerticketsController implements Initializable{

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
    private TableView<tickets> tableView;
    @FXML
    private TableColumn<tickets, String> col_masove;
    @FXML
    TableColumn<tickets, Integer> col_soluong;
    @FXML
    TableColumn<tickets,String> col_nhanvien;
    @FXML
    TableColumn<tickets,String> col_diemxuatphat;
    @FXML
    TableColumn<tickets,String> col_diemketthuc;
    @FXML
    TableColumn<tickets,String> col_ngayxuatphat;
    @FXML
    TableColumn<tickets,String> col_gioxuatphat;
    @FXML
    TableColumn<tickets,String> col_biensoxe;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        managerticketsServices mng = new managerticketsServices();
        col_masove.setCellValueFactory(new PropertyValueFactory<>("code_seat"));
        col_soluong.setCellValueFactory(new PropertyValueFactory<>("quanlity"));
        col_nhanvien.setCellValueFactory(new PropertyValueFactory<>("name_employee"));
        col_diemxuatphat.setCellValueFactory(new PropertyValueFactory<>("location_start"));
        col_diemketthuc.setCellValueFactory(new PropertyValueFactory<>("location_end"));
        col_ngayxuatphat.setCellValueFactory(new PropertyValueFactory<>("date_start"));
        col_gioxuatphat.setCellValueFactory(new PropertyValueFactory<>("time_start"));
        col_biensoxe.setCellValueFactory(new PropertyValueFactory<>("code_car"));
        tableView.setItems((mng.observableList()));
    }
}
