<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hemraj
  Date: 7/5/18
  Time: 10:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Form</title>
</head>
<body>
<h3>My Custom Login Page</h3>
<div>
    <form:form action="${pageContext.request.contextPath}/authenticateTheUser" method="post">

        <%--Check for error page--%>
        <c:if test="${param.error != null}">
            <i>Sorry! You entered invalid users</i>
        </c:if>
        <p>
            user name: <input type="text" name="username">
        </p>

        <p>
            password: <input type="password" name="password">
        </p>

        <input type="submit" value="LogIn">

    </form:form>
</div>
</body>
</html>
