<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hemraj
  Date: 2/3/18
  Time: 9:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome Page</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap-grid.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap-reboot.css">
</head>
<body>
<br><br>
<h2 class="container btn-primary">
    The Student is Confirmed:----> ${student.firstName} ${student.lastName}
    <br>
    You are from ----------------->${student.country}
    <br>
    Free Passes-------------> ${student.freePases}
    <br>
    Postal Code-------------> ${student.postalCode}
    <br>
    Course Code-------------> ${student.courseCode}
    <br>
    Favorite Language------------------->${student.favoriteLanguage}
    <br>
    You use---->
    <ul>
        <c:forEach var="temp" items="${student.favOs}">

            <li> ${temp} </li>

        </c:forEach>
    </ul>
</h2>
</body>
</html>
