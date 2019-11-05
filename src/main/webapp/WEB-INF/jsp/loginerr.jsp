<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Form</title>
    <link href="https://fonts.googleapis.com/css?family=Lato|Raleway:700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/css/main.css">
    <link rel="stylesheet" type="text/css" href="/style.css">
</head>
<body>
<jsp:include page="nav.jsp" />
<br>
<h1 align="center">LOGIN</h1>
<h2 align="center" class="err">Bad Credentials!  </h2>
<h3 align="center"> Please try again with valid username and password. </h3>
 <form action="/login" method="POST" >
  <table align ="center">
   <tr>
    <td>User Name: </td>
    <td>
     <input type="text" name="username">
    </td>
   </tr>
   <tr>
    <td>Password: </td>
    <td>
     <input type="password" name="password" />
    </td>
   </tr>
   <tr>
    <td>
     <input name="submit" type="submit" value="submit" />
    </td>
   </tr>
  </table>
  
 </form>
 
 <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
 
 
</body>
</html>