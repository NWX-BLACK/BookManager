<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/7/19
  Time: 18:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>登陆</title>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <!--font-awesome 核心我CSS 文件-->
    <link href="//cdn.bootcss.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
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

    <script type="text/javascript">
        function locationRef() {
            window.location.href = "/toRegister";
        }
    </script>
</head>
<body >

<div class="container">
    <div class="row " style="text-align: center; vertical-align: middle;">
        <div class="col-md-4 row-centered col-md-offset-4">
            <h2 style="font-style: inherit;">欢迎登陆</h2>
            <p></p>
            <div>
                <c:if test="${msg != null}">
                    <p style="color: red">${msg}</p>
                </c:if>
                <form class="form-horizontal" action="/login/toHome" method="get">
                    <div class="form-group has-feedback">
                        <label class="control-label sr-only">用户名</label>
                        <div class="col-xs-8 col-xs-offset-2">
                            <input type="text" class="form-control" name="userName"  value="${userName}" placeholder="请输入用户名" />
                            <span class="glyphicon glyphicon-user form-control-feedback"></span>
                        </div>
                    </div>
                    <div class="form-group has-feedback">
                        <label class="control-label sr-only">密码</label>
                        <div class="col-xs-8 col-xs-offset-2">
                            <input class="form-control" type="password" name="passWord" id="" value="${passWord}" placeholder="请输入密码" />
                            <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                        </div>
                    </div>

                    <div class="form-group has-feedback">
                        <div class="col-xs-8 col-xs-offset-2 ">
                            <div class="row">
                                <div class="col-xs-8">
                                    <input class="form-control" type="text"  name="verifyCode" placeholder="请输入验证码" />
                                </div>
                                <div class="col-xs-4" style="height: 34px; padding-left: 0px">
                                    <div  style="border: 1px solid; border-radius: 2px; height: 34px;alignment: center;line-height: 30px">${verifyCode}</div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="form-group has-feedback">
                        <div class="col-xs-8 col-xs-offset-2">
                            <div class="row">
                                <div class="col-xs-6 left-arrow">
                                    <input  type="checkbox" name="remember" value="yes" ${ischecked}> Remember
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="form-group has-feedback">
                        <div class="col-xs-8 col-xs-offset-2 ">
                            <div class="row">
                                <div class="col-xs-6" >
                                    <button type="submit" class="btn btn-primary btn-block">登陆</button>
                                </div>
                                <div class="col-xs-6">
                                    <button type="button" class="btn btn-primary btn-block" onclick="locationRef()">注册</button>
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


