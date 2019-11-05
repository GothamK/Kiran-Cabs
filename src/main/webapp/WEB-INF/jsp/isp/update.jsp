<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>InterState Permission Update Form</title>
<link href="/style.css" rel="stylesheet"/>
</head>
<body>
 <spring:url value="/admin/isp/add" var="addf" />
 <form:form modelAttribute="ispuForm" method="post" action="/admin/isp/update" >
   <table class="container">
   <tr>
     <tr>
    <td>
     <form:input path="p_no" type ="hidden"/>
    </td>
   </tr>
   <tr>
   <tr>
    <td>Place 1: </td>
    <td>
     <form:input path="place1"/>
    </td>
   </tr>
   <tr>
    <td>Place 2: </td>
    <td>
     <form:input path="place2"/>
    </td>
   </tr>
   <tr>
    <td>Start Date: </td>
    <td>
     <form:input path="s_date"/>
    </td>
   </tr>
   <tr>
   <tr>
    <td>Charges: </td>
    <td>
     <form:input path="p_tax"/>
    </td>
   </tr>
   <tr>
    <td>End Date: </td>
    <td>
     <form:input path="e_date" />
    </td>
   </tr>
   <tr>
    <td>Car Registration No: </td>
    <td>
     <form:input path="reg_no" />
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