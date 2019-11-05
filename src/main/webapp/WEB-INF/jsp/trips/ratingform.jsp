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
 <spring:url value="/trips/rate/{trip_id}" var="saveUR" />
 <form:form modelAttribute="trform" method="post" action="/recorder/trips/update" >

  <table>
  <tr>
     <tr>
    <td>
     <form:input path="trip_id" type="hidden" value="${trip_id}"/>
    </td>
   </tr>
   <tr>
     <tr>
    <td>Charges: </td>
    <td>
     <input name="charges"  />
    </td>
   </tr>
      <tr>
     <tr>
    <td>Rating: </td>
    <td>
     <form:input path="rating"  />
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