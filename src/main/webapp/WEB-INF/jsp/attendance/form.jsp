<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Trips Form</title>
<link href="/style.css" rel="stylesheet"/>
</head>
<body>
 <spring:url value="/admin/attendance/add" var="addAt" />
 <form:form modelAttribute="atForm" method="post" >
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
    <td>Employee ID: </td>
    <td>
     <form:input path="emp_id"/>
    </td>
   </tr>
   <tr>
    <td>Leaves Taken: </td>
    <td>
     <form:input path="leaves_taken"/>
    </td>
   </tr>
   <tr>
       <td></td>
    <td>

     <input type="submit"> </input>
     </td>
   </tr>
  </table>
  
 </form:form>
</body>
</html>