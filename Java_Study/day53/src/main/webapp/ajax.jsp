<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ajax 실습</title>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
</head>
<body>
<!-- View -->
<div id="box">
	<input type="text" name="mid" id="mid"><!-- 일반적으로 name속성과 동일한 id값을 부여 -->
	<button class="btn" onclick="check();">중복검사</button>
	<div id="result"></div>
</div>

<script type="text/javascript">
	function check(){
		var mid=$("#mid").val(); // input태그에서 id로 정의되었으니까 #mid로 불러온다.
		$.ajax({
			type: 'GET', // GET 방식으로 전송
			url: '${pageContext.request.contextPath}/check.do?mid='+mid, // mid(View에서 입력한 값)라는 변수만들어서 사용자가 입력한 값을 확보한 상태이다.
								  								   // DB에게 물어본다. "mid라는 값이 DB에 이미 있어?"
								 								   // DB에게 물어보기 위해선 DAO를 거쳐야 하므로 DAO에 전달해야한다.
																   // Controller가 작업을 해주어야 한다. -> 서블릿 생성
			data: {mid:mid},	// POST 방식일 때 사용
			success: function(result){
				// rewult는 String
				// JS - 1 : 모든 데이터가 객체
				// JS - 2 : 동적타이핑(즉각적으로 자동 형변환)
				console.log("로그1 ["+result+"]");
				if(result == 1){
					// 사용가능
					$("#result").text("사용가능한 아이디입니다.");
					$("#result").css("color", "blue");
				} else{
					// 사용 중이라 사용불가능
					$("#result").text("사용 중인 아이디입니다.");
					$("#result").css("color", "red");
				}
			},
			error: function(request, status, error){
				console.log("code" + request.status);
				console.log("message" + request.responseText);
				console.log("error" + request.error);
			}
		});
	}
</script>

</body>
</html>