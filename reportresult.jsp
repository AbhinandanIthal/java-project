<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="java.util.*, com.model.Reservation" %>

<html>
<body>

<h2>Report Result</h2>

<table border="1">
<tr>
<th>ID</th><th>Name</th><th>Room</th><th>CheckIn</th><th>CheckOut</th><th>Amount</th>
</tr>

<%
List<Reservation> list = (List<Reservation>) request.getAttribute("list");

if(list != null && !list.isEmpty()){
    for(Reservation r : list){
%>

<tr>
<td><%=r.getReservationID()%></td>
<td><%=r.getCustomerName()%></td>
<td><%=r.getRoomNumber()%></td>
<td><%=r.getCheckIn()%></td>
<td><%=r.getCheckOut()%></td>
<td><%=r.getTotalAmount()%></td>
</tr>

<%
    }   // end for
} else {
%>

<tr>
<td colspan="6">No records found</td>
</tr>

<%
}   // end if
%>



</table>

</body>
</html>