<%@page pageEncoding="UTF-8" contentType="text/html; utf-8" isELIgnored="false" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<shiro:authenticated>
    你好：<shiro:principal></shiro:principal>
    <a href="${pageContext.request.contextPath}/user/exit">登出</a>
    <shiro:hasPermission name="user:add:*">
        <li>增</li>
    </shiro:hasPermission>
    <shiro:hasPermission name="user:delete:*">
        <li>删</li>
    </shiro:hasPermission>
    <shiro:hasPermission name="user:query:*">
        <li>查</li>
    </shiro:hasPermission>
    <shiro:hasPermission name="user:update:*">
        <li>改</li>
    </shiro:hasPermission>


    <shiro:hasRole name="super">
        <li>管理员</li>
    </shiro:hasRole>
</shiro:authenticated>
<shiro:notAuthenticated>
    <a href="${pageContext.request.contextPath}/login/login.jsp">请登录，解锁更多姿势</a>
</shiro:notAuthenticated>
</body>
</html>