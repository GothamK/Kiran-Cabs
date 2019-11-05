<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Attendance Update Form</title>
<link href="/style.css" rel="stylesheet"/>
</head>
<body>
<jsp:include page="nav.jsp" />
<spring:url value="/admin/attendance/update/{emp_id}/{date}" var="editAt" />
 <form:form modelAttribute="atuForm" method="post" action="/admin/attendance/update" >
  <table class="container">
   <tr>
     <tr>
    <td>
     <form:input path="date" type="hidden"/>
    </td>
   </tr>
   <tr>
   <tr>
    <td>
     <form:input path="emp_id" type ="hidden"/>
    </td>
   </tr>
   <tr>
    <td>Leaves Taken: </td>
    <td>
     <form:input path="leaves_taken"/>
    </td>
   </tr>
   <tr>
       <td></td>
    <td>

     <input type="submit">Submit</input>
     </td>
   </tr>
  </table>
  
 </form:form>
</body>
</html>