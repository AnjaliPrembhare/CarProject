<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="MainDashBoard.jsp" %>
<link href="CSS/AddCustomer.css" rel="stylesheet"/>
</head>
<style>
.Form {
    background: white;
    width: 360px;
    height: 580px;
    padding-left: 40px;
    margin-left:20px;
}
h4{
	margin-top:20px;
}
</style>
<body>
<form class="Form" action="AllocateServiceController" method="post">
<h4>Add Service here</h4>
<lable for="">Date</lable><br>
<input type="date" name="date" value="" class="input" placeholder="20-04-2024"/><br><br>
<lable for="">Charges</lable><br>
<input type="text" name="charges" value=""class="input" placeholder="200"/><br><br>
<lable for="">Distance</lable><br>
<input type="text" name="distance" value=""class="input" placeholder="200KM"/><br><br>
<lable for="">Vehicle Name</lable><br>
<input type="text" name="noplate" value=""class="input" placeholder="MH-2020"/><br><br>
<lable for="">Part Name</lable><br>
<input type="text" name="pname" value=""class="input" placeholder="plug"/><br><br>
<lable for="">Mechanic Name</lable><br>
<input type="text" name="mname" value=""class="input" placeholder="ram"/><br><br>
<input type="submit" name="s" value="submit"class="submit"/><br><br>
</form>
</body>
</html>