<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Net Profit/Loss Form</title>
<link href="/style.css" rel="stylesheet"/>
</head>
<body>
 <spring:url value="/admin/net/add" var="addnet" />
 <form:form modelAttribute="netForm" method="post" >
  <table class="container">
   <tr>
     <tr>
    <td>Date: </td>
    <td>
     <form:input path="date"/>
    </td>
   </tr>
   <tr>
   <tr>
    <td>Profit/Loss: </td>
    <td>
     <form:input path="profit"/>
    </td>
   </tr>
   <tr>
    <td></td>
    <td>
     <button type="submit">Save</button>
    </td>
   </tr>
  </table>
  
 </form:form>
</body>
</html>