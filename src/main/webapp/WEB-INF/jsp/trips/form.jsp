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
 <spring:url value="/trips/addpost" var="saveTrips" />
 <form:form modelAttribute="form" method="post" action="/recorder/trips/update">
  <table class="container" align="center">
    <tr>
    <td>
	<form:input path="trip_id" type="hidden" />
	</td>
   </tr>
   <tr>
     <tr>
    <td>Customer Name: </td>
    <td>
     <form:input path="customer_name"/>
    </td>
   </tr>
   <tr>
   <tr>
    <td>Date: </td>
    <td>
     <form:input path="date"/>
    </td>
   </tr>
   <tr>
    <td>Distance: </td>
    <td>
     <form:input path="dist"/>
    </td>
   </tr>
   <tr>
    <td>Duration: </td>
    <td>
     <form:input path="duration"/>
    </td>
   </tr>
   <tr>
   <tr>
    <td>Charges: </td>
    <td>
     <form:input path="charges"/>
    </td>
   </tr>
   <tr>
    <td>Car Registration No: </td>
    <td>
     <form:input path="registration_no" />
    </td>
   </tr>
   <tr>
    <td>Driver ID: </td>
    <td>
     <form:input path="driv_no" />
    </td>
   </tr>
      <tr>
    <td>Pick-up Point: </td>
    <td>
     <form:input path="pickup_point" />
    </td>
   </tr>
      <tr>
    <td>Drop Point: </td>
    <td>
     <form:input path="drop_point" />
    </td>
   </tr>
      <tr>
    <td>Rating: </td>
    <td>
     <form:input path="rating" />
    </td>
   </tr>
   <tr>
    <td></td>
    <td>
     <button type="submit" >Save</button>
    </td>
   </tr>
  </table>
  
 </form:form>
</body>
</html>