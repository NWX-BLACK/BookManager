<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--<%@ include file="../login/top.jsp"%>--%>
<html>
<head>
    <title>显示</title>
    <meta http-equiv="Content-Language" content="zh-cn">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="${pageContext.request.contextPath}/static/admin/css/Style.css" rel="stylesheet" type="text/css" />
    <link href="${pageContext.request.contextPath}/static/admin/css/left.css" rel="stylesheet" type="text/css">
    <script language="javascript" src="${pageContext.request.contextPath}/static/admin/js/public.js"></script>

    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->

    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->

    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script type="text/javascript">
        //设置类别的默认值
        function setProductCategory(t) {
            var category = document.getElementById("category");//根据id获取下拉列表元素
            var ops = category.options;//获取所有的下拉选项数组
            for ( var i = 0; i < ops.length; i++) {//遍历数组，找到书籍所属标签对应的下拉选项
                if (ops[i].value == t) {
                    ops[i].selected = true;//将该选项设置为选中
                    return;
                }
            }
        };
    </script>
</head>

<body onload="setProductCategory('${bookc.category}')">
<jsp:include page="../login/top.jsp"></jsp:include>
<div class="container-fluid">
    <div class="row" style="height: 76%">
        <div class="col-md-2"  style="border-right: 2px solid black;height: 100% ;background-color: #E6E6E6;margin: 0px;text-align:left;">
            <jsp:include page="../login/left.jsp"></jsp:include>
        </div>
        <div class="col-md-10" style="height: 95%">
            <div class="row">
                <table width="100%" border="0" height="20" background="${pageContext.request.contextPath}/static/admin/images/back1.JPG">
                    <tr>
                        <td colspan=3 class="ta_01" align="center" bgcolor="#afd1f3"><strong>查询条件</strong></td>
                    </tr>
                    <tr><td height=2></td></tr>
                    <tr align="center">
                        <form id="Form1" name="Form1"
                              action="/servlet/findProductByManyCondition/true"
                              method="get">
                            <table cellSpacing="1" cellPadding="0" width="100%" align="center"
                                   bgColor="#f5fafe" border="0">
                                <tbody>
                                <tr>
                                    <td>
                                        <table cellpadding="0" cellspacing="0" border="0" width="100%">
                                            <tr>
                                                <td height="22" align="center" bgColor="#f5fafe" class="ta_01">
                                                    商品编号：</td>
                                                <td class="ta_01" bgColor="#ffffff">
                                                    <input type="text" name="id" size="15" value="${bookc.id}" id="Form1_userName" class="bg" />
                                                </td>
                                                <td height="22" align="center" bgColor="#f5fafe" class="ta_01">
                                                    类别：</td>
                                                <td class="ta_01" bgColor="#ffffff">
                                                    <select name="category"	id="category">
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
                                                <td height="22" align="center" bgColor="#f5fafe" class="ta_01">
                                                    商品名称：</td>
                                                <td class="ta_01" bgColor="#ffffff">
                                                    <input type="text" name="name" size="15" value="${bookc.name}" id="Form2_userName" class="bg" />
                                                </td>
                                                <td height="22" align="center" bgColor="#f5fafe" class="ta_01">
                                                    价格区间(元)：</td>
                                                <td class="ta_01" bgColor="#ffffff">
                                                    <input type="text" name="minprice" size="10" value="${bookc.minprice}" /> ---
                                                    <input type="text" name="maxprice" size="10" value="${bookc.maxprice}" /></td>
                                            </tr>

                                            <tr>
                                                <td width="100" height="22" align="center" bgColor="#f5fafe"
                                                    class="ta_01"></td>
                                                <td class="ta_01" bgColor="#ffffff"><font face="宋体"
                                                                                          color="red"> &nbsp;</font>
                                                </td>
                                                <td align="right" bgColor="#ffffff" class="ta_01"><br>
                                                    <br></td>
                                                <td align="right" bgColor="#ffffff" class="ta_01">
                                                    <button type="submit" id="search" name="search"
                                                            value="&#26597;&#35810;" class="button_view">
                                                        &#26597;&#35810;</button> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                    <input type="reset" name="reset" value="&#37325;&#32622;" class="button_view" />
                                                </td>
                                            </tr>
                                        </table>
                                    </td>

                                </tr>
                                <tr>
                                    <td class="ta_01" align="center" bgColor="#afd1f3"><strong>商品列表</strong>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="ta_01" align="center" bgColor="#f5fafe">
                                        <table cellspacing="0" cellpadding="1" rules="all"
                                               bordercolor="gray" border="1" id="DataGrid1"
                                               style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
                                            <tr
                                                    style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">
                                                <td align="center" width="24%">商品编号</td>
                                                <td align="center" width="18%">商品名称</td>
                                                <td align="center" width="9%">商品价格</td>
                                                <td align="center" width="9%">商品数量</td>
                                                <td width="8%" align="center">商品类别</td>
                                                <td width="8%" align="center">编辑</td>

                                                <td width="8%" align="center">删除</td>
                                            </tr>
                                            <c:forEach items="${page.list}" var="book">
                                                <tr onmouseover="this.style.backgroundColor = 'white'"
                                                    onmouseout="this.style.backgroundColor = '#F5FAFE';">
                                                    <td style="CURSOR: hand; HEIGHT: 22px" align="center"
                                                        width="23">${book.id}</td>
                                                    <td style="CURSOR: hand; HEIGHT: 22px" align="center"
                                                        width="18%">${book.name}</td>
                                                    <td style="CURSOR: hand; HEIGHT: 22px" align="center"
                                                        width="8%">${book.price}</td>
                                                    <td style="CURSOR: hand; HEIGHT: 22px" align="center"
                                                        width="8%">${book.pnum}</td>
                                                    <td style="CURSOR: hand; HEIGHT: 22px" align="center">${book.category}</td>
                                                    <td align="center" style="HEIGHT: 22px" width="7%">
                                                        <a href="/products/edit?id=${book.id}&&pageNum=${page.pageNum}">
                                                            <img src="${pageContext.request.contextPath}/static/admin/images/i_edit.gif" border="0" style="CURSOR: hand">
                                                        </a>
                                                    </td>
                                                    <td align="center" style="HEIGHT: 22px" width="7%">
                                                        <a href="/servlet/delete/${book.id}?pageNum=${page.pageNum}&&pageSize=${page.size}">
                                                            <img src="${pageContext.request.contextPath}/static/admin/images/i_del.gif" width="16" height="16" border="0" style="CURSOR: hand">
                                                        </a>
                                                    </td>
                                                </tr>
                                            </c:forEach>

                                        </table>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                        </form>
                    </tr>
                    <c:if test="${conditionError.equals('未查询到书籍')}">
                        <tr><td height=2></td></tr>
                        <div class="clo-md-12" style="text-align: center">
                            <span class="Style1" style="text-align: center" ><strong>${conditionError}</strong></span>
                        </div>
                    </c:if>
                    <tr><td height=2></td></tr>
                </table>
            </div>
        </div>
        <div class="clo-md-4" style="text-align: right;margin-right: 30px">
            <c:if test="${page.hasPreviousPage}"><span class="Style1" style="text-align: center" ><a href="/products/list/page/1">首页</a></span></c:if>
            <c:if test="${page.hasPreviousPage}"><span class="Style1" style="text-align: center" ><a href="/products/list/page/${page.prePage}">上一页</a></span></c:if>
            <c:forEach items="${page.navigatepageNums}" var="navigatepageNums">
                <c:if test="${navigatepageNums==page.pageNum}" >
                    <span class="Style1" style="text-align: center;" ><a href="/products/list/page/${navigatepageNums}" style="color: red">${navigatepageNums}</a></span>
                </c:if>
                <c:if test="${navigatepageNums!=page.pageNum}" >
                    <span class="Style1" style="text-align: center;" ><a href="/products/list/page/${navigatepageNums}">${navigatepageNums}</a></span>
                </c:if>
            </c:forEach>
            <c:if test="${page.hasNextPage}"><span class="Style1" style="text-align: center" ><a href="/products/list/page/${page.nextPage}">下一页</a></span></c:if>
            <c:if test="${page.hasNextPage}"><span class="Style1" style="text-align: center" ><a href="/products/list/page/${page.pages}">尾页</a></span></c:if>
        </div>
    </div>
</div>

<jsp:include page="../login/bottom.jsp"></jsp:include>

</body>
</html>

