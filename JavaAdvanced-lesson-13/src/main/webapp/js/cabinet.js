let products = null;

$.get("products", function(data) {
	if (data != '') {
		products = data;
	}
}).done(function() {
	let cardsContent = "";
	jQuery.each(products, function(i, value) {
		cardsContent += "<div class= 'product'>"
			+ "<span class= 'product__price' style='white-space: pre-line'>" + value.price + "$</span>"
			+ "<img class= 'product__image' src='https://via.placeholder.com/194x228/87CEFA'>"
			+ "<h1 class= 'product__title'>" + value.name + "</h1>"
			+ "<hr />"
			+ "<p>" + value.description + "</p>"
			+ "<a href='product?id=" + value.id + "'class='product__btn btn'>Read Now</a>"
			+ "</div>"
	});
	$('#productCards').html(cardsContent);
}).done(function() {
	let userRole = null;
	$.get("user-role", function(data) {
		if (data != '') {
			userRole = data;
		}
	}).done(function() {
		if (userRole === "ADMINISTRATOR") {
			$("span.myBtn").hide();
			$("a.bucketHolder").hide();
		}
		else{
			$("a.createProductForm.dropdown-item").hide();
		}
	});
})
