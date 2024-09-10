<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="org.CarGarage.Service.*,java.util.*,org.CarGarage.Model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%@include file="MainDashBoard.jsp" %>
<%!
BillService ss=new BillServiceImpl();
%>
<link href="CSS/ViewData.css" rel="stylesheet"/>
<style>
.Form {
    width: 100%;
    height: 500px;
    margin-left:10px;
   padding:30px;
}
table{
margin-top:30px;
border:2px solid black;
border-collapse:collapse;
width:100%;
padding-left:10px;
}
tr{
 margin-left:10px;
}

thead{
 background:black;
 height:20px;
 font-size:20px;
 color:white;
}
table td{
 border:1px solid black;
 font-size:20px;
 text-align:center;
}
.icon1{
font-size:30px;
padding-left:30px;
color:black;
}
</style>
<body>
<form class="Form" action="cadd" method="POST">
<h1>View Service Details</h1>

<table class="table table-bordered table1">
  <thead>
    <tr>
      <th scope="col">Id</th>
      <th scope="col" class="th1">Date</th>
      <th scope="col" class="th1">Vehicle Name</th>
      <th scope="col" class="th1">Noplate</th>
      <th scope="col" class="th1">Charges</th>
      <th scope="col" class="th1">Part Price</th>
      <th scope="col" class="th1">Total Amount</th>
      <th scope="col">Delete</th>
    </tr>
  </thead>
  <tbody class="bg-info">
  <% 
  List<Object[]> list=ss.getAllInfo();
  int count=0;
  for(Object obj[]:list){
  %>
    <tr>
	  <td><%=++count%></td>
	  <td><%=obj[0]%></td>
      <td><%=obj[1]%></td>
      <td><%=obj[2]%></td>
      <td><%=obj[3]%></td>
      <td><%=obj[4]%></td>
      <td><%=obj[5]%></td>
      <td><a href='deleteb?bid=<%=obj[6]%>'><ion-icon name="trash-outline" class="icon1"></a></td>
      <%
  }
	  %>
  </tbody>
</table>
</body>
</html>