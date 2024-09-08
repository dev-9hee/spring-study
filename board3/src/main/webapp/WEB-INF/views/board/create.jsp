<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create New Post</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            padding: 0;
        }

        h1 {
            color: #333;
            text-align: center;
            margin-bottom: 20px;
        }

        form {
            width: 50%;
            margin: 0 auto;
            background-color: #fff;
            padding: 20px;
            border: 1px solid #ddd;
            border-radius: 4px;
        }

        label {
            display: block;
            margin-bottom: 8px;
            font-weight: bold;
        }

        input[type="text"], textarea {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 4px;
            font-size: 16px;
        }

        textarea {
            height: 150px;
        }

        input[type="submit"] {
            display: inline-block;
            padding: 10px 15px;
            background-color: #4CAF50;
            color: white;
            text-decoration: none;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }

        .cancel-button {
            display: inline-block;
            padding: 10px 15px;
            margin-top: 10px;
            background-color: #ddd;
            color: #333;
            text-decoration: none;
            border-radius: 4px;
            text-align: center;
        }

        a:hover {
            background-color: #ccc;
        }
    </style>
</head>
<body>
<%@include file="../header.jsp"%>
<h1>글 작성</h1>
<form action="/board/create" method="post">
    <label for="title">작성자</label>
    <input type="text" name="author" />

    <label for="title">제목</label>
    <input type="text" id="title" name="title" required>

    <label for="content">내용</label>
    <textarea id="content" name="content" required></textarea>

    <input type="submit" value="글 작성">
    <a class="cancel-button" href="/board/list">취소</a>
</form>
</body>
</html>
