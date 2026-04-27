package com.servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.*;
import javax.servlet.http.*;

import com.dao.ReservationDAO;
import com.model.Reservation;

public class UpdateReservationServlet extends HttpServlet {

    ReservationDAO dao = new ReservationDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Reservation r = new Reservation();

        r.setReservationID(Integer.parseInt(request.getParameter("id")));
        r.setCustomerName(request.getParameter("name"));
        r.setRoomNumber(request.getParameter("room"));
        r.setCheckIn(Date.valueOf(request.getParameter("checkin")));
        r.setCheckOut(Date.valueOf(request.getParameter("checkout")));
        r.setTotalAmount(Double.parseDouble(request.getParameter("amount")));

        try {
            dao.updateReservation(r);
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect("display");
    }
}