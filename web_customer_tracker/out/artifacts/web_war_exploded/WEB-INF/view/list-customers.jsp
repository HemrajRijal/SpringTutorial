<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: hemraj
  Date: 2/26/18
  Time: 10:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Customer</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>

<div id="wrapper">
    <div id="header">
        <h2>CRM- Customer Relationship Manager</h2>
    </div>
</div>

<div id="container">
    <div id="content">
        <%--Add customer table here--%>
        <table>
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>email</th>
            </tr>


            <%--Loop over and print customer--%>
            <c:forEach var="tempCustomer" items="${customers}">
                <tr>
                    <td>${tempCustomer.firstName}</td>
                    <td>${tempCustomer.lastName}</td>
                    <td>${tempCustomer.email}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>