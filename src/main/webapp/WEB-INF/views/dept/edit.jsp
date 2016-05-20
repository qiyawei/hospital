<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <span class="title">
              <i class="fa fa-plus"></i>
              <a href="dept-list.html"> 科室列表</a>  /  新增科室
            </span>
                </div>
                <div class="box-body form">
                    <form action="/dept/update.do" method="post">
                        <input type="hidden" name="dept.id" value="${dept.id}">
                        <label>科室名称</label>
                        <input type="text" name="dept.deptName" value="${dept.deptName}">
                        <label>负责人</label>
                        <input type="text" name="dept.manager" value="${dept.manager}">
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
