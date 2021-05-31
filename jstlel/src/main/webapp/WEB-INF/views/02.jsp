<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>scope(객체의 저장범위) test</h1>
	${vo.no } <br/>
	${vo.name } <br/>
	
	============<br/>
	
	${sessionScope.vo.no }<br/>
	${sessionScope.vo.name }<br/>
</body>
</html>