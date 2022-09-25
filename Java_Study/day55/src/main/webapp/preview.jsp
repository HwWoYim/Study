<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이미지 미리보기</title>
</head>
<body>
<!-- 
1. 화면 깜빡임(Controller방문) 없이 DB데이터가 필요하면 -> .ajax() 를 써서 비동기처리 해야한다.
2. 화면 깜빡임(Controller방문) 없이 어떤 기능을 수행해야 할 때 -> JS == 프론트
 -->
<input type="file" onchange="loadFile(this);">
<hr>
<img alt="미리보기" id="preview"/>

<script type="text/javascript">
	function loadFile(input){
		//console.log('로그1');
		if(input.files && input.files[0]){
		//console.log('로그2');
			var fr = new FileReader();
			fr.onload=function(event){
		//console.log('로그3');
				document.getElementById('preview').src=event.target.result;
			};
			fr.readAsDataURL(input.files[0]);
		} else{
		//console.log('로그4');
			document.getElementById('preview').src="";
		}
	}
</script>

</body>
</html>