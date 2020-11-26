<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<fmt:setBundle basename="/localization/lang"/>

<fmt:message key="ff.fn" var="filmName"/>
<fmt:message key="ff.fr" var="filmRelease"/>
<fmt:message key="ff.fc" var="filmCountry"/>
<fmt:message key="ff.fp" var="filmProducer"/>
<fmt:message key="ff.fa" var="filmActors"/>

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
<ul>
    <c:forEach var="film" items="${films}">
        <h1 style="color:#eefaff">
            <li>${filmName} ${film.name}</li>
            <li>${filmRelease} ${film.filmRelease}</li>
            <li>${filmCountry} ${film.country}</li>
            <li>${filmProducer} ${film.producer.name}</li>
            <li>${filmActors} </li>
        </h1>
        <c:forEach var="actor" items="${film.actors}">
            <h1 style="color:#eefaff">
                <li>${actor.name}</li>
            </h1>
        </c:forEach>
        <br><br>
    </c:forEach>
</ul>
</body>
</html>