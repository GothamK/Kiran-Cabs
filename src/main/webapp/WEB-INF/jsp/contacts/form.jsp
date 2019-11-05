<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Contacts Form</title>
<link href="/style.css" rel="stylesheet"/>
</head>
<body>
 <form:form modelAttribute="contForm" method="post" >
  <table class="container">
   <tr>
     <tr>
    <td> Contact No: </td>
    <td>
     <form:input path="contact_no"/>
    </td>
   </tr>
   <tr>
   <tr>
    <td> Contact Name: </td>
    <td>
     <form:input path="contact_name"/>
    </td>
   </tr>
   <tr>
    <td> Relation:  </td>
    <td>
     <form:input path="relation"/>
    </td>
   </tr>
   <tr>
    <td> Employee ID: </td>
    <td>
     <form:input path="e_id"/>
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