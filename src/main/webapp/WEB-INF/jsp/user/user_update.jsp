<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Password</title>
    <link href="https://fonts.googleapis.com/css?family=Lato|Raleway:700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/css/main.css">
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
 <spring:url value="/user/update" var="saveUR" />
 <form method="post" action="/admin/user/update" >
 

  <table>
  <tr>
     <tr>
    <td>User Name: </td>
    <td>
     <input name="username" />
    </td>
   </tr>
   <tr>
     <tr>
    <td>Password: </td>
    <td>
     <input name="trip_id"  type="password" method="post"/>
    </td>
   </tr>
      <tr>
     <tr>
    <td>New Password: </td>
    <td>
     <input name="charges"  type="password" method="post"/>
    </td>
   </tr>
   <tr>
    <td></td>
    <td>
     <input type="submit" value="save" method="post">
    </td>
   </tr>
  </table>
  
 </form>
 <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
 
</body>
</html>