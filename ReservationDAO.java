package com.dao;

import java.sql.*;
import java.util.*;
import java.sql.Date;
import com.model.Reservation;

public class ReservationDAO {

    private String jdbcURL = "jdbc:mysql://localhost:3306/hotel_db";
    private String jdbcUsername = "root";
    private String jdbcPassword = "abhi123---";

    private static final String INSERT_SQL =
        "INSERT INTO Reservations VALUES (?, ?, ?, ?, ?, ?)";

    private static final String SELECT_ALL =
        "SELECT * FROM Reservations";

    protected Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    // ADD
    public void insertReservation(Reservation r) throws SQLException {
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(INSERT_SQL)) {

            ps.setInt(1, r.getReservationID());
            ps.setString(2, r.getCustomerName());
            ps.setString(3, r.getRoomNumber());
            ps.setDate(4, r.getCheckIn());
            ps.setDate(5, r.getCheckOut());
            ps.setDouble(6, r.getTotalAmount());

            ps.executeUpdate();
        }
    }
    public void updateReservation(Reservation r) throws Exception {
        String sql = "UPDATE Reservations SET CustomerName=?, RoomNumber=?, CheckIn=?, CheckOut=?, TotalAmount=? WHERE ReservationID=?";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, r.getCustomerName());
            ps.setString(2, r.getRoomNumber());
            ps.setDate(3, r.getCheckIn());
            ps.setDate(4, r.getCheckOut());
            ps.setDouble(5, r.getTotalAmount());
            ps.setInt(6, r.getReservationID());

            ps.executeUpdate();
        }
    }
    
    public void deleteReservation(int id) throws Exception {
        String sql = "DELETE FROM Reservations WHERE ReservationID=?";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
    
    public List<Reservation> getReservationsByDate(Date start, Date end) {

        List<Reservation> list = new ArrayList<>();

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(
                 "SELECT * FROM Reservations WHERE CheckIn >= ? AND CheckOut <= ?")) {

            // ✅ VERY IMPORTANT
            ps.setDate(1, start);
            ps.setDate(2, end);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Reservation r = new Reservation();
                r.setReservationID(rs.getInt("ReservationID"));
                r.setCustomerName(rs.getString("CustomerName"));
                r.setRoomNumber(rs.getString("RoomNumber"));
                r.setCheckIn(rs.getDate("CheckIn"));
                r.setCheckOut(rs.getDate("CheckOut"));
                r.setTotalAmount(rs.getDouble("TotalAmount"));

                list.add(r);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // DISPLAY
    public List<Reservation> selectAll() {
        List<Reservation> list = new ArrayList<>();

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM Reservations")) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Reservation r = new Reservation();
                r.setReservationID(rs.getInt("ReservationID"));
                r.setCustomerName(rs.getString("CustomerName"));
                r.setRoomNumber(rs.getString("RoomNumber"));
                r.setCheckIn(rs.getDate("CheckIn"));
                r.setCheckOut(rs.getDate("CheckOut"));
                r.setTotalAmount(rs.getDouble("TotalAmount"));

                list.add(r);
            }

            System.out.println("Records fetched: " + list.size());

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    
    }
}