<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<fmt:setBundle basename="/localization/lang"/>

<fmt:message key="lp.log" var="login1"/>
<fmt:message key="lp.pass" var="password1"/>
<fmt:message key="lp.atr" var="authorization1"/>

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
<br>
<br>
<div align="left">
    <h2 style="color:#eefaff">
        Test data:<br>
        login: user<br>
        password: 1234
    </h2>
</div>

<div align="center" >
    <form method="post" action="loginServlet" >
        <h1 style="color:#eefaff">${login1}</h1> <input type="text" name="login" style="font-size: 35px"><br><br><br>
        <h1 style="color:#eefaff">${password1}</h1> <input type="password" name="password" style="font-size: 35px"><br><br><br>
        <input type="submit" value="${authorization1}" class="loginBut" style="font-size: 45px">
    </form>
    <br>
</div>
</body>
</html>