<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<c:forEach var="threeM" items="${member}">
	<c:if test="${threeM.mid == null}">
	최근에 가입한 회원이 없습니다.
</c:if>
	<tr>
		<!-- <th><a href="main.do?mid=${data.mid}&cnt=2">[${data.mname}]&nbsp;</a></th> -->
		<th><a href="main.do?mid=${threeM.mid}&cnt=2&showContent=${threeM.mid}">[${threeM.mname}]&nbsp;</a></th>
	</tr>
</c:forEach>