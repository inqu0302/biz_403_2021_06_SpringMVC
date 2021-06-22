<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<%@ include file="/WEB-INF/views/include/include_head.jspf" %>
<body>
	<section class=search_sec>
		<table>
			<tr>
				<th>CODE</th>
				<th>출판사명</th>
				<th>대표</th>
				<th>연락처</th>
				<th>주소</th>
				<th>주요장르</th>
			</tr>
			<c:choose>
				<c:when test="${empty COMPS}">
					<tr><td colspan="6">데이터가 없음</td>
				</c:when>
				<c:otherwise>
					<c:forEach items="${COMPS}" var="COMP" varStatus="seq">
						<tr data-ccode="${COMP.cp_code}" class="search_comp">
							<td>${COMP.cp_code}</td>
							<td>${COMP.cp_title}</td>
							<td>${COMP.cp_ceo}</td>
							<td>${COMP.cp_tel}</td>
							<td>${COMP.cp_addr}</td>
							<td>${COMP.cp_genre}</td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</table>
	</section>
</body>
<script>
	document.querySelector("section.serach_sec table").addEventListener("click", (e)=>{
		
		let target = e.target;
		let tagName = target.tagName;
		
		alert();
		
		if(tagName === "TD"){
			
			/*
			table에 click event가 발생하면 가장 중심부에 있는 TD가 event를 최종 수신한다
			그러면 TD가 클릭되었을때와 같은 효과를 낸다
			
			TD 가 클릭이 되면 데이터를 가져오려고 하는데 TD가 여러개이기때문에 모든 TD에 
			데이터를 담아둘수 없기때문에 TR에 데이터를 담아두고 TD가 선택이 되면 감싸고 있는
			TR 을 확인하고 ( e.target.closet("TR") ) SELECT
			*/
			let ccode = e.target.closest("TR").dataset.ccode
			
			alert("출판사 코드 : " + ccode)
		}
	})
</script>
</html>