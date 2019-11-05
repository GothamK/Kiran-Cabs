<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
 "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<title>User Page</title>
    <link href="https://fonts.googleapis.com/css?family=Lato|Raleway:700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/css/main.css">
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
<jsp:include page="nav.jsp" />
<br>

<!--<form  method="get" action="recorder/page/get">
	<input ="id"/>
	<button type="submit">Get</button>
</form>-->

<table class="card-table">
   <tr>
   </tr>
   <tr >
      <th class="card-cell">Attendance</th>
      	  <td class="card-cell"><a href ="/admin/attendance/add/">Add</a></td>
	      <td class="card-cell"><a href ="/recorder/attendance/list">View</a></td>
	      <td class="card-cell"><a href ="/admin/attendance/update/${id}">Update</a></td>
	      <td class="card-cell">Deletion Prohibited</td>
	      </tr>
	      <tr>
      <th class="card-cell">Car Documents</th>
      	  <td class="card-cell"><a href ="/admin/cardocs/add">Add</a></td>
	      <td class="card-cell"><a href ="/recorder/cardocs/list">View</a></td>
	      <td class="card-cell"><a href ="/admin/cardocs/update/${id}">Update</a></td>
	      <td class="card-cell">Deletion Prohibited</td>
	      </tr>
	      <tr>
	      
	      <th class="card-cell">Cars</th>
      	  <td class="card-cell"><a href ="/admin/cars/add">Add</a></td>
	      <td class="card-cell"><a href ="/recorder/cars/list">View</a></td>
	      <td class="card-cell"><a href ="/admin/cars/update/${id}">Update</a></td>
	      <td class="card-cell">Deletion Prohibited</td>
	      </tr>
	      <tr>
	      
      <th class="card-cell">Car Insurances</th>
      	  <td class="card-cell"><a href ="/admin/carins/add">Add</a></td>
	      <td class="card-cell"><a href ="/recorder/carins/list">View</a></td>
	      <td class="card-cell"><a href ="/admin/carins/update/${id}">Update</a></td>
	      <td class="card-cell"><a href ="/admin/carins/delete/${id}">Delete</a></td>
   </tr>
<!--   <tr><th class="head-cell">Employee</th></tr>-->

   <tr>
      <th class="card-cell">Contacts</th>
      	  <td class="card-cell"><a href ="/admin/contacts/add">Add</a></td>
	      <td class="card-cell"><a href ="/recorder/contacts/list">View</a></td>
	      <td class="card-cell"><a href ="/admin/contacts/update/${id}">Update</a></td>
	      <td class="card-cell"><a href ="/admin/contacts/delete/${id}">Delete</a></td>
	      </tr>
	      <tr>
      <th class="card-cell">Employee</th>
      	  <td class="card-cell"><a href ="/admin/employee/add">Add</a></td>
	      <td class="card-cell"><a href ="/recorder/employee/list">View</a></td>
	      <td class="card-cell"><a href ="/admin/employee/update/${id}">Update</a></td>
	      <td class="card-cell">Deletion Prohibited</td>
	      </tr>
	      <tr>
      <th class="card-cell">Employee Insurance</th>
      	  <td class="card-cell"><a href ="/admin/einsurance/add">Add</a></td>
	      <td class="card-cell"><a href ="/recorder/einsurance/list">View</a></td>
	      <td class="card-cell"><a href ="/admin/einsurance/update/${id}">Update</a></td>
	      <td class="card-cell"><a href ="/admin/einsurance/delete/${id}">Delete</a></td>
   </tr>
<!--   <tr><th class="head-cell">Employee</th></tr>-->
 
   <tr>
      <th class="card-cell">Fines</th>
      	  <td class="card-cell"><a href ="/admin/fines/add">Add</a></td>
	      <td class="card-cell"><a href ="/recorder/fines/list">View</a></td>
	      <td class="card-cell"><a href ="/admin/fines/update/${id}">Update</a></td>
	      <td class="card-cell">Deletion Prohibited</td>
	      </tr>
	      <tr>

      <th class="card-cell">InterState Permissions</th>
      	  <td class="card-cell"><a href ="/admin/isp/add">Add</a></td>
	      <td class="card-cell"><a href ="/recorder/isp/list">View</a></td>
	      <td class="card-cell"><a href ="/admin/isp/update/${id}">Update</a></td>
	      <td class="card-cell"><a href ="/admin/isp/delete/${id}">Delete</a></td>

   </tr>
<!--   <tr><th class="head-cell">Employee</th></tr>-->
   <tr>
      <th class="card-cell">Net</th>
          <td class="card-cell"><a href ="/admin/net/add">Add</a></td>
	      <td class="card-cell"><a href ="/recorder/net/list/">View</a></td>
	      <td class="card-cell"><a href ="/admin/net/update/${id}">Update</a></td>
	      <td class="card-cell">Deletion Prohibited</td>
	      </tr>
	      <tr>
      <th class="card-cell">Payments</th>
          <td class="card-cell"><a href ="/admin/payments/add">Add</a></td>
	      <td class="card-cell"><a href ="/recorder/payments/list/">View</a></td>
	      <td class="card-cell">Updation prohibited</td>
	      <td class="card-cell">Deletion Prohibited</td>
	      </tr>
	      <tr>
      <th class="card-cell">Salary</th>
          <td class="card-cell"><a href ="/admin/salary/add">Add</a></td>
	      <td class="card-cell"><a href ="/recorder/salary/list/">View</a></td>
	      <td class="card-cell"><a href ="/admin/salary/update/${id}">Update</a></td>
	      <td class="card-cell">Deletion Prohibited</td>
   </tr>
<!--   <tr><th class="head-cell">Employee</th></tr>-->
   <tr>
      <th class="card-cell">Service</th>
      	  <td class="card-cell"><a href ="/admin/service/add">Add</a></td>
	      <td class="card-cell"><a href ="/recorder/service/list">View</a></td>
	      <td class="card-cell"><a href ="/admin/service/update/${id}">Update</a></td>
	      <td class="card-cell">Deletion Prohibited</td>
	      </tr>
	      <tr>
      <th class="card-cell">Trips</th>
          <td class="card-cell"><a href ="/admin/trips/add">Add</a></td>
	      <td class="card-cell"><a href ="/recorder/trips/list">View</a></td>
	      <td class="card-cell"><a href ="/recorder/trips/update/${id}">Update</a></td>
	      <td class="card-cell">Deletion Prohibited</td>
	      </tr>
	      <tr>
      <th class="card-cell">User</th>
          <td class="card-cell"><a href ="/admin/user/add">Add</a></td>
	      <td class="card-cell"><a href ="/recorder/user/list">View</a></td>
	      <td class="card-cell"><a href ="/admin/user/update/${id}">Update</a></td>
	      <td class="card-cell"><a href ="/admin/user/delete/${id}">Delete</a></td>
   </tr>
</table>

<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

</body>
</html>
