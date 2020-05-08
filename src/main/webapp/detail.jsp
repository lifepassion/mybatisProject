<%--
  Created by IntelliJ IDEA.
  User: passionlife
  Date: 2020/5/6
  Time: 17:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">


    <link rel="stylesheet" href="webjars/bootstrap/3.3.5/css/bootstrap.min.css">
    <script src="webjars/jquery/1.11.1/jquery.min.js"></script>
    <script src="webjars/bootstrap/3.3.5/js/bootstrap.min.js"></script>

    <title>用户管理中心</title>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="page-header">
            <h1><a href="/index.do">自学网管理系统</a>   <small>用户数据管理</small></h1>
        </div>
    </div>
    <div class="row">
        <div class="jumbotron">
            <h1>Mybatis基础入门课程</h1>
            <p>通过一个项目完成基础部分的学习</p>
            <p><a class="btn btn-primary btn-lg" href="#" role="button">查看更多请上自学网</a></p>
        </div>
    </div>
    <div class="row">
        <div class="col-md-8 col-md-offset-2">
             <c:set var="user" value="${user}"></c:set>
            <form class="form-horizontal" action="/updateUser.do" method="post">
                <input type="hidden" name="id" value="${user.id}">
                <div class="form-group">
                    <label class="col-sm-2 control-label">用户账号</label>
                    <div class="col-sm-10">
                        <p class="form-control-static">${user.username}</p>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">登陆密码</label>
                    <div class="col-sm-10">
                        <p class="form-control-static">*********</p>
                    </div>
                </div>
                <div class="form-group">
                    <label for="nickname" class="col-sm-2 control-label">昵称</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="nickname" name="nickname" value="${user.nickname}" >
                    </div>
                </div>
                <div class="form-group">
                    <label for="age" class="col-sm-2 control-label">年龄</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="age" name="age" value="${user.age}" placeholder="${user.age}">
                    </div>
                </div>
                <div class="form-group">
                    <label for="gender" class="col-sm-2 control-label">性别</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="gender" name="gender" value="${user.gender}" placeholder="${user.gender}">
                    </div>
                </div>
                <div class="form-group">
                    <label for="phone" class="col-sm-2 control-label">联系方式</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="phone" name="age" value="${user.age}" placeholder="${user.phone}">
                    </div>
                </div>
                <div class="form-group">
                    <label for="email" class="col-sm-2 control-label">邮箱</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="email" name="email" value="${user.email}" placeholder="${user.email}">
                    </div>
                </div>

                <div class="form-group">
                    <label for="remark" class="col-sm-2 control-label">备注</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="remark" name="remark" value="${user.remark}" placeholder="${user.remark}">
                    </div>
                </div>

                <c:if test="${user.userStatus==0}">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">用户状态</label>
                        <div class="col-sm-10">
                            <p class="form-control-static">正常</p>
                        </div>
                    </div>
                </c:if>
                <c:if test="${user.userStatus==1}">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">用户状态</label>
                        <div class="col-sm-10">
                            <p class="form-control-static">锁定</p>
                        </div>
                    </div>
                </c:if>
                <c:if test="${user.userStatus==2}">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">用户状态</label>
                        <div class="col-sm-10">
                            <p class="form-control-static">删除</p>
                        </div>
                    </div>
                </c:if>

                <div class="form-group">
                    <label class="col-sm-2 control-label">账号创建时间</label>
                    <div class="col-sm-10">
                        <p class="form-control-static">
                            <fmt:formatDate value="${user.createTime}" pattern="yyyy-MM-dd"></fmt:formatDate>
                        </p>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">最后修改时间</label>
                    <div class="col-sm-10">
                        <p class="form-control-static">
                            <fmt:formatDate value="${user.updateTime}" pattern="yyyy-MM-dd"></fmt:formatDate>
                        </p>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">最后登陆时间</label>
                    <div class="col-sm-10">
                        <p class="form-control-static">
                            <fmt:formatDate value="${user.lastLogin}" pattern="yyyy-MM-dd"></fmt:formatDate>
                        </p>
                    </div>
                </div>

                <button type="submit" class="btn btn-primary">提交</button>

            </form>

        </div>



    </div>



</div>
</body>
</html>
