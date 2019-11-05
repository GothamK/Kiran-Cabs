<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Salary Update Form</title>
<link href="/style.css" rel="stylesheet"/>
</head>
<body>
 <spring:url value="/admin/salary/add" var="addSal" />
 <form:form modelAttribute="saluForm" method="post" action="/admin/salary/update">
  <table class="container">
   <tr>
     <tr>
    <td>
     <form:input path="sal_id" type="hidden"/>
    </td>
   </tr>
   <tr>
   <tr>
    <td>Amount: </td>
    <td>
     <form:input path="calculated_amount"/>
    </td>
   </tr>
   <tr>
    <td>Date: </td>
    <td>
     <form:input path="date"/>
    </td>
   </tr>
   <tr>
    <td>Employee ID: </td>
    <td>
     <form:input path="emp_id"/>
    </td>
   </tr>
   <tr>
   <tr>
    <td>
     <form:input path="payment_id" type="hidden"/>
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