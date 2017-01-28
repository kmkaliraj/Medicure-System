	var patt = /^[a-zA-Z]+[ ][a-zA-Z]+$/;
	var patQuali = /^\D+$/;
	var patSpec = /^[a-zA-Z]+[ ]?[a-zA-Z]+?$/;
	var patExp = /^[0-9][0-9]?$/;

	/**  CLIENT SIDE VALIDATION FOR DOCTOR*/
	function validName(nameO) {
		if (nameO.match(patt)) {
			document.getElementById("a").innerHTML = "";
		} else {
			document.getElementById("a").innerHTML = "Enter vaild username(no spl characters)<br> format:(firstName lastname)";
		}
	}

	function validSpecl(nameT) {
		if (nameT.match(patSpec)) {
			document.getElementById("b").innerHTML = "";
		} else {
			document.getElementById("b").innerHTML = "Enter vaild detail(no spl characters) ";
		}
	}

	function validExp(nameTh) {
		if (nameTh.match(patExp)) {
			document.getElementById("exp").innerHTML = "";
		} else {
			document.getElementById("exp").innerHTML = "Enter vaild detail(only numbers) ";
		}
	}

	function validQuali(nameF) {
		if (nameF.match(patQuali)) {
			document.getElementById("qual").innerHTML = "";
		} else {
			document.getElementById("qual").innerHTML = "Enter vaild detail ";
		}
	}

	/**   VALIDATING DATA ENTERED*/

	function validateData() {
		
		if (document.frm.docName.value == "")
		{
			//document.getElementById("a").innerHTML="Enter a valid user name(no spl chara)";
			alert("Enter a username");
			document.frm.docName.focus();
	
			return;
			
		}

		else if (!document.frm.docName.value.match(patt)) {
			alert("Please enter a valid user name(no spl characters)");
			return;
		}

		else if (!document.frm.docSpeciality.value.match(patSpec)) {
			alert("Please enter a Speciality");
			return;
		}

		else if (!document.frm.docQualification.value.match(patQuali)) {
			alert("Please enter a Qualification");
			return;
		}
		
		else if (!document.frm.docExperience.value.match(patExp)) {
			alert("Please enter a Experience");
			return;

		} 
		else {
			document.getElementById("sub").removeAttribute("disabled");
		
		}

		//window.location.href="generate.pass";

	}
	
	
	

