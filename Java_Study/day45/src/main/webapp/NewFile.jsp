<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL식</title>
</head>
<body>

${1 div 1}<!-- 나누기 --> <br>
${1 mod 1}<!-- 나머짓값 --> 
<hr>
${1 eq 1} <!-- equals --> ${1 ne 1} ${1 lt 3 } ${1 ge -1} <!-- EL식 -->
<hr>
${1>3 and 1<-1} ${1>3 or 1>-1} ${not (1>3)} 
<hr>
${1>2? 1:2}<!-- 삼항연산자 -->


</body>
</html>