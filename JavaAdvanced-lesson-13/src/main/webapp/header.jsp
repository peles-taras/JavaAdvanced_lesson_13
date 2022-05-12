<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>header</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet" href="css/header.css">

</head>
<body>
<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-dark static-top">
  <div class="container">
  <div class="logoDiv">
    <a  class="navbar-brand" href="${pageContext.request.contextPath}/cabinet.jsp">
    <b class="logoName">SHOP</b> 
     </a></div>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <a class="bucketHolder" href="${pageContext.request.contextPath}/bucket.jsp" role="button">
    <img class="headerBucket" src="photos/redBucket.png"/></a>
      <ul class="navbar-nav ms-auto">
        <li class="nav-item">
          <a class="loggedIn nav-link active" aria-current="page" href="#">Logged in as <b class="loggedInName">${userEmail}</b></a>
        </li>
        <li class="nav-item">
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Menu
          </a>
          <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
            <li><a class="createProductForm dropdown-item" href="${pageContext.request.contextPath}/createProduct.jsp">Create product</a></li>
            <li>
              <hr class="dropdown-divider">
            </li>
            <li><button class="logoutButton dropdown-item">Logout</button></li>
          </ul>
        </li>
      </ul>
    </div>
  </div>
</nav>

<script src="js/ServerCalls.js"></script> 

</body>
</html>