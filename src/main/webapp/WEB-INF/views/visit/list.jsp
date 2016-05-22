<%--
  Created by IntelliJ IDEA.
  User: ZhangSer
  Date: 2016/5/22
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" href="http://cdn.staticfile.org/twitter-bootstrap/2.3.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="http://cdn.staticfile.org/font-awesome/4.1.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="js/rangepicker/style.css">
    <link rel="stylesheet" href="http://cdn.staticfile.org/select2/3.4.8/select2.css">
    <link rel="stylesheet" href="http://cdn.staticfile.org/select2/3.4.8/select2-bootstrap.css">
    <link rel="stylesheet" href="/repo/css/style.css">
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
                        <input type="text" placeholder="姓名">
                        <input type="text" placeholder="电话">
                        <input type="text" id="rangepicker" placeholder="就诊时间">
                        <select name="" id="state">
                            <option value=""></option>
                            <option value="">就诊</option>
                            <option value="">已出院</option>
                        </select>
                        <button class="button button-flat-primary button-pill"><i class="fa fa-search"></i> 搜索</button>
                    </form>
                </div>
            </div>




            <div class="box">
                <div class="box-header">
                    <span class="title"><i class="fa fa-stethoscope"></i> 就诊列表</span>
                    <ul class="unstyled inline pull-right">
                        <li><a href="/visit/new.do"><i class="fa fa-plus"></i> 新建</a></li>
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
                            <th width="150">科室</th>
                            <th width="200">病种</th>
                            <th>初步诊断</th>
                            <th width="50">状态</th>
                            <th width="100">创建日期</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${page.items}" var="visit">
                            <tr>
                                <td>
                                    <input type="checkbox" name="" id="">
                                </td>
                                <td><a href="/visit/view.do?id=${visit.id}">${visit.paitent.name}</a></td>
                                <c:choose>
                                    <c:when test="${visit.paitent.sex == true}">
                                        <td>男</td>
                                    </c:when>
                                    <c:otherwise>
                                        <td>女</td>
                                    </c:otherwise>
                                </c:choose>
                                <td>${visit.dept.deptName}</td>
                                <td>${visit.disease.diseaseName}</td>
                                <td>${visit.chuzhen}</td>
                                <td>${visit.paitent.state}</td>
                                <td>${visit.nexttime}</td>
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
<script src="js/moment.min.js"></script>
<script src="js/rangepicker/rangepicker.js"></script>
<script src="http://cdn.staticfile.org/select2/3.4.8/select2.min.js"></script>
<script>
    $(function(){

        $("#rangepicker").daterangepicker(
                {
                    ranges: {
                        '今天': [new Date(), new Date()],
                        '昨天': [moment().subtract('days', 1), moment().subtract('days', 1)],
                        '最近7天': [moment().subtract('days', 6), new Date()],
                        '最近30天': [moment().subtract('days', 29), new Date()],
                        '本月': [moment().startOf('month'), moment().endOf('month')],
                        '上一月': [moment().subtract('month', 1).startOf('month'), moment().subtract('month', 1).endOf('month')]
                    },
                    opens: 'left',
                    format:'YYYY/MM/DD'
                },
                function(start,end,label){
                    console.log("start:" + start.format('YYYY-MM-DD'));
                    console.log("end:" + end.format('YYYY-MM-DD'));
                }

        );

        $("#state").select2({
            placeholder: "患者状态",
            width:'220px'
        });



    });
</script>

</body>
</html>