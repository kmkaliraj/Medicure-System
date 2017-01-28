
function compose(id){
	alert("compose");
	var str = "id="+id;
	xmlhttp = new XMLHttpRequest();
	xmlhttp.open("POST","../mail/compose6.jsp", true);
	xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xmlhttp.send(str);
	xmlhttp.onreadystatechange=function(){
		if(xmlhttp.readyState==4){
			var show = xmlhttp.responseText;
			document.getElementById("mainbar").innerHTML=show;
		}
	};
}

function replyMail(from,to){
	
	var str = "from="+from+"&to="+to;
	xmlhttp = new XMLHttpRequest();
	xmlhttp.open("POST","../mail/reply.jsp", true);
	xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xmlhttp.send(str);
	xmlhttp.onreadystatechange=function(){
		if(xmlhttp.readyState==4){
			var show = xmlhttp.responseText;
			document.getElementById("mainbar").innerHTML=show;
		}
	};
}

function forwardMsg(from,sub,body){
	
	var str = "from="+from+"&sub="+sub+"&body="+body;
	xmlhttp = new XMLHttpRequest();
	xmlhttp.open("POST","../mail/forward1.jsp", true);
	xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xmlhttp.send(str);
	xmlhttp.onreadystatechange=function(){
		if(xmlhttp.readyState==4){
			var show = xmlhttp.responseText;
			document.getElementById("mainbar").innerHTML=show;
		}
	};
}


function deleteinbox(id,mailid){
	alert("delete");
	var str = "id="+id+"&mailid="+mailid;
	xmlhttp = new XMLHttpRequest();
	xmlhttp.open("POST","../mail/delete.jsp", true);
	xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xmlhttp.send(str);
	xmlhttp.onreadystatechange=function(){
		
		if(xmlhttp.readyState==4){
			var show = xmlhttp.responseText;
			document.getElementById("mainbar").innerHTML=show;
		}
	};
}

function deletedrafts(id){
	var str = "id="+id;
	xmlhttp = new XMLHttpRequest();
	xmlhttp.open("POST","../mail/deletedrafts.jsp", true);
	xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xmlhttp.send(str);
	xmlhttp.onreadystatechange=function(){
		
		if(xmlhttp.readyState==4){
			var show = xmlhttp.responseText;
			document.getElementById("mainbar").innerHTML=show;
		}
	};
}

function checkmailid(mailid){

	var str = "id="+mailid;
	var show="";
	xmlhttp = new XMLHttpRequest();
	xmlhttp.open("POST","../mail/checkmailid.jsp", true);
	xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xmlhttp.send(str);
	xmlhttp.onreadystatechange=function(){
		if(xmlhttp.readyState==4){
			show = xmlhttp.responseText;
			document.getElementById("toid").innerHTML=show;
		}
	};

	var a = document.getElementById("toid").innerHTML;

	var abc = document.getElementById("chandru").value;

	
	
	check(abc,mailid);
}

function check(a,b){

	if(a=="INVALID MAIL ID" || b=="")
		{
		
		document.getElementById("send").setAttribute("disabled", "disabled");
	}
	else{
		
		document.getElementById("send").removeAttribute("disabled");
	}
}
function checkmailccid(mailid){
	var str = "id="+mailid;
	var show="";
	xmlhttp = new XMLHttpRequest();
	xmlhttp.open("POST","../mail/checkmailid.jsp", true);
	xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xmlhttp.send(str);
	xmlhttp.onreadystatechange=function(){
		if(xmlhttp.readyState==4){
			show = xmlhttp.responseText;
			document.getElementById("ccid").innerHTML=show;
		}
	};
}
function send2(from,to,cc,subject,body){

	var str = "from="+from+"&to="+to+"&cc="+cc+"&subject="+subject+"&body="+body;
	
	xmlhttp = new XMLHttpRequest();
	xmlhttp.open("POST","../mail/send.jsp", true);
	xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xmlhttp.send(str);
	xmlhttp.onreadystatechange=function(){
		if(xmlhttp.readyState==4){
			var show = xmlhttp.responseText;
			document.getElementById("mainbar").innerHTML=show;
		}
	};
}

function send1(id,from,to,cc,subject,body){
	var str = "id="+id+"&from="+from+"&to="+to+"&cc="+cc+"&subject="+subject+"&body="+body;
	
	xmlhttp = new XMLHttpRequest();
	xmlhttp.open("POST","../mail/send1.jsp", true);
	xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xmlhttp.send(str);
	xmlhttp.onreadystatechange=function(){
		if(xmlhttp.readyState==4){
			var show = xmlhttp.responseText;
			document.getElementById("mainbar").innerHTML=show;
		}
	};
}

function drafts(Eid){
	var str = "id="+Eid;
	xmlhttp = new XMLHttpRequest();
	xmlhttp.open("POST","../mail/drafts.jsp", true);
	xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xmlhttp.send(str);
	xmlhttp.onreadystatechange=function(){
		
		if(xmlhttp.readyState==4 && xmlhttp.status==200){
			var show = xmlhttp.responseText;
			document.getElementById("mainbar").innerHTML=show;
		}
	};
}

function savemsg(from,to,cc,subject,body){
	alert("save");
	var str = "from=drafts"+from+"&to="+to+"&cc="+cc+"&subject="+subject+"&body="+body;
	
	xmlhttp = new XMLHttpRequest();
	xmlhttp.open("POST","../mail/save2.jsp", true);
	xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xmlhttp.send(str);
	xmlhttp.onreadystatechange=function(){
		if(xmlhttp.readyState==4){
			var show = xmlhttp.responseText;
			document.getElementById("mainbar").innerHTML=show;
		}
	};
}
function outbox(Eid){
	var str = "id="+Eid;
	xmlhttp = new XMLHttpRequest();
	xmlhttp.open("POST","../mail/sentitems.jsp", true);
	xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xmlhttp.send(str);
	xmlhttp.onreadystatechange=function(){
	
		if(xmlhttp.readyState==4 && xmlhttp.status==200){
			var show = xmlhttp.responseText;
			document.getElementById("mainbar").innerHTML=show;
		}
	};
}
function inbox(Eid){
	var str = "id="+Eid;
	xmlhttp = new XMLHttpRequest();
	xmlhttp.open("POST","../mail/inbox20.jsp", true);
	xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xmlhttp.send(str);
	xmlhttp.onreadystatechange=function(){
		
		if(xmlhttp.readyState==4 && xmlhttp.status==200){
			var show = xmlhttp.responseText;
			document.getElementById("mainbar").innerHTML=show;
		}
	};
}
function clickLong(id){

	xmlhttp = new XMLHttpRequest();
	xmlhttp.open("POST","../mail/inboxLong2.jsp", true);
	xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xmlhttp.send("id="+id);
	xmlhttp.onreadystatechange=function(){
		if(xmlhttp.readyState==4){
			var show = xmlhttp.responseText;
			document.getElementById("long").innerHTML=show;
		}
	};
}
function clickLong1(id){

	xmlhttp = new XMLHttpRequest();
	xmlhttp.open("POST","../mail/outboxlong.jsp", true);
	xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xmlhttp.send("id="+id);
	xmlhttp.onreadystatechange=function(){
		if(xmlhttp.readyState==4){
			var show = xmlhttp.responseText;
			document.getElementById("long").innerHTML=show;
		}
	};
}
function clickLong2(id){

	xmlhttp = new XMLHttpRequest();
	xmlhttp.open("POST","../mail/draftslong.jsp", true);
	xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xmlhttp.send("id="+id);
	xmlhttp.onreadystatechange=function(){
		if(xmlhttp.readyState==4){
			var show = xmlhttp.responseText;
			document.getElementById("long").innerHTML=show;
		}
	};
}