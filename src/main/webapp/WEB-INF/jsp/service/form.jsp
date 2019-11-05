<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Service Form</title>
<link href="/style.css" rel="stylesheet"/>
</head>
<body>
 <spring:url value="/admin/service/add" var="addserp" />
 <form:form modelAttribute="serForm" method="post" >
  <table class="container">
   <tr>
     <tr>
    <td>
     <form:input path="ser_id" type = "hidden"/>
    </td>
   </tr>
   <tr>
   <tr>
    <td>Service Center: </td>
    <td>
     <form:input path="s_center"/>
    </td>
   </tr>
   <tr>
    <td>Service Cost: </td>
    <td>
     <form:input path="s_cost"/>
    </td>
   </tr>
   <tr>
    <td>Service Type: </td>
    <td>
     <form:input path="s_type"/>
    </td>
   </tr>
   <tr>
   <tr>
    <td>Car Registration No: </td>
    <td>
     <form:input path="reg_no"/>
    </td>
   </tr>
   <tr>
    <td>Date: </td>
    <td>
     <form:input path="date" />
    </td>
   </tr>
   <tr>
    <td>
     <form:input path="payment_id" type = "hidden" />
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