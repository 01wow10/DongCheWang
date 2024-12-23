<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>汽车资讯</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f0f0f0; /* 浅灰色背景 */
            margin: 0;
            padding: 0;
            color: #333; /* 默认字体颜色 */
        }
        .container {
            width: 80%;
            margin: 20px auto;
            padding: 20px;
            background-color: #ffffff; /* 白色背景 */
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }
        .news-card {
            margin-bottom: 20px;
            padding: 15px;
            display: flex;
            flex-direction: row;
            align-items: center;
            background-color: #eef2f5; /* 浅蓝色背景 */
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            transition: transform 0.3s ease-in-out; /* 平滑过渡效果 */
        }
        .news-card:hover {
            transform: translateY(-5px); /* 鼠标悬停时上移 */
        }
        .news-card img {
            width: 150px;
            height: auto;
            margin-right: 15px;
            border-radius: 4px; /* 图片圆角 */
        }
        .news-card div {
            flex-grow: 1;
        }
        .news-title {
            font-size: 1.2em;
            margin: 0 0 10px 0;
            color: #2a4055; /* 标题颜色 */
        }
        .news-summary {
            color: #007bff; /* 链接颜色 */
            text-decoration: none;
        }
        .news-summary:hover {
            text-decoration: underline;
            color: #0056b3; /* 悬停时链接颜色 */
        }
    </style>
</head>
<body>
<div class="container">
    <h1>汽车资讯</h1>
    <c:forEach items="${newsList}" var="news">
        <div class="news-card">
            <img src="${news.carPhoto}" alt="Car Photo">
            <div>
                <h2 class="news-title">${news.title}</h2>
                <a href="newsDetail?id=${news.id}" class="news-summary">${news.summary}</a>
            </div>
        </div>
    </c:forEach>
</div>
</body>
</html>