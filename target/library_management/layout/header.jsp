<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" errorPage="error.jsp"%>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <script defer src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
    <style><%@include file="/resources/style.css"%></style>
    <title>Library</title>
  </head>
  <body>
 	<header>
      <nav class="navbar fixed-top">
        <div class="nav__left">
          <h3>Library</h3>
        </div>
        <div class="nav__right">
          <a href="/library_management/">Home</a>
          <% if(session.getAttribute("user")==null){ 
          		 out.write("<a href=\"./login\">Login</a>");
          	 }
          %>
          <% if(session.getAttribute("user")!=null){
          		 out.write("<a href=\"./logout\">Logout</a>");
          	 }
          %>
        </div>
      </nav>
   </header>
    <img
      class="main__banner"
      src="https://i.postimg.cc/mZdDqyM6/pexels-pixabay-159711.jpg"
      alt=""
    />