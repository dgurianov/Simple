"use strict";

function getOneRow(id,street,city,country,houseNumber){
	return`
	<tr>
		<td>${id}</td>
		<td>${street}</td>
		<td>${city}</td>
		<td>${country}</td>
		<td>${houseNumber}</td>
	</tr>`;
}




let table = document.getElementById("tbody1");
var xhttp  = new XMLHttpRequest();
xhttp.onreadystatechange = function(){
	if(this.readyState == 4 && this.status == 200){
		let data = JSON.parse(this.response);
		data.entities.forEach(element => {
			table.insertAdjacentHTML("afterbegin", getOneRow(element.id,element.street,element.city,element.country,element.houseNumber));

		});
	}
}
	





localStorage.setItem('scrollingOffset', 0);

xhttp.open("GET", "http://localhost:8080/data/get/address?offset=0&amount=4",true);
xhttp.send();



addEventListener("scroll",(event)=> {
	let table = document.getElementById("tbody1");
	xhttp.onreadystatechange = function(){
		if(this.readyState == 4 && this.status == 200){
			let data = JSON.parse(this.response);
			data.entities.forEach(element => {
				table.insertAdjacentHTML("afterbegin", getOneRow(element.id,element.street,element.city,element.country,element.houseNumber));
	
			});
		}
	};
	let offset = +localStorage.getItem('scrollingOffset');
	xhttp.open("GET", `http://localhost:8080/data/get/address?offset=${offset}&amount=4`,true);
	xhttp.send();

	localStorage.setItem('scrollingOffset', offset+1);

},{passive:true})








// if(localStorage.getItem('loggedIn') === "true"){
// 	document.getElementById('container').insertAdjacentHTML("afterbegin",getAlreadyLoggedInForm());
// 	document.getElementById('button-logout').addEventListener('click', () => {
// 		document.getElementById('form-login').remove();
// 		localStorage.setItem('loggedIn', false);
// 		var xhttp = new XMLHttpRequest();
// 		xhttp.onreadystatechange = function() {
//   		if (this.readyState == 4 && this.status == 200) {
// 			console.log(this.response);
    		
//   }
// };
		
// 		xhttp.open("GET", "http://localhost:8080/data/get/address", true);
// 		xhttp.send();
// 		// location.reload();
// 	});

// }else{
// 	document.getElementById('container').insertAdjacentHTML("afterbegin",getLogInForm());
// 	document.getElementById('button-login').addEventListener('click', () => {
// 		document.getElementById('form-login').remove();
// 		localStorage.setItem('loggedIn', true);
// 		location.reload();
// 	 });
// }

 