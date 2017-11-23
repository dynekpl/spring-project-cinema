<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Rezerwacje usera ${user.email}</h1>
<table>
    <tr>
        <th>Id</th>
        <th>Status</th>
        <th>Film</th>
    </tr>
    <tr>
    <c:forEach items="${userReservations}" var="reservation" >
        <td>${reservation.id}</td>
        <td>${reservation.status}</td>
        <td>${reservation.show.movie.title}</td>
    </c:forEach>
    </tr>
</table>
</body>
</html>