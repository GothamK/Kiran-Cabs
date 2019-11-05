<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
 "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<title>Trips</title>
</head>
<body>
 <spring:url value="/trips/add" var="addTrip" />
 <a href="${addTrip }">Add Trip</a>

 <h1>Trips</h1>
 
 <table width="100%" border="1">
  <tr>
   <th>Trip ID</th>
   <th>Customer Name</th>
   <th>Date</th>
   <th>Distance</th>
   <th>Duration</th>
   <th>Charges</th>
   <th>Car Registration No</th>
   <th>Driver ID</th>
   <th>Pickup Point</th>
   <th>Drop Point</th>
   <th>Rating</th>
   <th colspan="2">Action</th>
  </tr>
  <c:forEach items="${listTrips }" var="trip" >
   <tr>
    <td>${trip.trip_id }</td>
    <td>${trip.customer_name }</td>
    <td>${trip.date }</td>
    <td>${trip.dist }</td>
    <td>${trip.duration }</td>
    <td>${trip.charges }</td>
    <td>${trip.registration_no }</td>
    <td>${trip.driv_no }</td>
    <td>${trip.pickup_point }</td>
    <td>${trip.drop_point }</td>
    <td>${trip.rating }</td>
    <td>
     <spring:url value="/trips/update/${trip.trip_id }" var="updateTrip" />
     <a href="${updateTrip }">Update</a>
    </td>
    <td>
     <spring:url value="/trips/delete/${trip.trip_id }" var="deleteTrip" />
     <a href="${deleteTrip }">Delete</a>
    </td>
   </tr>    
  </c:forEach>
 </table>
 
</body>
</html>