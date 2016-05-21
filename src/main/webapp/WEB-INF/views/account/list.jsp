<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" href="http://cdn.staticfile.org/twitter-bootstrap/2.3.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="http://cdn.staticfile.org/font-awesome/4.1.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="/repo/css/style.css">
</head>
<body>
<%@include file="../include/navbar.jsp"%>
<div class="container-fluid">
    <div class="row-fluid">
        <div class="span12">

            <div class="box">
                <div class="box-header">
                    <span class="title"><i class="fa fa-user-md"></i> 系统账号列表</span>
                    <ul class="unstyled inline pull-right">
                        <li><a href="/account/new.do"><i class="fa fa-plus"></i> 新建</a></li>
                    </ul>
                </div>
                <div class="box-body">
                    <table class="table">
                        <thead>
                        <tr>
                            <th width="200">账户名称</th>
                            <th width="200">员工姓名</th>
                            <th>电话</th>
                            <th>最后登录时间</th>
                            <th>最后登录IP</th>
                            <th>账号状态</th>
                            <th>#</th>
                        </tr>
                        </thead>
                        <tbody>
                      <c:forEach items="${page.items}" var="account">
                        <tr>
                            <td>${account.loginName}</td>
                            <td>${account.accountName}</td>
                            <td>${account.accountTel}</td>
                            <td>${account.logintime}2014-07-09 12:34</td>
                            <td>${account.loginIp}</td>
                            <c:choose>
                                <c:when test="${account.state == '禁用'}">
                                    <td><span class="label label-important">${account.state}</span></td>
                                </c:when>
                                <c:otherwise>
                                    <td>${account.state}</td>
                                </c:otherwise>
                            </c:choose>

                            <td>
                                <a href="/account/edit.do?id=${account.id}">修改</a>
                                <a href="/account/locked.do?id=${account.id}">禁用</a>
                                <a href="/account/del.do?id=${account.id}">删除</a>
                            </td>
                        </tr>
                      </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>


        </div>

    </div>
</div>

<div class="pagination pull-right">
    <ul id="page_demo"></ul>
</div>


<script src="http://cdn.staticfile.org/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.staticfile.org/twitter-bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="/repo/js/jquery-1.11.3.min.js"></script>
<script src="/repo/js/jquery.twbsPagination.min.js"></script>
<script>
    $(function(){
        $("#page_demo").twbsPagination({
            totalPages:${page.totalPages},
            visiblePages:5,
            first:'首页',
            last:'末页',
            prev:'上一页',
            next:'下一页',
            href:'?pageNo={{number}}'
        });
    });
</script>

</body>
</html>