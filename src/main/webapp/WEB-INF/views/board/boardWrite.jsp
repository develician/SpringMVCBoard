<%@include file="../include/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">
	<c:choose>
		<c:when test="${empty vo }">
			<form action="/board/${actionState }" method="post"
		style="margin-top: 3rem; margin-bottom: 3rem;">
		</c:when>
		<c:otherwise>
			<form action="/board/${actionState }/${vo.bno}" method="post"
		style="margin-top: 3rem; margin-bottom: 3rem;">
		</c:otherwise>
	</c:choose>
	
		<div class="form-group">
			<label for="exampleInputEmail1">글 제목</label>
			<c:choose>
				<c:when test="${empty vo }">
					<input name="title" type="text" class="form-control"
						id="exampleInputEmail1" placeholder="title">
				</c:when>
				<c:otherwise>
					<input type="hidden" name="bno" value="${vo.bno }"/>
					<input name="title" type="text" class="form-control"
						id="exampleInputEmail1" placeholder="title" value="${vo.title }">
				</c:otherwise>
			</c:choose>

		</div>
		<div class="form-group">
		<c:choose>
			<c:when test="${empty vo }">
				<label for="exampleInputPassword1">글 작성자</label> <input type="text"
				class="form-control" id="exampleInputPassword1" name="writer"
				placeholder="author">
			</c:when>
			<c:otherwise>
				<label for="exampleInputPassword1">글 작성자</label> <input type="text"
				class="form-control" id="exampleInputPassword1" name="writer"
				placeholder="author" value="${vo.writer }" disabled>
			</c:otherwise>
		</c:choose>
			
		</div>
		<div class="form-group">
			
			<c:choose>
				<c:when test="${empty vo }">
					<label for="content">내용</label>
					<textarea id="content" class="form-control" rows="3"
					placeholder="글내용" name="content"></textarea>
				</c:when>
				<c:otherwise>
						<label for="content">내용</label>
						<textarea id="content" class="form-control" rows="3"
						placeholder="글내용" name="content">${vo.content }</textarea>
				</c:otherwise>
			</c:choose>
		</div>

		<c:choose>
			<c:when test="${empty vo }">
				<button type="submit" class="btn btn-default">작성하기</button>
			</c:when>
			<c:otherwise>
				<button type="submit" class="btn btn-default">수정하기</button>
			</c:otherwise>
		</c:choose>
		
	</form>
</div>
<%@include file="../include/footer.jsp"%>