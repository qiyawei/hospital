<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                    <span class="title"><i class="fa fa-bars"></i> 医保类型列表</span>
                    <ul class="unstyled inline pull-right">
                        <li><a href="/insur/new.do"><i class="fa fa-plus"></i> 新建</a></li>
                    </ul>
                </div>
                <div class="box-body">
                    <table class="table">
                        <thead>
                        <tr>
                            <th width="200">医保类型名称</th>
                            <th>#</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${insuranceList}" var="insur">
                        <tr>
                            <th>${insur.insurName}</th>
                            <th>
                                <a href="/insur/edit.do?id=${insur.id}">修改</a>
                                <a href="javascript:;" data="${insur.id}" id="delLink">删除</a>
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
    $(function(){
        $(document).delegate("#delLink","click",function(){
            var id = $(this).attr("data");
            if(confirm("确定要删除该数据吗?")) {
                location.href = "/insur/del.do?id="+id;
            }
        });
    })
</script>
</body>
</html>
