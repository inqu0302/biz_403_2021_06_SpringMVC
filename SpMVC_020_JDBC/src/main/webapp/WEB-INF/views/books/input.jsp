<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서정보 2021</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/include_head.jspf" %>
	<%@ include file="/WEB-INF/views/include/include_header.jspf" %>
	<form method="post">
		<fieldset>
		<legend>도서정보 등록</legend>
		<div>
			<label>ISBN</label>
			<input name="bk_ISBN" id="bk_ISBN"placeholder="">
		</div>
		<div>
			<label>도서명</label>
			<input name="bk_title" id="bk_title"placeholder="">
		</div>
		<div>
			<label>출판사</label>
			<input name="bk_ccode" id="bk_ccode"placeholder="">
		</div>
		<div>
			<label>저자</label>
			<input name="bk_acode" id="bk_acode"placeholder="">
		</div>
		<div>
			<label>출판년도</label>
			<input name="bk_date" id="bk_date"placeholder="">
		</div>
		<div>
			<label>가격</label>
			<input name="bk_price" id="bk_price"placeholder="">
		</div>
		<div>
			<label>페이지수</label>
			<input name="bk_pages" id="bk_pages"placeholder="">
		</div>
		</fieldset>
		<div class="btn_box">
			<button type="button" class="btn_save book">도서등록</button>
			<button type="reset" class="btn_reset book">새로작성</button>
			<button type="button" class="btn_list book">돌아가기</button>
		</div>
	</form>
	<%@ include file="/WEB-INF/views/include/include_footer.jspf" %>
	<script>
		// const : 상수를 선언하는 키워드, 코드가 진행되는 동안 값이 변경되면 않되는 것
		const doc = document
		doc.querySelector("button.btn_delete").addEventListener("click", (e)=>{
			
			doc.querySelector("input[name='cpcode']")
			
			let cpcodeObj = doc.querySelector("input#cpcode")
			
			let cpcode = cpcodeObj.value
			
			alert("삭제버튼 클릭" + cpcode)
			if(confirm(cpcode + " 를 삭제합니다!")){
				location.replace("${rootPath}/comp/delete?cp_code=" + cpcode);
			}
		})
	</script>
</body>
</html>