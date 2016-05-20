<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" href="http://cdn.staticfile.org/twitter-bootstrap/2.3.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="http://cdn.staticfile.org/font-awesome/4.1.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="http://cdn.staticfile.org/select2/3.4.8/select2.css">
    <link rel="stylesheet" href="http://cdn.staticfile.org/select2/3.4.8/select2-bootstrap.css">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<%@include file="../include/navbar.jsp"%>
<div class="container-fluid">
    <div class="row-fluid">
        <div class="span12">

            <div class="box">
                <div class="box-header">
                    <span class="title"><i class="fa fa-search"></i> 搜索</span>
                </div>
                <div class="box-body search-box">
                    <form action="" class="form-search">
                        <input type="text" placeholder="疾病名称">
                        <select id="ks" name="q_i_eq_type.id">
                            <option>请选择科室</option>
                            <c:forEach items="${deptList}" var="dept">
                                 <option value="${dept.id}">${dept.deptName}</option>
                            </c:forEach>

                        </select>
                        <button class="button button-pill button-flat-primary"><i class="fa fa-search"></i> 搜索</button>
                    </form>

                </div>
            </div>


            <div class="box">
                <div class="box-header">
                    <span class="title"><i class="fa fa-medkit"></i> 病种列表</span>
                    <ul class="unstyled inline pull-right">
                        <li><a href="new-disease.html"><i class="fa fa-plus"></i> 新建</a></li>
                    </ul>
                </div>
                <div class="box-body">
                    <table class="table">
                        <thead>
                        <tr>
                            <th width="200">疾病名称</th>
                            <th width="200">所属科室</th>
                            <th>#</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${page.items}" var="disease">
                        <tr>
                            <th>${disease.diseaseName}</th>
                            <th>${disease.dept.deptName}</th>
                            <th>
                                <a href="/disease/edit.do?id=${disease.id}">修改</a>
                                <a href="javascript:;" id="delLink" data="${disease.id}">删除</a>
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
<script src="http://cdn.staticfile.org/select2/3.4.8/select2.min.js"></script>
<script>
    $(function(){
        $("#ks").select2({
            placeholder: "请选择科室",
            width:'200px'
        });
    });
</script>


</body>
</html>