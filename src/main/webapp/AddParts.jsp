<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>
<%@include file="MainDashBoard.jsp" %>
<link href="CSS/updatePart.css" rel="stylesheet"/>
</head>
<style>

</style>
<body>
<form class="Form" action='PartController' method="post">
    <div class="col-md-9">
        <h3>Add Parts Of Vehicle</h3><br>
        <label for="Name">Part Name</label><br>
        <input type="text" name="name" value="" placeholder="plug"/><br><br>
        <label for="Price">Price</label><br>
        <input type="text" name="price" value="" placeholder="300"/><br><br>
        <input type="submit" name="s" value="Submit" class="submit"/><br><br>
   </div>
</form>
</body>
</html>