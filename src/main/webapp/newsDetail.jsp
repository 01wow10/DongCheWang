<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>News Detail</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #e0f7fa; /* 浅蓝色背景 */
        }
        .container {
            width: 90%;
            max-width: 1200px; /* 最大宽度 */
            margin: 20px auto;
            background-color: #fff;
            padding: 20px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        h1 {
            color: #0277bd; /* 深蓝色标题 */
            border-bottom: 2px solid #0277bd; /* 标题下划线 */
            padding-bottom: 10px;
        }
        img {
            max-width: 50%; /* 图片宽度自适应 */
            height: auto;
            display: block;
            margin: 20px 0;
            border: 4px solid #e0f7fa; /* 图片边框 */
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2); /* 图片阴影 */
        }
        p {
            color: #333;
            line-height: 1.6;
        }
        .button {
            display: inline-block;
            padding: 10px 20px;
            margin: 10px 0;
            background-color: #8bc34a; /* 绿色按钮 */
            color: white;
            text-align: center;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.2);
        }
        .button:hover {
            background-color: #7cb342; /* 悬停时的按钮颜色 */
        }
    </style>
</head>
<body>
<div class="container">
    <h1>${news.title}</h1>
    <img src="${news.carPhoto}" alt="News Image">
    <p>${news.content}</p>
</div>
</body>
</html>