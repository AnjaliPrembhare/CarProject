<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
<style>
*{
padding:0;
margin:0;
box-sizing:border-box;
}
.container-fluid{
border: 5px solid black;
width:100%;
}

img{
left:0;
width:100px;
margin-left:10px;
}
h1{
margin-top:20px;
}
.logo{
width:120px;
}
.heading{
width:70%;
}
.nav{
width:20%;
}
.nav ul li a{
text-decoration:none;
}
.nav ul li{
padding-left:20px;
display:inline;
font-size:20px;
text-style:none;
}
li a img{
width:100%;
}

::selection{
  background: rgba(26,188,156,0.3);
}
.login{
width:100%;
border: 2px solid black;
min-height: 100vh;
background-image: url(img/car1.jpg);
background-position: center;
background-size: cover;
padding: 10px 10%;
overflow: hidden;
position: relative;
color:white;
margin:1px;
padding-left:800px;
}
.container{
  max-width: 440px;
  padding: 0 20px;
  margin: 170px auto;
}
.wrapper{
  width: 100%;
  background: #fff;
  border-radius: 5px;
}
.wrapper .title{
  height: 90px;
  background: #16a085;
  border-radius: 5px 5px 0 0;
  color: #fff;
  font-size: 30px;
  font-weight: 600;
  display: flex;
  align-items: center;
  justify-content: center;
}
.wrapper form{
  padding: 30px 25px 25px 25px;
}
.wrapper form .row{
  height: 45px;
  margin-bottom: 15px;
  position: relative;
}
.wrapper form .row input{
  height: 100%;
  width: 100%;
  outline: none;
  padding-left: 60px;
  border-radius: 5px;
  border: 1px solid lightgrey;
  font-size: 16px;
  transition: all 0.3s ease;
}
form .row input:focus{
  border-color: #16a085;
  box-shadow: inset 0px 0px 2px 2px rgba(26,188,156,0.25);
}
form .row input::placeholder{
  color: #999;
}
.wrapper form .row i{
  position: absolute;
  width: 47px;
  height: 100%;
  color: #fff;
  font-size: 18px;
  background: #16a085;
  border: 1px solid #16a085;
  border-radius: 5px 0 0 5px;
  display: flex;
  align-items: center;
  justify-content: center;
}
.wrapper form .pass{
  margin: -8px 0 20px 0;
}
.wrapper form .pass a{
  color: #16a085;
  font-size: 17px;
  text-decoration: none;
}
.wrapper form .pass a:hover{
  text-decoration: underline;
}
.wrapper form .button input{
  color: #fff;
  font-size: 20px;
  font-weight: 500;
  padding-left: 0px;
  background: #16a085;
  border: 1px solid #16a085;
  cursor: pointer;
}
form .button input:hover{
  background: #12876f;
}
.wrapper form .signup-link{
  text-align: center;
  margin-top: 20px;
  font-size: 17px;
}
.wrapper form .signup-link a{
  color: #16a085;
  text-decoration: none;
}
form .signup-link a:hover{
  text-decoration: underline;
}
@media (min-width: 368px) and (max-width: 1024px) {
    .logo, .heading, .nav {
        width: 30%;
    }
    .nav ul {
        padding-left: 0;
        text-align: center;
    }
    .nav ul li {
        display: block;
        padding: 10px 0;
    }
    .content1, .content2 {
        width: 100%;
        padding-left: 0;
        text-align: center;
    }
    .content1 img, .content2 img {
        margin-left: auto;
        margin-right: auto;
    }
    .admin, .user {
        width: 100%;
        padding: 10px;
    }
}

</style>
<body>
<div class="container-fluid">
<div class="row header">
<div class="col-md-4 logo">
<img alt="" src="<%="img/garageimg-removebg-preview.png"%>">
</div>
<div class="col-md-4 heading">
<h1>Garage</h1>
</div>
<div class="col-md-4 nav">
<nav class="navbar navbar-expand-lg">
<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
<span class="navbar-toggler-icon"></span>
</button>
<div class="collapse navbar-collapse" id="navbarSupportedContent">
<ul class="navbar-nav me-auto mb-2 mb-lg-0">
<li class="nav-item">
<a class="nav-link active" aria-current="page" href="Dashboard.jsp"><b>Home</b></a>
</li>
<li class="nav-item">
<a class="nav-link active" href="#"><b>About</b></a>
</li>
<li class="nav-item">
<a class="nav-link active" href="#"><b>Contact</b></a>
</li>
</ul>
</div>
</nav>
</div>
</div>
<div class="login">
<div class="container">
<div class="wrapper">
<div class="title"><span>Admin Login Form</span></div>
<form name="frm" action="login" method="POST">
<div class="row">
<i class="fas fa-user"><ion-icon name="person-outline"></ion-icon></i>
<input type="text" name=user placeholder="username" required>
</div>
<div class="row">
<i class="fas fa-lock"><ion-icon name="lock-closed-outline"></ion-icon></i>
<input type="password" name=pass placeholder="Password" required>
</div>
<!-- <div class="pass"><a href="#">Forgot password?</a></div>  -->
<div class="row button">
<input type="submit" value="Login">
</div>
 <!-- <div class="signup-link">Not a member? <a href="#">Signup now</a></div> -->
</form>
</div>
</div>
</div>
<script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
<script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
</body>
</html>
