<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<fmt:setBundle basename="/localization/lang"/>

<fmt:message key="alp.pm" var="producerName"/>
<fmt:message key="alp.pb" var="producerBirthday"/>

<html>
<head>
    <style>
        <%@include file="/css/style.css" %>
    </style>
    <meta content="text/html;charset=utf-8" http-equiv="Content-Type">
    <meta content="utf-8" http-equiv="encoding">
    <title>Hillel</title>
</head>
<body>
<c:import url="/header/header.jsp"></c:import>
<div align="left">
    <ul>
        <c:forEach var="producer" items="${producers}">
            <h1 style="color:#eefaff">
                <li>${producerName} ${producer.name}</li>
                <li>${producerBirthday} ${producer.date}</li>
            </h1>
            <br>
        </c:forEach>
    </ul>
</div>
</body>
</html>