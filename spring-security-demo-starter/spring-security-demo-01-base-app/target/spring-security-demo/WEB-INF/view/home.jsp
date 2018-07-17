<%@ taglib prefix="c" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: hemraj
  Date: 7/4/18
  Time: 8:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome to the Home Page</title>
</head>
<body>
<h2>Hey, You are welcome over here.................</h2>

<form:form method="post" action="${pageContext.request.contextPath}/logout">
    <input type="submit" value="logout" class="btn btn-danger">
</form:form>
</body>
</html>