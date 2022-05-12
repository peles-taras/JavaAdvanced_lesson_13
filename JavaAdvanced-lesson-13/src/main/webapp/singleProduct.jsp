<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>${product.name}</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link rel="stylesheet" href="css/cabinet.css">
<link rel="stylesheet" href="css/modal.css">

</head>
<body onload="hideModal()">
<jsp:include page="header.jsp" />

<div class="product chosenProduct">
<span class="product__price">${product.price}$</span> 
  <img class="product__image" src="	https://via.placeholder.com/194x228/87CEFA">
  <h1 class="product__title">${product.name}</h1>
  <hr />
  <p>${product.description}</p>
<!--   <button type="button" class="product__btn btn">Subscribe</button>  -->
</div>

<div class="content-wrapper">
 
  <label>
    <span class="myBtn">Subscribe</span>
    <input type="checkbox" />
    <div class="confirm-modal">
      <form>
      <%-- formaction="${pageContext.request.contextPath}/cabinet.jsp" --%>
        <p>Are you absolutely sure you want to subscribe to '${product.name}' for ${product.price}$?</p>
        <button type="button" class="myBtn modalBtnYes" product-id="${product.id}" >Yes</button>
        <button type="button" class="myBtn modalBtnNo">No</button>
      </form>
    </div>
  </label>
  
</div>


<jsp:include page="footer.jsp" />

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"
		integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut"
		crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
	
	<script src="js/modal.js"></script>
	
</body>
</html>