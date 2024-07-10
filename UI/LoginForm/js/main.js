"use strict";


if(localStorage.getItem('loggedIn') === "true"){
	document.getElementById('container').insertAdjacentHTML("afterbegin",getAlreadyLoggedInForm());
	document.getElementById('button-logout').addEventListener('click', () => {
		document.getElementById('form-login').remove();
		localStorage.setItem('loggedIn', false);
		var xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function() {
  		if (this.readyState == 4 && this.status == 200) {
			console.log(this.response);
    		
  }
};
		
		xhttp.open("GET", "http://localhost:8080/data/get/address", true);
		xhttp.send();
		// location.reload();
	});

}else{
	document.getElementById('container').insertAdjacentHTML("afterbegin",getLogInForm());
	document.getElementById('button-login').addEventListener('click', () => {
		document.getElementById('form-login').remove();
		localStorage.setItem('loggedIn', true);
		location.reload();
	 });
}

 function getLogInForm(){
	let result = `
	<div class="form-container sign-in-container" id="form-login">
		<form action="#">
			<h1>Log in</h1>
			<div></div>
			<span>with valid account</span>
			<input type="email" placeholder="Email" />
			<input type="password" placeholder="Password" />
			<a href="#">Forgot your password?</a>
			<button id="button-login">Authorize</button>
		</form>
	</div>
	`;
		return result
 }

 function getAlreadyLoggedInForm(){
	let result = `
	<div class="form-container sign-in-container" id="form-login">
		<form action="#">
			<h1>Log out</h1>
			<button id="button-logout">Log out</button>
		</form>
	</div>
	`;
	return result
 }