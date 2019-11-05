<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Car Docs Update Form</title>
<link href="/style.css" rel="stylesheet"/>
</head>
<body>
 <!--<spring:url value="/admin/cardocs/update" var="saveCarDocs" />-->
 <form:form modelAttribute="cduForm" method="post" action="/admin/cardocs/update" >
  <table class="container" align = "center">
    <tr>
   </tr>
   <tr>
     <tr>
    <td>
     <form:input path="registration_no" type ="hidden"/>
    </td>
   </tr>
   <tr>
   <tr>
    <td>Pollution Check Certificate No: </td>
    <td>
     <form:input path="poll_check"/>
    </td>
   </tr>
   <tr>
    <td>Pollution Check Expiry: </td>
    <td>
     <form:input path="poll_expiry"/>
    </td>
   </tr>
   <tr>
    <td>Active Insurance No: </td>
    <td>
     <form:input path="i_no"/>
    </td>
    <tr>
    <td>
     <input type="submit"> </input>
     </td>
   </tr>
  </table>
  
 </form:form>
</body>
</html>