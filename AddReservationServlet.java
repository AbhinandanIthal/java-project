package com.servlet;

import java.io.IOException;
import java.sql.Date;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import com.dao.ReservationDAO;
import com.model.Reservation;


public class AddReservationServlet extends HttpServlet {
	double amount;
    private static final long serialVersionUID = 1L;
    private ReservationDAO dao = new ReservationDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Retrieve parameters
        String idStr = request.getParameter("id");
        String name = request.getParameter("name");
        String room = request.getParameter("room");
        String checkinStr = request.getParameter("checkin");
        String checkoutStr = request.getParameter("checkout");
        String amountStr = request.getParameter("amount");

        // Validation
        if (idStr == null || idStr.isEmpty() ||
            name == null || name.isEmpty() ||
            room == null || room.isEmpty() ||
            checkinStr == null || checkinStr.isEmpty() ||
            checkoutStr == null || checkoutStr.isEmpty() ||
            amountStr == null || amountStr.isEmpty()) {

            response.getWriter().println("Error: All fields are required!");
            return;
        }

        try {
            Reservation r = new Reservation();
            r.setReservationID(Integer.parseInt(idStr));
            r.setCustomerName(name);
            r.setRoomNumber(room);
            r.setCheckIn(Date.valueOf(checkinStr));
            r.setCheckOut(Date.valueOf(checkoutStr));
            r.setTotalAmount(Double.parseDouble(amountStr));

            dao.insertReservation(r);
            amount = Double.parseDouble(amountStr);
            if (amount < 0) {
                request.setAttribute("error", "Amount cannot be negative!");
                request.getRequestDispatcher("reservationadd.jsp").forward(request, response);
                return;
            }
            // Single redirect (correct)
            response.sendRedirect("display");

        } catch (NumberFormatException e) {
            response.getWriter().println("Error: Invalid number format for ID or Amount.");
        } catch (IllegalArgumentException e) {
            response.getWriter().println("Error: Invalid date format. Use YYYY-MM-DD.");
        } catch (Exception e) {
            response.getWriter().println("Error: Database error occurred.");
            e.printStackTrace();
        }
    }
}