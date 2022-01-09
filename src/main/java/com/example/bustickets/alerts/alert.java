package com.example.bustickets.alerts;

import javafx.scene.control.Alert;

public class alert {
    public void showAlertWithHeaderText(String idbookings) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Thành Công");
        alert.setHeaderText("Đã hoàn thành đặt chỗ");
        alert.setContentText(idbookings);
        alert.showAndWait();
    }
    public void showAlertWithWarningHeaderText() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning ");

        // alert.setHeaderText("Battery Status:");
        alert.setContentText("Vui lòng điền đầy đủ thông tin");

        alert.showAndWait();
    }
    public void showAlertWithWarningHeaderText_Createtickets() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning ");

        // alert.setHeaderText("Battery Status:");
        alert.setContentText("Vui lòng chọn ngày hợp lệ");

        alert.showAndWait();
    }
}
