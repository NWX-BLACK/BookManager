<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="top.jsp"%>

<html>
	<head>
        <title>菜单</title>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="${pageContext.request.contextPath}/static/admin/css/Style.css" type="text/css" rel="stylesheet" />
        <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

  </head>
<body>

<div class="container-fluid">
    <div class="row" style="height: 76%">
        <div class="col-md-2"  style="border-right: 2px solid black;height: 100% ;background-color: #E6E6E6;margin: 0px;text-align:left;">
              <%@ include file="left.jsp"%>
<%--          <jsp:include page="left.jsp"></jsp:include>--%>
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

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>
</html>
