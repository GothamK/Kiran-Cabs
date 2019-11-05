<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cars Form</title>
<link href="/style.css" rel="stylesheet"/>
</head>
<body>
 <form:form modelAttribute="cForm" method="post" >
  <table class="container">
   <tr>
     <tr>
    <td> Registration No: </td>
    <td>
     <form:input path="registration_no"/>
    </td>
   </tr>
   <tr>
   <tr>
    <td> Company: </td>
    <td>
     <form:input path="company"/>
    </td>
   </tr>
   <tr>
    <td> Distance Covered: </td>
    <td>
     <form:input path="dist_travelled"/>
    </td>
   </tr>
   <tr>
    <td> Selling Price: </td>
    <td>
     <form:input path="selling_price"/>
    </td>
   </tr>
   <tr>
   <tr>
    <td> Model: </td>
    <td>
     <form:input path="model"/>
    </td>
   </tr>
   <tr>
    <td> Active: </td>
    <td>
     <form:input path="active" />
    </td>
   </tr>
   <tr>
    <td> Cost price: </td>
    <td>
     <form:input path="cost_price" />
    </td>
   </tr>
      <tr>
    <td> Colour: </td>
    <td>
     <form:input path="colour" />
    </td>
   </tr>
      <tr>
    <td> Capacity: </td>
    <td>
     <form:input path="capacity" />
    </td>
   </tr>
      <tr>
    <td> Purchase Date: </td>
    <td>
     <form:input path="purchase_date" />
    </td>
   </tr>
      <tr>
    <td> Fuel: </td>
    <td>
     <form:input path="fuel" />
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