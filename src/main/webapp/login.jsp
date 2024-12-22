<%--
  Created by IntelliJ IDEA.
  User: mt
  Date: 2024/5/14
  Time: 22:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>登录界面</title>
    <link rel="stylesheet" type="text/css" href="css/login.css">
    <script src="js/login.js"></script>
</head>
<body>

<div class="login-form">
    <h1>登录</h1>
    <div class="input-field">
        <label for="username">账号:</label>
        <input type="text" placeholder="请输入账号" id="username" name="username">
    </div>
    <div class="input-field">
        <label for="password">密码:</label>
        <input type="password" placeholder="请输入密码" id="password" name="password">
    </div>
    <input type="button" value="立即登录" id="login_submit" name="login_submit" onclick="judgement()">
</div>

</body>
</html>
