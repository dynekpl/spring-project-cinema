<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dodawanie nowego usera</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous"></head>
<body>
<div class="container-fluid">
    <div class="row">

        <h2>Dodaj nowego usera</h2>

        <div class="col-lg-12">

            <c:url value="/accounts/save" var="postUrl"/>
            <form:form modelAttribute="userForm" action="${postUrl}" method="post">
                <form:errors path="*" element="div" />
                <%--<form:errors path="*" element="div" />--%>
                <table class="table table-responsive table-bordered">
                    <tr>
                        <td>Email</td>
                        <td>
                            <form:input path="email"/>
                            <form:errors path="email" />
                        </td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td>
                            <form:input path="password"/>
                            <form:errors path="password" />
                        </td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Wyślij"/></td>
                    </tr>
                </table>
            </form:form>
        </div>
    </div>
</div>
</body>
</html>