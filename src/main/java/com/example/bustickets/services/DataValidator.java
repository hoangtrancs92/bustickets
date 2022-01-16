package com.example.bustickets.services;
import com.example.bustickets.config.JdbcUtils;
import com.example.bustickets.model.users;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataValidator {
    public static boolean checkEmail(String email){
        boolean kq = true;

            Pattern patten = Pattern.compile("\\w+@\\w+\\.\\w+");
            Matcher matcher = patten.matcher(email);

            if (!matcher.find()){
                kq = false;
            }

        return kq;
    }
    public static boolean checkSDT(String field){
        boolean kq = true;

        Pattern patten = Pattern.compile("^0\\d{9}$");
        Matcher matcher = patten.matcher(field);

        if (!matcher.find()){

            kq = false;
        }

        return kq;
    }
//    public static boolean checkDuplicationEmail(String field) throws SQLException {
//        boolean kq = true;
//        Connection conn = JdbcUtils.getCnn();
//        Statement stm = conn.createStatement();
//        ResultSet rs = stm.executeQuery("SELECT email FROM bustickets_db.users where users.email is not null;");
//        while (rs.next()) {
//            if(rs.getString("email").equals(field)){
//                kq = false;
//                return kq;
//            }
//        }
//        stm.close();
//        return kq;
//    }
}
