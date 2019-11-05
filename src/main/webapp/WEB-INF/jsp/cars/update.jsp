<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cars Update Form</title>
<link href="/style.css" rel="stylesheet"/>
    <link href="https://fonts.googleapis.com/css?family=Lato|Raleway:700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/css/main.css">
</head>
<body>
 <form:form modelAttribute="cuForm" method="post" action="/admin/cars/update">
  <table class="container">
   <tr>
     <tr>
    <td>
     <form:input path="registration_no" type="hidden"/>
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
 <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
 
</body>
</html>