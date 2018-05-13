<%@include file="../include/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div class="container">
	<div class="jumbotron">
		<h1>${message }</h1>
		<a href="/board" class="btn btn-primary">게시판으로 이동하기</a>
	</div>
</div>

<%@include file="../include/footer.jsp"%>