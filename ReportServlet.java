package com.servlet;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import com.dao.ReservationDAO;
import com.model.Reservation;


public class ReportServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    ReservationDAO dao = new ReservationDAO();
    // ✅ DECLARED HERE

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String fromStr = request.getParameter("from");
        String toStr = request.getParameter("to");

        List<Reservation> list;

        if (fromStr != null && toStr != null && !fromStr.isEmpty() && !toStr.isEmpty()) {

            Date fromDate = Date.valueOf(fromStr);
            Date toDate = Date.valueOf(toStr);

            list = dao.getReservationsByDate(fromDate, toDate);  // ✅ filtered

        } else {

            list = dao.selectAll();  // ✅ all records

        }

        request.setAttribute("list", list);
        request.getRequestDispatcher("/reportresult.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response); // reuse logic
    }
}