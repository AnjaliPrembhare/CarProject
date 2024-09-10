<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="MainDashBoard.jsp" %>
</head>
<style>
.input{
width:300px;
height:50px;
border: 5px solid #1A5276;
border-radius: 10px;

}
.inputbtn{
width:300px;
height:50px;
border: 5px solid #1A5276;
border-radius: 10px;
background-image: linear-gradient(19deg, #21D4FD 0%, #B721FF 100%);
}
.Form{
  background-image: linear-gradient(19deg, #21D4FD 0%, #B721FF 100%);
  width:430px;
  height:60vh;
  padding:60px;
  margin-left:100px;
}
h4{
margin-bottom:20px;
}

</style>
<body>
<form class="Form" action="" method="">
<h4>Add Bill</h4>
<input type="text" name="amount" value="" class="input" placeholder="300"/><br><br>
<input type="text" name="Date" value=""class="input" placeholder="20-02-2024"/><br><br>
<input type="text" name="vname" value=""class="input" placeholder="thar"/><br><br>
<input type="submit" name="s" value="submit"class="inputbtn"/><br><br>
</form>
</body>
</html>