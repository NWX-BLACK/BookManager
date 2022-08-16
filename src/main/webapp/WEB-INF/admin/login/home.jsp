<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="top.jsp"%>
<%--<%@ include file="welcome.jsp"%>
<%@ include file="left.jsp"%>--%>
<%--<%@ include file="bottom.jsp"%>--%>
<html>
	<head>
        <title>菜单</title>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="${pageContext.request.contextPath}/static/admin/css/Style.css" type="text/css" rel="stylesheet" />
        <link href="${pageContext.request.contextPath}/static/admin/css/left.css" rel="stylesheet" type="text/css">

        <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

        <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->

        <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>

        <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->

        <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

  </head>
<body>

<div class="container-fluid">
    <div class="row" style="height: 76%">
        <div class="col-md-2"  style="border-right: 2px solid black;height: 100% ;background-color: #E6E6E6;margin: 0px;text-align:left;">
            <table width="100" border="0" cellspacing="0" cellpadding="0">
                <tr>
                    <td height="12"></td>
                </tr>
            </table>
            <table width="100%" border="0">
                <tr>
                    <td style="font-size:20px;line-height:20px;">
                        <div class="span12">
                            <div class="row-fluid">
                                <div class="span4">
                                </div>
                                <div class="span4">
                                    <ul class="nav nav-list well" style="background-color: #E6E6E6;color:#303030;">
                                        <li class="active">
                                            <a href="/login/home" style="font-size: 14px">首页</a>
                                        </li>
                                        <li>
                                            <a href="/products/list/page/1" style="font-size: 14px">显示所有书籍</a>
                                        </li>
                                        <li>
                                            <a href="/products/add" style="font-size: 14px">添加书籍</a>
                                        </li>
                                        <li>
                                            <a href="#" style="font-size: 14px">设置</a>
                                        </li>
                                        <li class="divider">
                                        </li>
                                        <li>
                                            <a href="#" style="font-size: 14px">帮助</a>
                                        </li>
                                    </ul>
                                </div>
                                <div class="span4">
                                </div>
                            </div>
                        </div>
                    </td>
                </tr>
            </table>
        </div>
        <div class="col-md-10">
            <div class="row">
                <table width="100%" border="0" height="20" background="${pageContext.request.contextPath}/static/admin/images/back1.JPG">
                    <tr>
                        <td colspan=3 class="ta_01" align="center" bgcolor="#afd1f3"><strong>系统首页</strong></td>
                    </tr>
                    <tr><td height=2></td></tr>
                    <tr align="center">
                        <td width="100%" height="84" align="center" >
                            <span class="Style1">登录成功！</span>
                        </td>
                    </tr>

                    <tr><td height=2></td></tr>
                </table>
            </div>
        </div>

    </div>
</div>
<jsp:include page="bottom.jsp"></jsp:include>
</body>

</html>
