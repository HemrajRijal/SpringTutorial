<%--
  Created by IntelliJ IDEA.
  User: hemraj
  Date: 2/1/18
  Time: 7:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Fill the Form</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap-grid.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap-reboot.css">
</head>
<body>
<div class="container">
    <form action="/hello/processFormVersionThree" method="get" class="form-control">
        <input type="text" name="studentName" placeholder="What is your name?" class="form-control"/>
        <br>
        <input type="submit" class="btn btn-success"/>

    </form>
</div>
</body>
</html>
