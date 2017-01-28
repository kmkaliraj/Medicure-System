/** CLient Side Validation For Patient */

var patt = /^[a-zA-Z]+[ ][a-zA-Z]+$/;
var patCon = /^\d+$/;
var patOccu = /^[a-zA-Z]+[ ]*[a-zA-Z]*$/;

function validName(nameO) {

	if (nameO.match(patt)) {
		document.getElementById("a").innerHTML = "";
	} else {

		document.getElementById("a").innerHTML = "Enter vaild username(no spl characters) format:(firstName lastname)";

	}

}

function validFName(nameO) {

	if (nameO.match(patt)) {
		document.getElementById("b").innerHTML = "";
	} else {

		document.getElementById("b").innerHTML = "Enter vaild username(no spl characters) format:(firstName lastname)";

	}

}

function validSName(nameO) {

	if (nameO.match(patt)) {
		document.getElementById("c").innerHTML = "";
	} else {

		document.getElementById("c").innerHTML = "Enter vaild username(no spl characters) format:(firstName lastname)";

	}

}

function validContact(nameC) {

	if (nameC.match(patCon)) {
		document.getElementById("d").innerHTML = "";
	} else {

		document.getElementById("d").innerHTML = "Enter vaild contact(only numbers)";

	}

}

function validOccu(nameC) {

	if (nameC.match(patOccu)) {
		document.getElementById("e").innerHTML = "";
	} else {

		document.getElementById("e").innerHTML = "Enter vaild details";

	}

}

function checkMarital() {
	document.getElementById("spouse").removeAttribute("disabled");
}
function checkMarital1() {
	document.getElementById("spouse").setAttribute("disabled", "disabled");
}

function validate() {

	if (document.frm.patName.value == "")

	{
		alert("Enter a username");
		document.frm.patName.focus();
		return;

	} else if (!document.frm.patFather.value.match(patt)) {
		alert("Please enter a valid name(no spl characters)");
		return;

	}

	else if (!document.frm.patContact.value.match(patCon)) {
		alert("Please enter a valid Contact(no spl characters :only numbers)");
		return;

	} else if (!document.frm.patOccupation.value.match(patOccu)) {
		alert("Please enter a valid details)");
		return;

	} else {
		
		document.getElementById("SUB").removeAttribute("disabled");
	}

	// window.location.href="generate.pass";

}
