<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Insurance Update Form</title>
<link href="/style.css" rel="stylesheet"/>
</head>
<body>
 <form:form modelAttribute="eiuForm" method="post" action="/admin/einsurance/update" >
  <table class="container">
   <tr>
     <tr>
    <td>
     <form:input path="ins_no" type="hidden"/>
    </td>
   </tr>
   <tr>
   <tr>
    <td>Insurance Provider: </td>
    <td>
     <form:input path="ins_provider"/>
    </td>
   </tr>
   <tr>
    <td>Beneficiary: </td>
    <td>
     <form:input path="beneficiary"/>
    </td>
   </tr>
   <tr>
    <td>Relation: </td>
    <td>
     <form:input path="relation"/>
    </td>
   </tr>
   <tr>
   <tr>
    <td>Type: </td>
    <td>
     <form:input path="ins_type"/>
    </td>
   </tr>
   <tr>
    <td>Amount Insured: </td>
    <td>
     <form:input path="ins_amount" />
    </td>
   </tr>
   <tr>
    <td>Employee ID: </td>
    <td>
     <form:input path="emp_id" />
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