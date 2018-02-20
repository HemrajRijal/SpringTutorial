<%--
  Created by IntelliJ IDEA.
  User: hemraj
  Date: 2/3/18
  Time: 9:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="frm" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Student Form</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap-grid.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap-reboot.css">
</head>
<body>

<div class="container-fluid align-content-center">
    <h2>Register yourself Guys</h2>

    <form:form action="processForm" modelAttribute="student">
        First Name: <form:input path="firstName" cssClass="col-md-6 form-control"/>

        <br>

        Last Name(*): <form:input path="lastName" cssClass="col-md-6 form-control"/>
        <form:errors path="lastName" cssClass="col-md-2 text-danger"/>
        <br>

        Free Pases:
        <form:input path="freePases" cssClass="col-md-6 form-control"/>
        <form:errors path="freePases" cssClass="col-md-2 text-danger"/>

        <br>

       Postal Code:
        <form:input path="postalCode" cssClass="col-md-6 form-control"/>
        <form:errors path="postalCode" cssClass="col-md-2 text-danger"/>

        <br>

        Course Code:
        <form:input path="courseCode" cssClass="col-md-6 form-control"/>
        <form:errors path="courseCode" cssClass="col-md-2 text-danger"/>


        <br>

        Country:
        <form:select path="country" cssClass="dropdown">
            <form:options items="${student.countryList}"/>
        </form:select>

        <br>
        <br>

        Favorite Language:
        <form:radiobuttons path="favoriteLanguage" items="${student.languageOptions}" cssClass="custom-radio"/>
        <br>

        Operating System:
        <form:checkboxes path="operatingSystem" items="${student.favOs}"/>

        <input type="submit" value="Submit" class="btn btn-success">

    </form:form>

</div>

</body>
</html>