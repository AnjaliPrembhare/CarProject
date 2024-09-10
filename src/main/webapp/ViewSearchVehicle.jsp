<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="org.CarGarage.Service.*,java.util.*,org.CarGarage.Model.*,java.sql.*" %>
   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

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
<%!private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	List<Object[]> list;
	
	%>
<% 				  
                    try {
                    int count=0;
					String str = request.getParameter("p");
					Class.forName("com.mysql.cj.jdbc.Driver");
					conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cargarage", "root", "Root");
					list=new ArrayList<Object[]>();
					stmt=conn.prepareStatement("select v.vname,v.model,v.noplate,c.cname,c.email,c.contact,v.vid from customer c inner join vehicle v on c.cid=v.cid where v.noplate like '%" + str + "%'");
					rs=stmt.executeQuery();
					out.println("<table table1>");
					out.println("<thead>");
					out.println("<th scope='col'>Id</th>");
				      out.println("<th scope='col' class='th1'>Vehicle Name</th>");
				      out.println("<th scope='col' class='th1'>Model</th>");
				     out.println("<th scope='col'>Number Plate</th>");
				     out.println("<th scope='col'>Customer Name</th>");
				      out.println("<th scope='col'>Customer email</th>");
				      out.println("<th scope='col'>Customer contact</th>");
				      out.println("<th scope='col'>Delete</th>");
				     out.println("<th scope='col'>Update</th>");
				     out.println("</thead>");
					  while(rs.next()) {
					 out.println(" <tbody class='bg-info'>");
						out.println("<tr>");
						out.println("<td>" + (++count) + "</td>");
						out.println("<td>"+rs.getString(1)+"</td>");
						out.println("<td>"+rs.getString(2)+"</td>");
						out.println("<td>"+rs.getString(3)+"</td>");
						out.println("<td>"+rs.getString(4)+"</td>");
						out.println("<td>"+rs.getString(5)+"</td>");
						out.println("<td>"+rs.getString(6)+"</td>");
						out.println("<td><a href='delV?vid=" + rs.getInt(7)+ "'><ion-icon name='trash-outline' class='icon1'></ion-icon></a></td>");
						out.println("<td><a href='updateV?id=" + rs.getString(6) + "&vname=" + rs.getString(1) + "&model=" + rs.getString(2) + "&noplate=" + rs.getString(3) + "'><ion-icon name='arrow-up-circle-outline' class='icon1'></ion-icon></a></td>");
						out.println("</tr>");
						out.println("</tbody>");
					}
					out.println("</table>");
				}catch(Exception ex) {
					System.out.println("Error in is"+ex);
				}%>
</body>
</html>