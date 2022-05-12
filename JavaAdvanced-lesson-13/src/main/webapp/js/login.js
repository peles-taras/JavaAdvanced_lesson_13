function showAlert() {
	$('div.alert').show();
}

$("input.registerButton").click(function() {
	let email = $("input.emailREG").val();
	let password = $("input.passwordREG").val();
	let cpassword = $("input.cpassword").val();
	let firstName = $("input.firstName").val();
	let lastName = $("input.lastName").val();

	let userRegistration = {
		email: email,
		password: password,
		cpassword: cpassword,
		firstName: firstName,
		lastName: lastName	
		
	}

	if (firstName == "" || lastName == "" || email == "" || password == "" || cpassword == "") {
		alert("You have to fill all the fields");
	} else if(password == cpassword){

		$.post("registration", userRegistration, function(data) {
			if (data == 'success') {
				$("form")[0].reset();
				/*$("input.registerButton")[1].reset();*/
				showAlert();
			}
		})
	}else{
		alert("passwords doesn't match");
	}
})

$("input.loginButton").click(function() {
	let email = $("input.email").val();
	let password = $("input.password").val();

	if (email == '' || password == '') {
		alert('Please fill all the fields!');
	} else {
		let userLogin = {
			email: email,
			password: password };
			
		$.post("login", userLogin, function(data) {
			if(data != ''){
			let customUrl = '';
			let urlContent = window.location.href.split('/');
			for(let i = 0; i< urlContent.length-1; i++){
				customUrl+=urlContent[i]+'/';
			}
			customUrl+=data.destinationUrl;
			window.location = customUrl;
			console.log(customUrl);
			}
			else{
			 alert("Wrong email or password!");
			}
		});
	}
})

