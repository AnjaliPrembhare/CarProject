<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="CSS/AddCustomer.css" rel="stylesheet"/>
</head>
<link href="CSS/AddCustomer.css" rel="stylesheet"/>
<%@include file="MainDashBoard.jsp" %>
<style>
.Form {
    background: white;
    width: 360px;
    height: 380px;
    padding-left: 40px;
    margin-left:20px;
    padding-top:10px;
}
</style>
<body>
<form class="Form" action="MechanicController" method="POST">
    <div class="col-md-9 login">
        <h3>Add Employee Details</h3><br>
        <label for="Name">Employee Name</label><br>
        <input type="text" name="name" value="" placeholder="ram"/><br><br>
        <label for="Email">Specialization</label><br>
        <input type="text" name="Specialization" value="" placeholder="oil change"/><br><br>
        <label for="contact">Experience</label><br>
        <input type="text" name="Experience" value="" placeholder="3yrs"/><br><br>
        <input type="submit" name="s" value="Submit" class="submit"/><br><br>
</form>
</body>
</html>
