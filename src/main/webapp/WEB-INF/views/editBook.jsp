<jsp:include page="/layout/header.jsp" />
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<main class="container">
<div class="d-flex justify-content-center mt-3">
<form class="Form row gy-2" action="update" method="POST">
			<h1 class="text-center">Edit Book</h1>
			<c:if test="${success==true}">
				<p style="border: 2px solid black;"
					class="text-center bg-success text-white">${msg}</p>
			</c:if>
			<c:if test="${success==false}">
				<p style="border: 2px solid black;"
					class="text-center bg-danger text-white">${msg}</p>
			</c:if>
			<h4 class="col-md-6">Book Id</h4>
			<select class="col-md-6" name="id">    
			 <option value="${id}">${id}</option>
			 </select>
			<h4 class="col-md-6">Title</h4>
			<input class="col-md-6" type="text" name="title"
				placeholder="Type Title" />
			<h4 class="col-md-6">Author</h4>
			<select class="col-md-6" name="author">
			<c:forEach var="authors" items="${authors}">
				<option value="${authors.getName()}">${authors.getName()}</option>
			</c:forEach>
			</select>
			<h4 class="col-md-6">Date</h4>
			 <select class="col-md-6" name="date">    
			 <option value="${date}">${date}</option>
			 </select>
			<div class="d-flex justify-content-center">
				<input class="btn btn-secondary" type="submit" value="Update" />
			</div>
		</form>
		</div>
</main>
<div class="space">
</div>
<jsp:include page="/layout/footer.jsp" />