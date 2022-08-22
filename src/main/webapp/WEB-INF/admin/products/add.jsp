<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../login/top.jsp"%>
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
            <jsp:include page="../login/left.jsp"></jsp:include>
        </div>
        <div class="col-md-10">
            <div class="row">
                <table width="100%" border="0" height="20" background="${pageContext.request.contextPath}/static/admin/images/back1.JPG">
                    <tr>
                        <td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
                            height="26"><strong><STRONG>添加商品</STRONG> </strong>
                        </td>
                    </tr>
                    <tr><td height=2></td></tr>
                    <tr align="center">
                        <td width="100%" height="84" align="center" >
                            <form id="userAction_save_do" name="Form1" action="/servlet/toAdd" method="get"<%--enctype="multipart/form-data">--%>>
                                &nbsp;
                                <table cellSpacing="1" cellPadding="5" width="100%" align="center"
                                       bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
                                    <tr>
                                        <td align="center" bgColor="#f5fafe" class="ta_01">商品名称：</td>
                                        <td class="ta_01" bgColor="#ffffff"><input type="text" name="name" class="bg"/></td>
                                        <td align="center" bgColor="#f5fafe" class="ta_01">商品价格：</td>
                                        <td class="ta_01" bgColor="#ffffff"><input type="text" name="price" class="bg" /></td>
                                    </tr>
                                    <tr>
                                        <td align="center" bgColor="#f5fafe" class="ta_01">商品数量：</td>
                                        <td class="ta_01" bgColor="#ffffff"><input type="text" name="pnum" class="bg" /></td>
                                        <td align="center" bgColor="#f5fafe" class="ta_01">商品类别：</td>
                                        <td class="ta_01" bgColor="#ffffff"><select name="category" id="category">
                                            <option value="" selected="selected">--选择商品类加--</option>
                                            <option value="文学">文学</option>
                                            <option value="生活">生活</option>
                                            <option value="计算机">计算机</option>
                                            <option value="外语">外语</option>
                                            <option value="经营">经营</option>
                                            <option value="励志">励志</option>
                                            <option value="社科">社科</option>
                                            <option value="学术">学术</option>
                                            <option value="少儿">少儿</option>
                                            <option value="艺术">艺术</option>
                                            <option value="原版">原版</option>
                                            <option value="科技">科技</option>
                                            <option value="考试">考试</option>
                                            <option value="生活百科">生活百科</option>
                                        </select>
                                        </td>
                                    </tr>

                                    <tr>
                                        <td align="center" bgColor="#f5fafe" class="ta_01">商品图片：</td>
                                        <td class="ta_01" bgColor="#ffffff" colSpan="3">
                                            <input
                                                    type="file" name="upload" size="30" value=""/>
                                        </td>
                                    </tr>
                                    <TR>
                                        <TD class="ta_01" align="center" bgColor="#f5fafe">商品描述：</TD>
                                        <TD class="ta_01" bgColor="#ffffff" colSpan="3">
				<textarea
                        name="description" cols="30" rows="3"
                        style="WIDTH: 96%"></textarea>
                                        </TD>
                                    </TR>
                                    <TR>
                                        <td align="center" colSpan="4" class="sep1"><img
                                                src="${pageContext.request.contextPath}/static/admin/images/shim.gif">
                                        </td>
                                    </TR>

                                    <tr>
                                        <td class="ta_01" style="WIDTH: 100%" align="center"
                                            bgColor="#f5fafe" colSpan="4">
                                            <input type="submit" class="button_ok" value="确定">
                                            <FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
                                            <input type="reset" value="重置" class="button_cancel">
                                            <FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
                                            <input class="button_ok" type="button" onclick="history.go(-1)" value="返回" />
                                            <span id="Label1">
					</span>
                                        </td>
                                    </tr>
                                </table>
                            </form>
                        </td>
                    </tr>

                    <tr><td height=2></td></tr>
                </table>
            </div>
        </div>

    </div>
</div>
<jsp:include page="../login/bottom.jsp"></jsp:include>
</body>

</html>
