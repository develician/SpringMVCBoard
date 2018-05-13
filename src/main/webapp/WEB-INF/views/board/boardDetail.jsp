<%@include file="../include/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">
	<table class="table table-bordered table-hover" style="margin-top: 1rem; margin-bottom: 1rem">
		<tr>
			<td>글 번호</td>
			<td>${vo.bno }</td>
		</tr>
		<tr>
			<td>글 제목</td>
			<td>${vo.title }</td>
		</tr>
		<tr>
			<td>글 쓴이</td>
			<td>${vo.writer }</td>
		</tr>
		<tr>
			<td>작성 날짜</td>
			<td>${vo.regDate }</td>
		</tr>
		<tr>
			<td>글 내용</td>
			<td>${vo.content }</td>
		</tr>
	</table>
	<a href="/board/update/${vo.bno }" class="btn btn-warning pull-right" style="margin-left: 1rem;">수정하기</a>
	<a href="/board/remove/${vo.bno }" class="btn btn-danger pull-right">삭제하기</a>
</div>
<%@include file="../include/footer.jsp"%>