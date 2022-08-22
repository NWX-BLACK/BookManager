
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>菜单</title>

    <link href="${pageContext.request.contextPath}/static/admin/css/left.css" rel="stylesheet" type="text/css">

    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">


</head>
<body>
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
                                    <a href="/servlet/findProductByManyCondition/false" style="font-size: 14px">显示所有书籍</a>
                                </li>
                                <li>
                                    <a href="/products/add" style="font-size: 14px">添加书籍</a>
                                </li>
                                <li>
                                    <a role="button" data-toggle="collapse" href="#settingCollapse" style="font-size: 14px">
                                        设置
                                        <span class="caret"></span>
                                    </a>
                                    <div class="collapse" id="settingCollapse">
                                        <ul class="nav flex-column">
                                            <li > <a class="nav-link" href="/chineseBooks">中文</a></li>
                                            <li > <a class="nav-link" href="/foreignBooks">外文</a></li>
                                        </ul>
                                    </div>
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

    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<%--    <script type="text/javascript">
        // $('.collapse').collapse();
        $(".collapse.in").collapse('hide');
    </script>--%>

</body>
</html>
