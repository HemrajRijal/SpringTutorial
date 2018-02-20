<%--
  Created by IntelliJ IDEA.
  User: hemraj
  Date: 2/1/18
  Time: 7:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap-grid.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap-reboot.css">
</head>
<body>
<div class="container">
    <h2 class="form-control-plaintext">
        <br><br>

        Student name: ${param.studentName}
        <br><br>
        The message: ${message}
    </h2>
</div>
</body>
</html>
