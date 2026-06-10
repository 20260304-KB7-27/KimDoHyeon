<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main</title>
</head>
<body>
  <h1>메인 화면 페이지</h1>
  <h2>include 지시어 태그 실습</h2>

<%--정적 include --%>
<%@ include file="copywrite.jsp"%>

<%-- 액션태그 --%>
<%--  동적 include --%>
<jsp:include page="header.jsp"/>

</body>
</html>
