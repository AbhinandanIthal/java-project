<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<body>
<h2>Add Reservation</h2>

<form action="add" method="post">
    ID: <input type="text" name="id"><br>
    Name: <input type="text" name="name" required><br>
    Room: <input type="text" name="room"><br>
    CheckIn: <input type="date" name="checkin"><br>
    CheckOut: <input type="date" name="checkout"><br>
    Amount: <input type="number" name="amount" min="0" step="0.01" required><br>

    <input type="submit" value="Add">
    <h2>Reservation Menu</h2>

<a href="report">View Report</a>
</form>

</body>
</html>