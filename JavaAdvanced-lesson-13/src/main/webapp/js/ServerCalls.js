function showAlert() {
	$("div.alert").show();
}

$("button.createProduct").click(function(){
	let name = $("input.name").val();
	let price = $("input.price").val();
	let description = $("textarea.description").val();
	
	let product = {
		name: name,
		price: price,
		description: description	
	}
	if (name == "" || price == "" || description == "") {
		alert("You have to fill all the fields");
	} else{
		$.post("product", product, function(data) {
			if (data == "success") {
				$("form")[0].reset();
				showAlert();	
			}
		})
		}
})

$("button.logoutButton").click(function(){
	$.get("logout",function(data){
			if (data != '') {
			var customUrl = '';
			var urlContent = window.location.href.split('/');
			for (var i = 0; i < urlContent.length - 1; i++) {
				customUrl += urlContent[i] + '/'
			}
			customUrl += data;
			window.location = customUrl;
		}	
	})
})


	




