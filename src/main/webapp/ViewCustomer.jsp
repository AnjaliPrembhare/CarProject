<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@page import="org.CarGarage.Service.*,java.util.*,org.CarGarage.Model.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<%@include file="MainDashBoard.jsp" %>
</head>
<%!
CustomerService es=new CustomerServiceImpl();
int count=0;
%>
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
<h1>View Customer</h1>
    <div class="col-md-9 login">
        <table class="table table-bordered table1">
  <thead>
    <tr>
      <th scope="col">Id</th>
      <th scope="col" class="th1">Name</th>
      <th scope="col" class="th1">Email</th>
      <th scope="col">Contact</th>
      <th scope="col">Address</th>
      <th scope="col">Delete</th>
      <th scope="col">Update</th>
    </tr>
    </thead>
  <tbody class="bg-info">
  <% 
  List<CustomerModel> list=es.getAllCustomer();
 
  for(CustomerModel cmodel:list){
	  %>  
	  <tr>
	  <td><%=cmodel.getId()%></td>
	  <td><%=cmodel.getName() %></td>
	  <td><%=cmodel.getEmail()%></td>
	   <td><%=cmodel.getContact()%></td>
	   <td><%=cmodel.getAddress()%></td>
	 <td><a href='del?cid=<%=cmodel.getId()%>'><ion-icon name="trash-outline" class="icon1"></ion-icon></a></td>
      <td><a href='update?cid=<%=cmodel.getId()%>&cname=<%=cmodel.getName()%>&cemail=<%=cmodel.getEmail()%>&ccontact=<%=cmodel.getContact()%>&caddress=<%=cmodel.getAddress()%>'><ion-icon name="arrow-up-circle-outline" class="icon1"></ion-icon></a></td>
	 </tr>
	  <%
  }
	  %>
  </tbody>
</table>
</body>
</html>
   
</form>
</main>
</div>
</div>
</div>
</body>
</html>
