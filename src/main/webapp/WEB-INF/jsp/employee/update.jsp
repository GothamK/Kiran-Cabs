<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Update Form</title>
<link href="/style.css" rel="stylesheet"/>
</head>
<body>
 <spring:url value="/admin/employee/add" var="addpost" />
 <form:form modelAttribute="empuForm" method="post" action="/admin/employee/update/" >
  <table class="container">
   <tr>
     <tr>
    <td>
     <form:input path="e_id" type="hidden"/>
    </td>
   </tr>
   <tr>
   <tr>
    <td> Name: </td>
    <td>
     <form:input path="e_name"/>
    </td>
   </tr>
   <tr>
    <td> Salary: </td>
    <td>
     <form:input path="salary"/>
    </td>
   </tr>
   <tr>
    <td> No of Ratings: </td>
    <td>
     <form:input path="no_of_ratings"/>
    </td>
   </tr>
   <tr>
   <tr>
    <td> Average Rating: </td>
    <td>
     <form:input path="avg_rating"/>
    </td>
   </tr>
   <tr>
    <td> Address: </td>
    <td>
     <form:input path="address" />
    </td>
   </tr>
   <tr>
    <td> Phone No: </td>
    <td>
     <form:input path="phone_no" />
    </td>
   </tr>
      <tr>
    <td> DL No: </td>
    <td>
     <form:input path="dl_no" />
    </td>
   </tr>
      <tr>
    <td> Designation: </td>
    <td>
     <form:input path="designation" />
    </td>
   </tr>
      <tr>
    <td> DOB: </td>
    <td>
     <form:input path="dob" />
    </td>
   </tr>
      <tr>
    <td> Joining Date: </td>
    <td>
     <form:input path="start_date" />
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