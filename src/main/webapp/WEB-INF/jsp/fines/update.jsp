<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Fine Form</title>
<link href="/style.css" rel="stylesheet"/>
</head>
<body>
 <spring:url value="/admin/fines/add" var="addf" />
 <form:form modelAttribute="fuForm" method="post" action="/admin/fines/update" >
  <table class="container">
     <tr>
    <td>
     <form:input path="fine_id" type = "hidden" />
    </td>
   </tr>
   <tr>
   <tr>
    <td>Offence: </td>
    <td>
     <form:input path="offence"/>
    </td>
   </tr>
   <tr>
    <td>Fined Amount: </td>
    <td>
     <form:input path="fined_amount"/>
    </td>
   </tr>
   <tr>
    <td>Consequences: </td>
    <td>
     <form:input path="consequences"/>
    </td>
   </tr>
   <tr>
   <tr>
    <td>Car Registration No: </td>
    <td>
     <form:input path="regn_no"/>
    </td>
   </tr>
   <tr>
    <td>Date: </td>
    <td>
     <form:input path="date" />
    </td>
   </tr>
   <tr>
    <td>Driver ID: </td>
    <td>
     <form:input path="driv_id" />
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