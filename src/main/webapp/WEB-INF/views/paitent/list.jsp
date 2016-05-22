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
                    <span class="title">搜索</span>
                </div>
                <div class="box-body search-box">
                    <form action="" class="form-search">
                        <input type="text" placeholder="姓名" name="q_s_eq_name" value="${q_s_eq_name}">
                        <input type="text" placeholder="身份证号"name="q_s_eq_card"value="${q_s_eq_card}">
                        <input type="text" placeholder="电话"name="q_s_eq_tel" value="${q_s_eq_tel}">
                        <button class="button button-flat-primary button-pill"><i class="fa fa-search"></i> 搜索</button>
                    </form>
                </div>
            </div>




            <div class="box">
                <div class="box-header">
                    <span class="title"><i class="fa fa-building"></i> 患者列表</span>
                    <ul class="unstyled inline pull-right">
                        <li><a href="/paitent/new.do"><i class="fa fa-plus"></i> 新建</a></li>
                    </ul>
                </div>
                <div class="box-body">
                    <table class="table">
                        <thead>
                        <tr>
                            <th width="20">
                                <input type="checkbox" name="" id="">
                            </th>
                            <th width="100">姓名</th>
                            <th width="50">性别</th>
                            <th width="150">电话</th>
                            <th width="200">医保类型</th>
                            <th>地址</th>
                            <th width="50">状态</th>
                            <th width="100">创建日期</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${page.items}" var="p">
                        <tr>
                            <td>
                                <input type="checkbox" name="" id="">
                            </td>
                            <td><a href="/paitent/view.do?id=${p.id}">${p.name}</a></td>
                            <c:choose>
                                <c:when test="${p.sex == '1'}">
                                    <td>男</td>
                                </c:when>
                                <c:otherwise>
                                    <td>女</td>
                                </c:otherwise>
                            </c:choose>
                            
                            <td>${p.tel}</td>
                            <td>${p.insurance.insurName}</td>
                            <td>${p.address}</td>
                            <td>${p.state}</td>
                            <td>${p.createtime}</td>
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


        $(document).delegate("#delLink","click",function(){
            var id = $(this).attr("data");
            if(confirm("确定要删除该数据吗?")) {
                location.href = "/disease/del.do?id="+id;
            }
        });


        $("#page_demo").twbsPagination({
            totalPages:${page.totalPages},
            visiblePages:5,
            first:'首页',
            last:'末页',
            prev:'上一页',
            next:'下一页',
            href:"?pageNo={{number}}&q_s_eq_name="+encodeURIComponent('${requestScope['q_s_eq_name']}')+"&q_i_eq_card=" +encodeURIComponent("${requestScope['q_i_eq_tel']}")
        });


    });
</script>

</body>
</html>