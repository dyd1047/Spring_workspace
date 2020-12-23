<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script>
	alert("<%=request.getAttribute("msg")%>");
	history.back();
</script>
</head>
<body bgcolor="red">
</body>
</html>