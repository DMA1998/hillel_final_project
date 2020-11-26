<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<fmt:setBundle basename="/localization/lang"/>

<fmt:message key="fam.enter" var="enterNumber"/>
<fmt:message key="ahn.an" var="actor1"/>
<fmt:message key="ahb.ab" var="actorBirthday"/>
<fmt:message key="b1.go" var="Go"/>

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
<br>
<div align="center">
    <h1 style="color:#eefaff">${enterNumber}</h1>
    <br>
    <form method="post" action="findActorsByManyFilmsServlet">
        <label>
            <input type="text" name="filmsQuantity" style="font-size: 27px">
        </label>
        <input type="submit" value="${Go}" name="Submit" class="button01" style="font-size: 33px">
    </form>
    <br>
    <ul >
        <br>
        <c:forEach var="actor" items="${actorsFilms}">
            <h2 style="color:#eefaff">
                <li>${actor1} ${actor.name}</li>
                <li>${actorBirthday} ${actor.date}</li>
            </h2>
            <br>
        </c:forEach>
    </ul>
</div>
</body>
</html>