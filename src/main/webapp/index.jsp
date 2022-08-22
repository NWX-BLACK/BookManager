<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/7/20
  Time: 12:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
  <head>
    <title>$Title$</title>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    <script src="https://cdn.bootcss.com/jquery/3.5.0/jquery.js"></script>

      <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
      <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

      <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
      <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>

      <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
      <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" ></script>

  </head>
  <body>

  <a class="btn btn-primary" role="button" data-toggle="collapse" href="#collapseExample" aria-expanded="false" aria-controls="collapseExample">
      Link with href
  </a>
  <button class="btn btn-primary" type="button" data-toggle="collapse" data-target="#collapseExample" aria-expanded="false" aria-controls="collapseExample">
      Button with data-target
  </button>
  <div class="collapse" id="collapseExample">
      <div class="well">
          ...
      </div>
  </div>


       <button id="btn">按键</button>

       <script type="text/javascript">
         $("#btn").click(function () {
           swal({
             title: "你确定吗?",
             text: "一旦删除,不可恢复",
             icon: "warning",
             buttons: true,
             dangerMode: true,
           })
         })
       </script>
  </body>

</html>

<%--<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Title</title>
  <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
  <script src="https://cdn.bootcss.com/jquery/3.5.0/jquery.js"></script>
</head>
<body>
<div>
  <p>alex</p>
  <button id="btn">删除</button>
</div>
<script>
  $("#btn").click(function () {
    swal({
      title: "你确定吗?",
      text: "一旦删除,不可恢复",
      icon: "warning",
      buttons: true,
      dangerMode: true,
    })
            .then((willDelete) => {
              if (willDelete) {
                $(this).parent().remove()
                swal("成功删除", {
                  icon: "success",
                });
              } else {
                swal("取消删除");
              }
            });
  })
</script>
</body>
</html>--%>
