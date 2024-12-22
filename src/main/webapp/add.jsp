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
            background-color: #f4f4f4f4;
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
        form {
            margin-top: 20px;
        }
        label {
            display: block;
            margin-top: 10px;
        }
        input[type="text"], input[type="file"], textarea {
            width: 100%;
            padding: 10px;
            margin-top: 5px;
            border: 1px solid #ddd;
            border-radius: 5px;
        }
        textarea {
            resize: vertical;
        }
        .car-button {
            padding: 10px 20px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease;
            margin-top: 10px;
        }
        .car-button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>

<div class="container">
    <h2>添加新闻</h2>
    <form method="post" action="carNews" enctype="multipart/form-data">
        <label for="title">标题:</label>
        <input type="text" id="title" name="title" placeholder="输入新闻标题" required><br>
        <label for="carPhoto">选择图片:</label>
        <input type="file" id="carPhoto" name="carPhoto" accept="image/png, image/jpeg" aria-label="选择新闻图片" required><br>
        <label for="summary">简介:</label>
        <input type="text" id="summary" name="summary" placeholder="输入新闻简介" required><br>
        <label for="content">内容:</label>
        <textarea id="content" name="content" placeholder="输入新闻详细内容" required></textarea><br>
        <button type="submit" class="car-button">提交</button>
    </form>
</div>

</body>
</html>