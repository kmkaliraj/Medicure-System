//for doctor
function docUpdate(){
	xmlhttp = new XMLHttpRequest();
	xmlhttp.open("POST","../../DoctorUpdateDisplay", true);
	xmlhttp.send();
	xmlhttp.onreadystatechange=function(){
		if(xmlhttp.readyState==4){
			var show = xmlhttp.responseText;
			document.getElementById("mainbar").innerHTML=show;
		}
	};
}
function docView(){
	xmlhttp = new XMLHttpRequest();
	xmlhttp.open("POST","../../ViewDoctorProfile8", true);
	xmlhttp.send();
	xmlhttp.onreadystatechange=function(){
		if(xmlhttp.readyState==4){
			var show = xmlhttp.responseText;
			document.getElementById("mainbar").innerHTML=show;
		}
	};
}
function patRecUpdate(){
	xmlhttp = new XMLHttpRequest();
	xmlhttp.open("GET", "patientRecordUpdate.jsp", true);
	xmlhttp.send();
	xmlhttp.onreadystatechange=function(){
		if(xmlhttp.readyState==4){
			var show = xmlhttp.responseText;
			document.getElementById("mainbar").innerHTML=show;
		}
	};
}
function patRecView(){
	xmlhttp = new XMLHttpRequest();
	xmlhttp.open("GET", "patientRecordView.jsp", true);
	xmlhttp.send();
	xmlhttp.onreadystatechange=function(){
		if(xmlhttp.readyState==4){
			var show = xmlhttp.responseText;
			document.getElementById("mainbar").innerHTML=show;
		}
	};
}
function docUpdatePrescription(){
	xmlhttp = new XMLHttpRequest();
	xmlhttp.open("GET", "OrderDrug.jsp", true);
	xmlhttp.send();
	xmlhttp.onreadystatechange=function(){
		if(xmlhttp.readyState==4){
			var show = xmlhttp.responseText;
			document.getElementById("mainbar").innerHTML=show;
		}
	};
}
//for receptionist
function recUpdate(){
	xmlhttp = new XMLHttpRequest();
	xmlhttp.open("POST", "../../ReceptionistUpdateRecord", true);
	xmlhttp.send();
	xmlhttp.onreadystatechange=function(){
		if(xmlhttp.readyState==4){
			var show = xmlhttp.responseText;
			document.getElementById("mainbar").innerHTML=show;
		}
	};
}
function recView(){
	xmlhttp = new XMLHttpRequest();
	xmlhttp.open("POST", "../../ReceptionistViewProfile", true);
	xmlhttp.send();
	xmlhttp.onreadystatechange=function(){
		if(xmlhttp.readyState==4){
			var show = xmlhttp.responseText;
			document.getElementById("mainbar").innerHTML=show;
		}
	};
}
function recPatientRegister(){
	xmlhttp = new XMLHttpRequest();
	xmlhttp.open("GET", "patientReg.jsp", true);
	xmlhttp.send();
	xmlhttp.onreadystatechange=function(){
		if(xmlhttp.readyState==4){
			var show = xmlhttp.responseText;
			document.getElementById("mainbar").innerHTML=show;
		}
	};
}

//patient related scripts
function patientView(){
	xmlhttp = new XMLHttpRequest();
	xmlhttp.open("GET", "../../ViewPatientProfile", true);
	xmlhttp.send();
	xmlhttp.onreadystatechange=function(){
		if(xmlhttp.readyState==4){
			var show = xmlhttp.responseText;
			document.getElementById("mainbar").innerHTML=show;
		}
	};
}
function patientUpdate(){
	xmlhttp = new XMLHttpRequest();
	xmlhttp.open("POST", "../../ViewPatientRecord", true);
	xmlhttp.send();
	xmlhttp.onreadystatechange=function(){
		if(xmlhttp.readyState==4){
			var show = xmlhttp.responseText;
			document.getElementById("mainbar").innerHTML=show;
		}
	};
}
function patientViewRecord(){
	xmlhttp = new XMLHttpRequest();
	xmlhttp.open("GET", "patientViewRecord.jsp", true);
	xmlhttp.send();
	xmlhttp.onreadystatechange=function(){
		if(xmlhttp.readyState==4){
			var show = xmlhttp.responseText;
			document.getElementById("mainbar").innerHTML=show;
		}
	};
}

//for admin
function adminDocReg(){
	xmlhttp = new XMLHttpRequest();
	xmlhttp.open("GET", "doctorReg.jsp", true);
	xmlhttp.send();
	xmlhttp.onreadystatechange=function(){
		if(xmlhttp.readyState==4){
			var show = xmlhttp.responseText;
			document.getElementById("body").innerHTML=show;
		}
	};
}
function adminRecReg(){
	xmlhttp = new XMLHttpRequest();
	xmlhttp.open("GET", "recepReg.jsp", true);
	xmlhttp.send();
	xmlhttp.onreadystatechange=function(){
		if(xmlhttp.readyState==4){
			var show = xmlhttp.responseText;
			document.getElementById("body").innerHTML=show;
		}
	};
}
function adminSalReg(){
	xmlhttp = new XMLHttpRequest();
	xmlhttp.open("GET", "salesmanReg.jsp", true);
	xmlhttp.send();
	xmlhttp.onreadystatechange=function(){
		if(xmlhttp.readyState==4){
			var show = xmlhttp.responseText;
			document.getElementById("body").innerHTML=show;
		}
	};
}
function adminSupReg(){
	xmlhttp = new XMLHttpRequest();
	xmlhttp.open("GET", "supplierReg.jsp", true);
	xmlhttp.send();
	xmlhttp.onreadystatechange=function(){
		if(xmlhttp.readyState==4){
			var show = xmlhttp.responseText;
			document.getElementById("body").innerHTML=show;
		}
	};
}
//For Admin to Remove Accounts
function adminDocRemove(){
	xmlhttp = new XMLHttpRequest();
	xmlhttp.open("GET", "doctorRemove.jsp", true);
	xmlhttp.send();
	xmlhttp.onreadystatechange=function(){
		if(xmlhttp.readyState==4){
			var show = xmlhttp.responseText;
			document.getElementById("body").innerHTML=show;
		}
	};
}
function adminRecRemove(){
	xmlhttp = new XMLHttpRequest();
	xmlhttp.open("GET", "recepRemove.jsp", true);
	xmlhttp.send();
	xmlhttp.onreadystatechange=function(){
		if(xmlhttp.readyState==4){
			var show = xmlhttp.responseText;
			document.getElementById("body").innerHTML=show;
		}
	};
}
function adminSalRemove(){
	xmlhttp = new XMLHttpRequest();
	xmlhttp.open("GET", "salesmanRemove.jsp", true);
	xmlhttp.send();
	xmlhttp.onreadystatechange=function(){
		if(xmlhttp.readyState==4){
			var show = xmlhttp.responseText;
			document.getElementById("body").innerHTML=show;
		}
	};
}
function adminSupRemove(){
	xmlhttp = new XMLHttpRequest();
	xmlhttp.open("GET", "supplierRemove.jsp", true);
	xmlhttp.send();
	xmlhttp.onreadystatechange=function(){
		if(xmlhttp.readyState==4){
			var show = xmlhttp.responseText;
			document.getElementById("body").innerHTML=show;
		}
	};
}
function adminPatRemove(){
	xmlhttp = new XMLHttpRequest();
	xmlhttp.open("GET", "patientRemove.jsp", true);
	xmlhttp.send();
	xmlhttp.onreadystatechange=function(){
		if(xmlhttp.readyState==4){
			var show = xmlhttp.responseText;
			document.getElementById("body").innerHTML=show;
		}
	};
}

//for supplier
function supView(){
	xmlhttp = new XMLHttpRequest();
	xmlhttp.open("GET", "../../ViewSupplierProfile", true);
	xmlhttp.send();
	xmlhttp.onreadystatechange=function(){
		if(xmlhttp.readyState==4){
			var show = xmlhttp.responseText;
			document.getElementById("mainbar").innerHTML=show;
		}
	};
}
function supUpdate(){
	xmlhttp = new XMLHttpRequest();
	xmlhttp.open("GET", "supUpdate.jsp", true);
	xmlhttp.send();
	xmlhttp.onreadystatechange=function(){
		if(xmlhttp.readyState==4){
			var show = xmlhttp.responseText;
			document.getElementById("mainbar").innerHTML=show;
		}
	};
}
function supOrderStatus(){
	xmlhttp = new XMLHttpRequest();
	xmlhttp.open("GET", "supViewStatus.jsp", true);
	xmlhttp.send();
	xmlhttp.onreadystatechange=function(){
		if(xmlhttp.readyState==4){
			var show = xmlhttp.responseText;
			document.getElementById("mainbar").innerHTML=show;
		}
	};
}