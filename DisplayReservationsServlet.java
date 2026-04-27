package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;

import com.dao.ReservationDAO;
import com.model.Reservation;

public class DisplayReservationsServlet extends HttpServlet {
	

   
	private static final long serialVersionUID = 1L;
	private ReservationDAO dao = new ReservationDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Reservation> list = dao.selectAll();
        
        request.setAttribute("list", list);
        request.getRequestDispatcher("reservationdisplay.jsp").forward(request, response);
        request.setAttribute("list", list);

        RequestDispatcher rd = request.getRequestDispatcher("reservationdisplay.jsp");
        rd.forward(request, response);
    }
}
