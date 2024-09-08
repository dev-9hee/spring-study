<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>글 상세 보기</title>
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

        .post-container {
            max-width: 800px;
            margin: 0 auto;
            background-color: #f9f9f9;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        .post-title {
            font-size: 24px;
            color: #333;
            margin-bottom: 10px;
        }

        .post-content {
            line-height: 2.0;
            margin-top: 20px;
        }

        .button-container {
            display: flex;
            justify-content: flex-end;
        }

        .button {
            display: inline-block;
            padding: 10px 15px;
            margin-left: 10px;
            color: white;
            text-decoration: none;
            border-radius: 4px;
            font-size: 14px;
            border: 0px solid;
        }

        .edit-button {
            background-color: #3093f5;
        }

        .delete-button {
            background-color: #f44336;
        }

        .back-button {
            background-color: #4CAF50;
        }

        .button:hover {
            opacity: 0.8;
        }
    </style>
</head>
<body>
<%@include file="../header.jsp" %>
<div class="post-container">
    <h1 class="post-title"> ${board.title} </h1>
    <div class="post-content">
        <div>작성자: ${board.author}</div>
        <div>작성일: ${board.regDate}</div>
        <div>
            ${board.content}
        </div>
    </div>
    <div class="button-container">
        <!-- 자신이 컨트롤러에서 전달한 데이터의 key 가 다른 경우 아래의 id 전달 부분 부분 수정 필요 -->
        <a href="/board/update?id=${board.id}" class="button edit-button">수정</a>
        <form action="/board/delete/${board.id}" method="post">
            <input type="submit" class="button delete-button" value="삭제" />
        </form>
        <a href="/board/list" class="button back-button">목록으로</a>
    </div>
</div>
</body>
</html>