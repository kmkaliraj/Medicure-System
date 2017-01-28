var patt = /^[a-zA-Z]+[ ][a-zA-Z]+$/;

/** Client Side Validation For Receptionist*/
function validName(nameO) {
	if (nameO.match(patt)) {
		document.getElementById("a").innerHTML = "";
	} else {
		document.getElementById("a").innerHTML = "Enter vaild username(no spl characters)<br> format:(firstName lastname)";
	}
}


function validateRec() {
	if (document.frm.recipName.value == "")
	{
		//document.getElementById("a").innerHTML="Enter a valid user name(no spl chara)";
		alert("Enter a username");
		document.frm.recipName.focus();
		document.getElementById("sub").setAttribute("disabled","disabled");
		return;
		
	}

	else if (!document.frm.recipName.value.match(patt)) {
		alert("Please enter a valid user name(no spl characters)");
		document.getElementById("sub").setAttribute("disabled","disabled");
		return;
	}

	
	else {
		document.getElementById("sub").removeAttribute("disabled");
	}

	//window.location.href="generate.pass";

}


		