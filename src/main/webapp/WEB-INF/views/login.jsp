<jsp:include page="/layout/header.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<main class="container">
	<h1 class="text-center">Library Management</h1>
	<div class="d-flex justify-content-center mt-3">
		<form class="Form row gy-2" action="login" method="POST">
			<h1 class="text-center">Log in</h1>
			<c:if test="${success==true}">
				<p style="border: 2px solid black;"
					class="text-center bg-success text-white">${msg}</p>
			</c:if>
			<c:if test="${success==false}">
				<div class="alert alert-secondary" role="alert">${msg}</div>
			</c:if>
			<h4 class="col-md-6">Username</h4>
			<input class="col-md-6" type="text" name="username" required />
			<h4 class="col-md-6">Password</h4>
			<input class="col-md-6" type="password" name="password" required />
			<div class="d-flex justify-content-center">
				<input class="btn btn-secondary" type="submit" value="Log in" />
			</div>
		</form>
	</div>
</main>
<div class="space"></div>

<jsp:include page="/layout/footer.jsp" />