<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이미지 업로드</title>
</head>
<body>

<form action="test.do" method="post" enctype="multipart/form-data">
	<input type="text" name="mid">
	<input type="file" name="fileName"> <!-- 일반적으로는 type과 name(파라미터이름)을 동일하게 한다. -->
	<input type="submit" value="확인">
</form>

<hr>
EL 데이터 확인 [${img}]
<hr>
<img alt="확인" src="images/${img}"> <!-- ${img} : 내가 업로드한 파일명 -->

</body>
</html>