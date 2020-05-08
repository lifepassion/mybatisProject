<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<head>
    <%--    <link rel="stylesheet" href="lib/bootstrap-3.3.7-dist/css/bootstrap.min.css" >--%>
    <%--    <script src="lib/2.2.4/jquery-2.2.4.min.js"></script>--%>
    <%--    <script src="lib/bootstrap-3.3.7-dist/js/bootstrap.js"></script>--%>

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
            <p><a class="btn btn-primary btn-lg" href="/addUser.jsp" role="button">增加用户</a></p>
        </div>
    </div>
    <div class="row">
        <table class="table table-striped table-hover">
            <tr>
                <th>用户编号</th>
                <th>登陆账号</th>
                <th>用户昵称</th>
                <th>联系方式</th>
                <th>电子邮箱</th>
                <th>账号创建时间</th>
                <th>用户状态</th>
                <th>操作</th>

            </tr>
            <c:forEach var="user" items="${userList}">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.username}</td>
                    <td>${user.nickname}</td>
                    <td>${user.phone}</td>
                    <td>${user.email}</td>
                    <td><fmt:formatDate value="${user.createTime}" pattern="yyyy-MM-dd"></fmt:formatDate></td>
                    <c:if test="${user.userStatus==0}">
                        <td>正常</td>
                    </c:if>
                    <c:if test="${user.userStatus==1}">
                        <td>锁定</td>
                    </c:if>
                    <c:if test="${user.userStatus==2}">
                        <td>删除</td>
                    </c:if>

                    <td>
                        <a href="/detail.do?id=${user.id}">查看</a>
                        
                        <c:if test="${user.userStatus==0}">
                            <a href="/delUser.do?id=${user.id}&type=lock">锁定</a>
                        </c:if>
                        <c:if test="${user.userStatus==1}">
                            <a href="/delUser.do?id=${user.id}&type=unlock">解锁</a>
                        </c:if>
                        <a href="/delUser.do?id=${user.id}&type=del">删除</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>

</div>
</body>
</html>