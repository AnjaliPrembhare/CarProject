<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link href="CSS/AddCustomer.css" rel="stylesheet"/>
<%@include file="MainDashBoard.jsp" %>

<body>

<form class="Form" action="Vehicle" method="POST">
    <div class="col-md-9">
        <h3>Add Vehicle Details</h3><br>
        <label for="Name">Vehicle Name</label><br>
        <input type="text" name="name" value="" placeholder="thar"/><br><br>
        <label for="text">Vehicle Model</label><br>
        <input type="text" name="model" value=""placeholder="2024"/><br><br>
        <label for="contact">Number Plate</label><br>
        <input type="text" name="noplate" value=""placeholder="MH-2020"/><br><br>
        <label for="text">Customer email</label><br>
        <input type="text" name="email" value=""placeholder="email"/><br><br>
        <input type="submit" name="s" value="Submit" class="submit"/><br><br>
</form>
</body>
</html>