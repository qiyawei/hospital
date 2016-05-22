<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" href="http://cdn.staticfile.org/twitter-bootstrap/2.3.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="http://cdn.staticfile.org/font-awesome/4.1.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="js/simditor/styles/simditor.css">
    <link rel="stylesheet" href="http://cdn.staticfile.org/select2/3.4.8/select2.css">
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
              <a href="patient-list.html"> 患者列表</a>  /  新增患者
            </span>
                </div>
                <div class="box-body form">
                    <form action="/paitent/save.do" method="post">
                        <label>姓名</label>
                        <input type="text" name="paitent.name">
                        <label>性别</label>
                        <select name="paitent.sex" id="">
                            <option value="1">男</option>
                            <option value="0">女</option>
                        </select>
                        <label>身份证号</label>
                        <input type="text" name="paitent.card">
                        <label>年龄</label>
                        <input type="text" name="paitent.age" >
                        <label>电话</label>
                        <input type="text" name="paitent.tel">
                        <label>医保类型</label>
                        <select name="paitent.insurance.id" id="yb">
                            <option value="">请选择医保类型</option>
                            <c:forEach items="${insuranceList}" var="insur">
                                <option value="${insur.id}">${insur.insurName}</option>
                            </c:forEach>
                        </select>
                        <label>住址</label>
                        <input type="text" name="paitent.address">
                        <label>过敏史</label>
                        <textarea  class="editor1" style="height:50px" name="paitent.allergy"></textarea>
                        <label>备注</label>
                        <textarea  class="editor2" name="paitent.text"></textarea>
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
<script src="js/simditor/scripts/js/simditor-all.min.js"></script>
<script src="http://cdn.staticfile.org/select2/3.4.8/select2.min.js"></script>
<script>
    $(function(){

        var editor = new Simditor({
            toolbar:['title','bold','italic','underline','strikethrough','ol','ul','blockquote','table','link','hr','indent','outdent'],
            textarea: $('.editor1')
        });
        var editor2 = new Simditor({
            toolbar:['title','bold','italic','underline','strikethrough','ol','ul','blockquote','table','link','hr','indent','outdent'],
            textarea: $('.editor2')
        });
        $("#yb").select2({
            placeholder: "请选择医保类型",
            width:'220px'
        });

    });
</script>

</body>
</html>
