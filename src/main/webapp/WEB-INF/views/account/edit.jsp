<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" href="http://cdn.staticfile.org/twitter-bootstrap/2.3.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="http://cdn.staticfile.org/font-awesome/4.1.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

<%@include file="../include/navbar.jsp"%>

<div class="container-fluid">
    <div class="row-fluid">
        <div class="span12">

            <div class="box">
                <div class="box-header">
            <span class="title">
              <i class="fa fa-plus"></i>
              <a href="dept-list.html"> 系统账户列表</a>  /  新增账号
            </span>
                </div>
                <div class="box-body form">
                    <form action="/account/save.do" method="post">
                        <label>员工姓名</label>
                        <input type="text" name="account.accountName" value="${account.accountName}">
                        <label>账号 <span class="muted">(用于登录系统)</span></label>
                        <input type="text" id="account" name="account.loginName" value="${account.loginName}">
                        <label>密码 <span class="muted">(默认123456)</span></label>
                        <input type="password" name="account.password" value="123456">
                        <label>联系电话</label>
                        <input type="text" name="account.accountTel" value="${account.accountTel}">
                        <label>请选择角色</label>
                        <select name="account.role.id" id="">
                            <c:forEach items="${roleList}" var="role">
                                <option value="${role.id}" ${account.role.id == role.id ? 'selected' : ''}>${pub.pubname}</option>
                            </c:forEach>
                        </select>

                        <div class="form-actions">
                            <button class="button button-flat-action button-pill">保存</button>
                        </div>
                    </form>
                </div>
            </div>


        </div>

    </div>
</div>



<script src="http://cdn.staticfile.org/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.staticfile.org/twitter-bootstrap/3.0.0/js/bootstrap.min.js"></script>


</body>
</html>

