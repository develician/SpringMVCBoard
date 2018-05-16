<%@include file="../include/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>

<style>
.table {
	font-weight: 500;
	font-size: 1.5rem;
}
</style>

<div class="container">

	<div class="col-md-12">
		<h1 style="margin-bottom: 2rem;">게시판</h1>
		<a href="/board/write" class="btn btn-primary pull-right"
			style="margin-bottom: 1rem;">글 작성하기</a>
		<table class="table table-bordered table-hover" style="width: 100%;">
			<thead>
				<tr>
					<th>게시글 번호</th>
					<th>제목</th>
					<th>올린 날짜</th>
					<th>글쓴이</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${boards }" var="board">
					<tr style="height: 1.5rem">
						<td>${board.bno }</td>
						<td><a href="/board/${board.bno }"> ${board.title } </a></td>
						<td>
							<f:formatDate value="${board.regDate }" pattern="yyyy-MM-dd HH:mm"/>
						</td>
						<td>${board.writer }</td>
					</tr>
				</c:forEach>


			</tbody>
		</table>
	</div>
</div>

<%@include file="../include/footer.jsp"%>