var patt = /^[a-zA-Z]+[ ][a-zA-Z]+$/;

/** Client Side Validation For Supplier*/
function validName(nameO) {
	if (nameO.match(patt)) {
		document.getElementById("a").innerHTML = "";
	} else {
		document.getElementById("a").innerHTML = "Enter vaild username(no spl characters)<br> format:(firstName lastname)";
	}
}


function validate() {
	if (document.frm.supplierName.value == "")
	{
		//document.getElementById("a").innerHTML="Enter a valid user name(no spl chara)";
		alert("Enter a username");
		document.frm.supplierName.focus();
		document.getElementById("sub").setAttribute("disabled","disabled");
		return;
		
	}

	else if (!document.frm.supplierName.value.match(patt)) {
		alert("Please enter a valid user name(no spl characters)");
		document.getElementById("sub").setAttribute("disabled","disabled");
		return;
	}

	
	else {
		document.getElementById("sub").removeAttribute("disabled");
	}

	//window.location.href="generate.pass";

}


		