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
                    <span class="title"><i class="fa fa-sitemap"></i> 科室列表</span>
                    <ul class="unstyled inline pull-right">
                        <li><a href="/dept/new.do"><i class="fa fa-plus"></i> 新建</a></li>
                    </ul>
                </div>
                <div class="box-body">
                    <table class="table">
                        <thead>
                        <tr>
                            <th width="200">科室名称</th>
                            <th width="200">负责人</th>
                            <th>#</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${deptList}" var="dept">
                        <tr>
                            <th>${dept.deptName}</th>
                            <th>${dept.manager}</th>
                            <th>
                                <a href="/dept/edit.do?id=${dept.id}">修改</a>
                                <a href="javascript:;" data="${dept.id}" id="delLink">删除</a>
                            </th>
                        </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>


        </div>

    </div>
</div>



<script src="http://cdn.staticfile.org/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.staticfile.org/twitter-bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="/repo/js/jquery-1.11.3.min.js"></script>
<script>
    $(document).delegate("#delLink","click",function(){
        var id = $(this).attr("data");
        if(confirm("确定要删除该数据吗?")) {
             location.href = "/dept/del.do?id="+id;
        }
    });
</script>
</body>
</html>