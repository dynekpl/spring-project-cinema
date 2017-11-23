<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <th>Id</th>
        <th>Email</th>
        <th>Password</th>
        <th>Reservations</th>
    </tr>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.email}</td>
            <td>${user.password}</td>
            <td><a href="<c:url value="/reservations/byUser?userId=${user.id}"/>">${user.reservations.size()}</a></td>
        </tr>
    </c:forEach>

</table>

</body>
</html>