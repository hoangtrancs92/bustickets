package com.example.bustickets.services;

import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataValidator {
    public static boolean checkEmail(TextField field, Label lbl){
        boolean kq = true;

            Pattern patten = Pattern.compile("\\w+@\\w+\\.\\w+"); //VD: bodeptrai@gmail.com
            Matcher matcher = patten.matcher(field.getText());

            if (!matcher.find()){
                lbl.setText("Email không hợp lệ");
                lbl.setTextFill(Color.RED);
                kq = false;
            }

        return kq;
    }
    public static boolean checkSDT(TextField field, Label lbl){
        boolean kq = true;

        Pattern patten = Pattern.compile("^0\\d{9}$"); //VD: bodeptrai@gmail.com
        Matcher matcher = patten.matcher(field.getText());

        if (!matcher.find()){
            lbl.setText("Số điện thoại không hợp lệ!");
            lbl.setTextFill(Color.RED);
            kq = false;
        }

        return kq;
    }
}
