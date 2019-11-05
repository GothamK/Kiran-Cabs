<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
 "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<title>User Page</title>
    <link href="https://fonts.googleapis.com/css?family=Lato|Raleway:700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/css/main.css">
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
<jsp:include page="nav.jsp" />
 <spring:url value="/admin/user/add" var="addURL" />
 <a href="${addURL }">Add User</a>

 <h1>Users List</h1>
 <table width="100%" border="1">
  <tr>
   <th align="center">User Name</th>
<%--   <th>First Name</th>
   <th>Last Name</th> <td>${user.e_id }</td>
   <th>Phone No</th>
   <th>Email ID</th> --%>
   <th align="center">Employee ID</th>
   <th colspan="2" align ="center">Action</th>
  </tr>
  <c:forEach items="${listUser }" var="user" >
   <tr>
    <td>${user.username }</td>
    <td>${user.e_id }</td>
<%--    <td>${user.fname }</td>
    <td>${user.lname }</td>
    <td>${user.phone_no }</td>
    <td>${user.email_id }</td> 
     --%>
    
    <td align="center">
     <spring:url value="/user/update/${user.e_id}" var="updateURL" />
     <a href="${updateURL }">Update Password</a>
    </td>
   
    <td align ="center">
     <spring:url value="/user/delete/${user.username }" var="deleteURL" />
     <a href="${deleteURL }">Delete</a>
    </td>
   </tr>    
  </c:forEach>
 </table>
 
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
 
</body>
</html>