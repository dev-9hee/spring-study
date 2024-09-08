<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String REST_API_KEY = "";
    String REDIRECT_URI = "";
    String KAKAO_URI = "https://kauth.kakao.com/oauth/authorize?client_id=" + REST_API_KEY + "&redirect_uri=" + REDIRECT_URI + "&response_type=code";
%>
<header>
    <h3>Board</h3>
    <a href="/board/list">게시글 목록</a>
</header>