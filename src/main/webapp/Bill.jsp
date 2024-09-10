<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@page import="org.CarGarage.Service.*,java.util.*,org.CarGarage.Model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link href="CSS/AddCustomer.css" rel="stylesheet"/>
<%@include file="MainDashBoard.jsp" %>
<style>
.Form{
height:40vh;
}
</style>
<body>
<form class="Form" action="addbill" method="POST">
    <div class="col-md-9 login">
        <h3>Generate Bill Details</h3><br>
        <label for="date">Date</label><br>
        <input type="Date" name="date" value="" placeholder="22-09-2024"/><br><br>
        <label for="vid">Enter Vid</label><br>
        <input type="text" name="vid" value="" placeholder="1"/><br><br>
        <input type="submit" name="s" value="Submit" class="submit"/><br><br>
</form>
</main>
</div>
</div>
</div>
</body>
</html>