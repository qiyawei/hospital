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
              <i class="fa fa-info"></i>
              <a href="/patient/list.do"> 患者列表</a>  /  患者基本信息
            </span>
                    <ul class="unstyled inline pull-right">
                        <li><a href="/paitent/edit.do?id=${paitent.id}"><i class="fa fa-edit"></i> 修改</a></li>
                        <li><a href="javascript:;" id="delLink" data="${paitent.id}"><i class="fa fa-times"></i> 删除</a></li>
                    </ul>
                </div>
                <div class="box-body">
                    <table class="table">
                        <tbody>
                        <tr>
                            <td width="100"><strong>姓名</strong></td>
                            <td width="300">${paitent.name}</td>
                            <td width="100"><strong>性别</strong></td>
                            <td width="300">男</td>
                            <td width="100"><strong>年龄</strong></td>
                            <td width="">${paitent.age}</td>
                        </tr>
                        <tr>
                            <td><strong>身份证号</strong></td>
                            <td>${paitent.card}</td>
                            <td><strong>联系电话</strong></td>
                            <td>${paitent.tel}</td>
                            <td><strong>医保类型</strong></td>
                            <td>${paitent.insurance.insurName}</td>
                        </tr>
                        <tr>
                            <td><strong>地址</strong></td>
                            <td colspan="5">${paitent.address}</td>
                        </tr>
                        <tr>
                            <td colspan="6"><strong>过敏史</strong></td>
                        </tr>
                        <tr>
                            <td colspan="6">
                                ${paitent.allergy}
                            </td>
                        </tr>
                        <tr>
                            <td colspan="6"><strong>备注</strong></td>
                        </tr>
                        <tr>
                            <td colspan="6">${paitent.text}</td>
                        </tr>
                        </tbody>

                    </table>
                </div>
            </div>
            <!-- box end -->
            <div class="box">
                <div class="box-header">
                    <span class="title"><i class="fa fa-stethoscope"></i> 就诊记录</span>
                </div>
                <div class="box-body">
                    <table class="table">
                        <thead>
                        <tr>
                            <th width="100">日期</th>
                            <th width="150">科室</th>
                            <th width="200">病种</th>
                            <th>初步诊断</th>
                            <th width="50"></th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="paitent.visitList" var="visit">
                            <tr>

                                <td>${visit.createtime}</td>
                                <td>${visit.dept.deptName}</td>
                                <td>${visit.disease.diseaseName}</td>
                                <td>${visit.zhengzhuang}</td>--%>
                                <td>
                                    <a href="/visit/view.do?id=${visit.id}">详情</a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>

                </div>
            </div>
            <!-- box end -->
        </div>

    </div>
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
                location.href = "/paitent/del.do?id="+id;
            }
        });


    });
</script>


</body>
</html>
