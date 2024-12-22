<%@ page import="com.model.CarNews" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>汽车资讯</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }
        .container {
            width: 80%;
            margin: 20px auto;
            background-color: #fff;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        /* Style for the car background button */
        .car-button {
            background-image: url("static/liw.png"); /* Replace with your image path */
            background-size: cover;
            background-position: center;
            width: 900px; /* Adjust the width as needed */
            height: 340px; /* Adjust the height as needed */
            border: none;
            border-radius: 5px;
            font-size: 50px; /* 设置字体大小 */
            font-family: 'SimSun', Arial, sans-serif;
            color: white; /* 设置字体颜色 */
            font-weight: bold; /* 设置字体为粗体 */
            text-align: center; /* 文本居中 */
            line-height: 340px; /* 使文本垂直居中 */
            text-transform: uppercase; /* 将文本转换为大写 */
            text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.5); /* 添加文本阴影 */
            cursor: pointer;
            transition: background-color 0.3s ease;
            display: flex; /* 使用 Flexbox 布局 */
            align-items: center; /* 垂直居中 */
            justify-content: center; /* 水平居中 */
        }
        .car-button:hover {
            background-color: rgba(0, 0, 0, 0.5); /* Add a dark overlay on hover */
        }
        .button {
            background-image: url("static/li.png"); /* Replace with your image path */
            background-size: cover;
            background-position: center;
            width: 900px; /* Adjust the width as needed */
            height: 340px; /* Adjust the height as needed */
            border: none;
            border-radius: 5px;
            font-size: 50px; /* 设置字体大小 */
            font-family: 'SimSun', Arial, sans-serif;
            color: white; /* 设置字体颜色 */
            font-weight: bold; /* 设置字体为粗体 */
            text-align: center; /* 文本居中 */
            line-height: 340px; /* 使文本垂直居中 */
            text-transform: uppercase; /* 将文本转换为大写 */
            text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.5); /* 添加文本阴影 */
            cursor: pointer;
            transition: background-color 0.3s ease;
            display: flex; /* 使用 Flexbox 布局 */
            align-items: center; /* 垂直居中 */
            justify-content: center; /* 水平居中 */
        }
        .button:hover {
            background-color: rgba(0, 0, 0, 0.5); /* Add a dark overlay on hover */
        }
    </style>
</head>
<body>

<form action="carNews" method="get">
    <button type="submit" class="car-button">汽车资讯</button>
</form>
<form action="add.jsp" method="get">
    <button type="submit" class="button">新闻编辑</button>
</form>

</body>
</html>