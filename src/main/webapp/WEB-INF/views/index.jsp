<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" href="http://cdn.staticfile.org/twitter-bootstrap/2.3.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="/repo/css/style.css">
</head>
<body>
<div class="container">

    <div class="login_warper">


        <form action="/home.do" method="post">
            <c:if test="${not empty code}">
            <div class="alert ${state}">
                <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <c:if test="${code == '1001'}">
                    账号或密码错误
                </c:if>
                <c:if test="${code == '1002'}">
                    该账号已被禁用
                </c:if>
                <c:if test="${code == '1003'}">
                    您已经安全退出
                </c:if>
            </div>
            </c:if>
            <legend>KaiShengIT</legend>
            <label>账号</label>
            <input type="text" name="loginName">
            <label>密码</label>
            <input type="password" name="password">
            <div class="form-actions">
                <button class="button button-flat-action">进入系统</button>
            </div>
        </form>
    </div>

</div>


<script src="http://cdn.staticfile.org/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.staticfile.org/twitter-bootstrap/3.0.0/js/bootstrap.min.js"></script>


</body>
</html>
