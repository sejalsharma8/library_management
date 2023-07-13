<jsp:include page="/layout/header.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.nagarro.library_management.model.Book" %>
<%@page import="com.nagarro.library_management.services.BookService" %>
<%@page import="com.nagarro.library_management.servicesImpl.BookServiceImpl" %>
<%@page import="java.util.List" %>
<main class="container">
	<!--  <h1 class="text-center">Welcome</h1>-->
	<div class="d-flex justify-content-center mt-3">
		<form class="Form row gy-2" action="add" method="POST">
			<h1 class="text-center">Add Book</h1>
			<c:if test="${success==true}">
				<p style="border: 2px solid black;"
					class="text-center bg-success text-white">${msg}</p>
			</c:if>
			<c:if test="${success==false}">
				<p style="border: 2px solid black;"
					class="text-center bg-danger text-white">${msg}</p>
			</c:if>
			<h4 class="col-md-6">Book Id</h4>
			<input class="col-md-6" type="text" name="id"
				placeholder="Type Id" />
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
			<!--  <input class="col-md-6" type="text" name="date"
			     placeholder="${date}" readonly/>-->
			 <select class="col-md-6" name="date">    
			 <option value="${date}">${date}</option>
			 </select>
			<div class="d-flex justify-content-center">
				<input class="btn btn-secondary" type="submit" value="Add" />
			</div>
		</form>
	</div>
	<section class="detail pt-5">
		<table class="table table__box">
			<thead>
				<tr>
				    <th scope="col">Sr. No.</th>
					<th scope="col">Id</th>
					<th scope="col">Title</th>
					<th scope="col">Author</th>
					<th scope="col">Added On</th>
					<th scope="col">Actions</th>
				</tr>
			</thead>
			<%
			BookService bookService = new BookServiceImpl();
			List<Book> books = bookService.getBooks();
			int i =1;
			for(Book book : books){
				%>
			<tbody>
			
					<tr>
						<th scope="row"><%=i++%></th>
						<td scope="row"><%=book.getId() %></td>
						<td scope="row"><%=book.getTitle() %></td>
						<td scope="row"><%=book.getAuthor() %></td>
						<td scope="row"><%=book.getDate()%></td>
						<td><a href="edit?id=<%=book.getId()%>">
						<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil-square"
					    viewBox="0 0 16 16"> <path d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z" /><path fill-rule="evenodd"
									d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5v11z" />
									</svg></a> 
									<a href="delete?id=<%=book.getId()%>"><svg
								xmlns="http://www.w3.org/2000/svg" width="16" height="16"
								fill="currentColor" class="bi bi-trash3-fill"
								viewBox="0 0 16 16">
  <path
									d="M11 1.5v1h3.5a.5.5 0 0 1 0 1h-.538l-.853 10.66A2 2 0 0 1 11.115 16h-6.23a2 2 0 0 1-1.994-1.84L2.038 3.5H1.5a.5.5 0 0 1 0-1H5v-1A1.5 1.5 0 0 1 6.5 0h3A1.5 1.5 0 0 1 11 1.5Zm-5 0v1h4v-1a.5.5 0 0 0-.5-.5h-3a.5.5 0 0 0-.5.5ZM4.5 5.029l.5 8.5a.5.5 0 1 0 .998-.06l-.5-8.5a.5.5 0 1 0-.998.06Zm6.53-.528a.5.5 0 0 0-.528.47l-.5 8.5a.5.5 0 0 0 .998.058l.5-8.5a.5.5 0 0 0-.47-.528ZM8 4.5a.5.5 0 0 0-.5.5v8.5a.5.5 0 0 0 1 0V5a.5.5 0 0 0-.5-.5Z" />
</svg></a></td>
					</tr>
				
			</tbody>
			<%
			}
			%>
		</table>
	</section>
</main>
<div class="space">
</div>
<jsp:include page="/layout/footer.jsp" />
