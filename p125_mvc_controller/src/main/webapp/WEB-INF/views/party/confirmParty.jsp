<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	id : ${obj.id} <br>
	name : ${obj.name}<br>
	addr : ${obj.listContactPoint[0].value}<br>
	phoneNum : ${obj.listContactPoint[1].value}<br>
	date : ${obj.birthDate}
	내사랑나이 : ${ageOfMine}
</body>
</html>