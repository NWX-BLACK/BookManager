<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
BODY {
	MARGIN: 0px;
	BACKGROUND-COLOR: #ffffff
}

BODY {
	FONT-SIZE: 12px;
	COLOR: #000000
}

TD {
	FONT-SIZE: 12px;
	COLOR: #000000
}

TH {
	FONT-SIZE: 12px;
	COLOR: #000000
}
</style>
<link href="${pageContext.request.contextPath}/static/admin/css/Style.css"
	rel="stylesheet" type="text/css">
	<link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

	<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->

	<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>

	<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->

	<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script type="text/javascript">
	function exitSys() {
		var flag = window.confirm("确认退出系统吗?");
		if (flag) {
			window.top.open('', '_parent', '');
			window.top.close();
			window.location.href = "/toLogin";
		}
		//如果你使用的是firefox浏览器必须要做以下设置 
		//1、在地址栏输入about:config然后回车，警告确认 
		//2、在过滤器中输入”dom.allow_scripts_to_close_windows“，双击即可将此值设为true 即可完成了
	}
</script>
</HEAD>
<body>
	<table width="100%" height="10%" border="0" cellspacing="0"
		cellpadding="0">
		<tr>
			<td><img width="100%"
				src="${pageContext.request.contextPath}/static/admin/images/top_01.jpg">
			</td>

			<td width="100%"
				background="${pageContext.request.contextPath}/static/admin/images/top_11.png">
			</td>
		</tr>
	</table>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td height="30" valign="bottom"
				background="${pageContext.request.contextPath}/static/admin/images/mis_01.jpg">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td width="85%" align="left">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <font color="#000000">
								<script language="JavaScript">
								<!--
									tmpDate = new Date();
									date = tmpDate.getDate();
									month = tmpDate.getMonth() + 1;
									year = tmpDate.getFullYear();
									document.write(year);
									document.write("年");
									document.write(month);
									document.write("月");
									document.write(date);
									document.write("日 ");

									myArray = new Array(6);
									myArray[0] = "星期日"
									myArray[1] = "星期一"
									myArray[2] = "星期二"
									myArray[3] = "星期三"
									myArray[4] = "星期四"
									myArray[5] = "星期五"
									myArray[6] = "星期六"
									weekday = tmpDate.getDay();
									if (weekday == 0 | weekday == 6) {
										document.write(myArray[weekday])
									} else {
										document.write(myArray[weekday])
									};
								// -->
								</script>
						</font>
						</td>
						<td width="8%">
							用户：<%=session.getAttribute("loginUser")%>
						</td>
                        <td width="5%" align="right">
                            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                <tr>
                                    <td width="8"
                                        background="${pageContext.request.contextPath}/static/admin/images/mis_05b.jpg">
                                        <img
                                                src="${pageContext.request.contextPath}/static/admin/images/mis_05a.jpg"
                                                width="3" height="18">
                                    </td>
                                    <td width="100" valign="bottom center" align="center"
                                        background="${pageContext.request.contextPath}/static/admin/images/mis_05b.jpg">
                                       <a href="javascript:void(0)" onclick="exitSys()" style="border: soild">退出系统</a>
									</td>
                                    <td width="8" align="right"
                                        background="${pageContext.request.contextPath}/static/admin/images/mis_05b.jpg">
                                        <img
                                                src="${pageContext.request.contextPath}/static/admin/images/mis_05c.jpg"
                                                width="3" height="18">
                                    </td>
                                </tr>
                            </table>
                        </td>
						<td align="right" width="5%"></td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</body>
</HTML>
