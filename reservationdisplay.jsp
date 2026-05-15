<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.model.Reservation" %>

<!DOCTYPE html>
<html>
<body>

<h2>Reservation List</h2>

<table border="1">
<tr>
    <th>ID</th>
    <th>Name</th>
    <th>Room</th>
    <th>CheckIn</th>
    <th>CheckOut</th>
    <th>Amount</th>
</tr>

<%
Object obj = request.getAttribute("list");

if(obj instanceof List){
    List<Reservation> list = (List<Reservation>) obj;
    for(Reservation r : list){
%>

<tr>
    <td><%= r.getReservationID() %></td>
    <td><%= r.getCustomerName() %></td>
    <td><%= r.getRoomNumber() %></td>
    <td><%= r.getCheckIn() %></td>
    <td><%= r.getCheckOut() %></td>
    <td><%= r.getTotalAmount() %></td>
</tr>

<%
    }
}
%>

</table>

</body>
</html>