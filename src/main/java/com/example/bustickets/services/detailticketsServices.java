package com.example.bustickets.services;

import com.example.bustickets.config.JdbcUtils;
import com.example.bustickets.model.bookings;
import com.example.bustickets.model.cars;
import com.example.bustickets.model.detail_tickets;
import com.example.bustickets.model.tickets;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class detailticketsServices {


    public  void AddDetailTickets(detail_tickets detailTickets) throws SQLException {
        try {
            Connection cnn = JdbcUtils.getCnn();
            PreparedStatement stm1 = cnn.prepareStatement("INSERT INTO detail_tickets (iddetail_tickets, id_tickets) VALUES (?, ?) ");
            stm1.setString(1,detailTickets.getIddetail_tickets());
            stm1.setInt(2, detailTickets.getId_tickets());
            stm1.executeUpdate();
            stm1.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    // xuat ra man hinh so ghe va thong tin cua tung ve cua tung ve
    public ArrayList<detail_tickets> ShowdetailTickets(tickets ticket) throws SQLException{
        ArrayList<detail_tickets> detail = new ArrayList<>();
        try {
            Connection cnn = JdbcUtils.getCnn();
            PreparedStatement stm = cnn.prepareStatement("select * from detail_tickets where id_tickets like concat('%','"+ticket.getIdtickets()+"','%')");
            ResultSet rs = stm.executeQuery();
//            ResultSet rs = cnn.createStatement().executeQuery("Select detail_tickets.* from detail_tickets ");
            while (rs.next()){
                detail.add(new detail_tickets(rs.getString(1),rs.getInt(2),rs.getInt(3)));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return detail;
    }
//    PreparedStatement stm = cnn.prepareStatement("UPDATE detail_tickets SET id_bookings = '"+booking.getIdbookings()+"' WHERE (iddetail_tickets like concat('%','"+detailTickets.getIddetail_tickets()+"','%'))");

    // Cap nhat idbookings cua bang
    public void updateDetailTickets(detail_tickets detailTickets, int idbooking) throws SQLException {
        Connection cnn = JdbcUtils.getCnn();
        System.out.println("test 2 = "+detailTickets.getIddetail_tickets());

        PreparedStatement stm = cnn.prepareStatement("UPDATE detail_tickets SET id_bookings = '"+idbooking+"' WHERE (iddetail_tickets ='"+detailTickets.getIddetail_tickets()+"')");

        stm.executeUpdate();
        stm.close();
    }
}
