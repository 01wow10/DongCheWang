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
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }
        .container {
            width: 80%;
            margin: 20px auto;
            padding: 20px;
        }
        .news-card {
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            margin-bottom: 20px;
            padding: 15px;
            display: flex;
            flex-direction: row;
            align-items: center;
        }
        .news-card img {
            width: 150px; /* Adjust as needed */
            height: auto;
            margin-right: 15px;
        }
        .news-card div {
            flex-grow: 1;
        }
        .news-title {
            font-size: 1.2em;
            margin: 0 0 10px 0;
        }
        .news-summary {
            color: #666;
            text-decoration: none; /* Remove underline from the link */
        }
        .news-summary:hover {
            text-decoration: underline; /* Add underline on hover */
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