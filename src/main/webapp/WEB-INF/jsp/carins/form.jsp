<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Car Insurance Form</title>
<link href="/style.css" rel="stylesheet"/>
</head>
<body>
 <spring:url value="/admin/carins/add" var="addci" />
 <form:form modelAttribute="ciForm" method="post" >
  <table class="container">
   <tr>
     <tr>
    <td>Insurance No: </td>
    <td>
     <form:input path="i_no"/>
    </td>
   </tr>
   <tr>
   <tr>
    <td>Insurance Agent: </td>
    <td>
     <form:input path="i_agent"/>
    </td>
   </tr>
   <tr>
    <td>Insured Amount: </td>
    <td>
     <form:input path="i_amount"/>
    </td>
   </tr>
   <tr>
    <td>Start Date: </td>
    <td>
     <form:input path="i_start"/>
    </td>
   </tr>
   <tr>
   <tr>
    <td>End Date: </td>
    <td>
     <form:input path="i_end"/>
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