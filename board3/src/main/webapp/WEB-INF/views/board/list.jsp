<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Post List</title>
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

        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }

        table, th, td {
            border: 1px solid #ddd;
        }

        th, td {
            padding: 12px;
            text-align: left;
        }

        th {
            background-color: #f2f2f2;
        }

        tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        tr:hover {
            background-color: #f1f1f1;
        }

        .new-button {
            display: inline-block;
            padding: 10px 15px;
            margin-top: 10px;
            background-color: #4CAF50;
            color: white;
            text-decoration: none;
            border-radius: 4px;
            text-align: center;
        }

        .new-button:hover .btn {
            background-color: #45a049;
        }

        .update-button  {
            background-color: #3093f5;
            color: white;
            border: none;
            padding: 10px 15px;
            border-radius: 4px;
            cursor: pointer;
        }

        .update-button:hover {
            background-color: #3561e5;
        }

        .delete-button {
            background-color: #f44336;
            color: white;
            border: none;
            padding: 10px 15px;
            border-radius: 4px;
            cursor: pointer;
        }

        .delete-button:hover {
            background-color: #e53935;
        }
    </style>
</head>
<body>
<%@include file="../header.jsp"%>
<h1>글 목록</h1>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Title</th>
        <th>Content</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="board" items="${boardList}">
        <tr>
            <td>${board.id}</td>
            <td><a href="/board/detail?id=${board.id}">${board.title}</a></td>
            <td>${board.content}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<a class="new-button" href="/board/create">새글 작성하기</a>
</body>
</html>
