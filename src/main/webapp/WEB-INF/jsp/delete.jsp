<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete!</title>
    <link href="https://fonts.googleapis.com/css?family=Lato|Raleway:700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/main.css">
    <link rel="stylesheet" type="text/css" href="/style.css">
</head>
<body>
<jsp:include page="nav.jsp" />
<br>
<h2 align="center">Deletion Options</h2>
<p align="center">Select the table to perform deletion from.</p>

<form action="/admin/delete/delpage/{value}">
  <select name="Table Name" size="15">
    <option value="attendance">Volvo</option>
    <option value="cardocs">Saab</option>
    <option value="carins">Fiat</option>
    <option value="audi">Audi</option>
    
    
  </select>
  <br><br>
  <input type="submit">
</form>


<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

</body>
</html>ct>