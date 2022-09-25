<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="yim" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>
<link rel="stylesheet" href="css/main.css" type="text/css" />
<script type="text/javascript">
	function signup(){
		window.open("signup.jsp","회원가입 페이지","width=500,height=200");
	}
</script>
</head>
<!-- uid -> 세션에 저장된 로그인된 ID -->
<!-- mname -> 세션에 저장된 ID의 mname -->
<body>
		<div id="header">
		<h1>공부공부공부!!!!</h1>
		<c:if test="${uid != null}"> <!-- 로그인 했을 시 ID값 보여주기 -->
			<h2>현재 로그인된 ID : ${uid} 닉네임 : ${mname}</h2>
		</c:if>
		
		<div class="gnb">
			<ul>
				<li><a href="main.do?showContent=main">메인으로</a></li>
				<c:if test="${uid==null}">
				<li><a href="javascript:signup()">회원가입</a></li>
				</c:if>
				<c:if test="${uid != null}">
					<li><yim:delete/></li>
				</c:if>
				<!-- LoginAction 에서 uid와 mname에 값을 저장한다. -->
				<li><yim:login /></li>
			</ul>
		</div>
		<div>
			<span>최근 회원가입한 사용자</span>
			<!-- search태그 안 -> MainAction에서 최근가입한 회원 3명을 저장한 member를 사용 -->
			<yim:search/>
		</div>
	</div>
	
	<div id="wrapper">
	
		<div id="content">
			<h2>글 등록하기</h2>
			<!-- write.tag에서 type으로 선택적으로 사용 -->
			<yim:write type="msg" />
		</div>
		
		<div id="main">
			<h2>글 목록보기&nbsp;&nbsp;
			<c:if test="${uid != null}">
				<!-- 세선에 저장되어있는 로그인 정보로부터 id를 대입시킨다. -->
				<a href="main.do?mid=${uid}&showContent=${uid}">내가 쓴 글</a>
			</c:if>
			</h2>
			<c:forEach var="v" items="${datas}"> <!-- 게시물1개+댓글N개의 BoardSet제네릭타입의 배열을 v에 저장 -->
				<c:set var="b" value="${v.boardVO}" /> <!-- 제네릭 BoardSet 안에 boardVO가 존재한다. -->
				<h3>[${b.mid}] ${b.msg} [ 좋아요 ${b.favcnt} | 댓글 ${b.rcnt} ] <yim:board midCheck="${b.mid}" bid="${b.bid}" /></h3>
								
				<div class="reply">
					<ul>
						<c:forEach var="r" items="${v.rList}"> <!-- v.rList -> BoardDAO에서 생성과 초기화 -->
							<li>[${r.mid}] ${r.rmsg} <yim:reply midCheck="${r.mid}" rid="${r.rid}" /></li>
						</c:forEach>
					</ul>
				</div>
			
			<div class="reply">
			<!-- write.tag에서 type으로 선택적으로 사용 -->
				<yim:write type="rmsg" bid="${b.bid}" />
			</div>
			</c:forEach>
		</div>
		
		
		<!-- 모든 게시글 보면 더보기 버튼 비활성화 -->
		<c:if test="${!noMoreContent}"> <!-- noMoreContent가 보여줄지 말지 정해준다. -->
		<!-- 내가 쓴 글만 더보기 -->
			<c:if test="${moreContent != null}">
				<a href="main.do?showContent=${moreContent}&cnt=${cnt+2}">더보기&gt;&gt;</a>
			</c:if>
			<!-- 전체 글 더보기 -->
			<c:if test="${moreContent == null}">
				<a href="main.do?cnt=${cnt+2}">더보기&gt;&gt;</a>
			</c:if>
		</c:if>
		
	</div>
		
	<div id="footer">
		회사소개 | 이용약관 | <strong>개인정보처리방침</strong> | 보호정책 | 고객센터 <strong>ⓒ Corp.</strong>
	</div>

</body>
</html>