package com.servlet;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import com.dao.ReservationDAO;

public class DeleteReservationServlet extends HttpServlet {

    ReservationDAO dao = new ReservationDAO();
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        try {
            dao.deleteReservation(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect("display");
    }
}