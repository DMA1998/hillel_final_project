<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<fmt:setBundle basename="/localization/lang"/>

<html>
<head>
    <style>
        <%@include file="/css/style.css" %>
    </style>
    <meta content="text/html;charset=utf-8" http-equiv="Content-Type">
    <meta content="utf-8" http-equiv="encoding">
    <title>Hillel</title>
</head>
<body background="<c:url value='/css/images/picture1.jpg' />">
<div class="header">
    <div class="inner_header" style="width: 87%">
        <div class="logo_container">
            <c:set var="user" value="${sessionScope.user}"/>
            <c:choose>
                <c:when test="${user == null}">
                    <a href="loginServlet" class="logo_container">
                        <fmt:message key="h6.login" var="LogIn"/>
                        <h1><span style="font-size: 60px">${LogIn}</span></h1>
                    </a>
                </c:when>
                <c:otherwise>
                    <a href="logoutServlet" class="logo_container">
                        <fmt:message key="h7.logout" var="LogOut"/>
                        <h1><span style="font-size: 50px">${LogOut}</span></h1>
                    </a>
                </c:otherwise>
            </c:choose>
        </div>
        <ul class="navigation">
            <li>
                <form action="languageServlet" method="post">
                    <select name="language" onchange="submit()" class="navigation">
                        <option value="en" ${locale == 'en' ? 'selected' : ''}>English</option>
                        <option value="it" ${locale == 'it' ? 'selected' : ''}>Italian</option>
                    </select>
                </form>
            </li>
            <a href="findActorsInParticularFilmServlet">
                <li>
                    <fmt:message key="h2.findParticular" var="findActors"/>
                    <fmt:message key="h2.findParticular2" var="InParticularFilm"/>
                    ${findActors}<br>${InParticularFilm}
                </li>
            </a>
            <a href="findActorsByManyFilmsServlet">
                <li>
                    <fmt:message key="h1.findMany" var="findActorsBy"/>
                    <fmt:message key="h1.findMany2" var="manyFilms"/>
                    ${findActorsBy}<br>${manyFilms}
                </li>
            </a>
            <a href="findActorsLikeProducersServlet">
                <li>
                    <fmt:message key="h3.findLikeProd" var="findActors"/>
                    <fmt:message key="h3.findLikeProd2" var="LikeProducers"/>
                    ${findActors}<br>${LikeProducers}
                </li>
            </a>
            <a href="findFilmsByCurrentPreviousYearServlet">
                <li>
                    <fmt:message key="h4.findCurrentYear" var="findFilmsByCurrent"/>
                    <fmt:message key="h4.findCurrentYear2" var="PreviousYear"/>
                    ${findFilmsByCurrent}<br>${PreviousYear}
                </li>
            </a>
            <a href="removeFilmsByYearServlet">
                <li>
                    <fmt:message key="h5.rmFilms" var="removeFilms"/>
                    ${removeFilms}
                </li>
            </a>
        </ul>
    </div>
</div>
</body>
</html>
