<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/7/19
  Time: 18:30
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>删除用户</title>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <!-- 在bootstrap.min.js 之前引入 -->

    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <style type="text/css">
        body {
            background-repeat: no-repeat;
            background-position: 0 center;

        }
        .container {
            /* height: 500px;
            line-height: 500px; */
        }
        .row-centered {

            text-align: center;
            border: 1px solid #5E5E5E;
            border-radius: 20px;
            vertical-align: middle;
            position: relative;
            padding: 5px;
            transform: translateY(50%);
        }
        .col-xs-4 {
            height: 60px;
            line-height: 60px;
        }
    </style>
</head>
<body >

<div class="container">
    <div class="row " style="text-align: center; vertical-align: middle;">
        <div class="col-md-4 row-centered col-md-offset-4">
            <h2 style="font-style: inherit;">请输入密码注销用户</h2>
            <p></p>
            <div>
                <form class="form-horizontal" action="/deleteUser" method="post">
                    <c:if test="${error != null}">
                        <p style="color: red">${error}</p>
                    </c:if>
                    <div class="form-group has-feedback">
                        <label class="control-label sr-only">用户名</label>
                        <div class="col-xs-8 col-xs-offset-2">
                            <input class="form-control" type="text" readonly="readonly" name="userName" value="<%=session.getAttribute("loginUser")%>"/>
                        </div>
                    </div>

                    <div class="form-group has-feedback">
                        <label class="control-label sr-only">密码</label>
                        <div class="col-xs-8 col-xs-offset-2">
                            <input class="form-control" type="password" name="passWord" placeholder="请输入密码" required/>
                            <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                        </div>
                    </div>

                    <div class="form-group has-feedback">
                        <div class="col-xs-8 col-xs-offset-2 ">
                            <div class="row">
                                <div class="col-xs-6" >
                                    <button type="submit" class="btn btn-primary btn-block">注销</button>
                                </div>
                                <div class="col-xs-6">
                                    <button type="button" class="btn btn-primary btn-block" onclick="history.go(-1)">返回</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

</body>
</html>


