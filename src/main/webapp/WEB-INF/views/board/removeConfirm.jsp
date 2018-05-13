<%@include file="../include/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div class="container">
	<div class="jumbotron">
		<h2>${confirmMessage }</h2>
		<button type="button" class="btn btn-danger" onclick="deleteAction();">삭제하기</button>
		<button onclick="goBack();" type="button" class="btn btn-primary">돌아가기</button>
	</div>
	<form id="deleteForm" style="display: none;">
		<input type="hidden" name="bno" value="${bno }">
	</form>
</div>

<script>
	function goBack() {
		window.history.back();
	}

	function deleteAction() {
		var form = document.getElementById("deleteForm");
		form.action = "/board/delete/${bno}";
		form.method = "post";
		form.submit();

	}
</script>
<%@include file="../include/footer.jsp"%>