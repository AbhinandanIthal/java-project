<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<body>

<h2>Update Reservation</h2>

<form action="update" method="post">
    Reservation ID: <input type="text" name="id"><br>
    New Name: <input type="text" name="name"><br>
    New Room: <input type="text" name="room"><br>
    New CheckIn: <input type="date" name="checkin"><br>
    New CheckOut: <input type="date" name="checkout"><br>
    New Amount: <input type="text" name="amount"><br>

    <input type="submit" value="Update">
</form>

</body>
</html>