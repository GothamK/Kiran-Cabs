<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

    <title>Records</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <link href="https://fonts.googleapis.com/css?family=Lato|Raleway:700&display=swap" rel="stylesheet">
    <link href="/css/main.css" rel="stylesheet" type="text/css">
    <link href="/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<jsp:include page="nav.jsp" />
    <a href="/recorder/records"><h2> Records </h2></a>
    <hr size="4" color="gray" />

    <c:if test="${empty obj}">
        <h1>No Data</h1>
    </c:if>
    <c:if test="${not empty obj}">
       
        <table border="2">
            <tr class ="table-head">
                <c:forEach var="map" items="${obj}" end="0">
                    <c:forEach items="${map}" var="entry">
                        <th >  ${entry.key}  </th>
                   
                    </c:forEach>
                </c:forEach>
            </tr>
           
        <c:forEach items="${obj}" var="map">
            <tr>
            <c:forEach items="${map}" var="entry">
                <td>  ${entry.value}  </td>
            </c:forEach>
            </tr>
        </c:forEach>
        </table>
    </c:if>
    
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
 
</body>

</html>