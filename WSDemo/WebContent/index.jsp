<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="shortcut icon" href="logo.ico" type="image/x-icon" />
<title>Chat App</title>
</head>
<body>
	Server-Push page powered by WebSocket
	<div>
		<label for="mText">Enter Message </label>
		<input type="text" disabled="disabled" id="mText" />
		<button id="conB" onclick="connect(this)">Connect</button>
		<button id="sndB" disabled="disabled" onclick="sendMsg()">Send Message</button>
		<button id="clsB" disabled="disabled" onclick="closeWS(this)">Close</button>
	</div>
	<div>
		<label for="msg">Server Message : </label>
		<span id="msg"></span>
	</div>
	
</body>
<script type="text/javascript">
	var ws;
	var host = "ws://localhost:8080/WSDemo/ecm";
	connect = function(obj){
		obj.disabled = true;
		document.getElementById('clsB').disabled = false;
		document.getElementById('mText').disabled = false;
		document.getElementById('sndB').disabled = false;
		ws = new WebSocket(host);
		ws.onopen = function () {
			alert ('connected');
		};
		ws.onmessage = function (event) {
			document.getElementById('msg').innerHTML = document.getElementById('msg').innerHTML + '<br />' + event.data;
		};
	};
	sendMsg = function() {
		var msg = document.getElementById('mText').value;
		if (msg.isEmpty()){
			alert("Please enter some message");
		}else{
			ws.send(msg);	
			document.getElementById('mText').value = "";
		}
	};
	closeWS = function(obj) {
		obj.disabled = true;
		document.getElementById('sndB').disabled = true;
		document.getElementById('conB').disabled = false;
		document.getElementById('mText').disabled = true;
		ws.close();
	};
	String.prototype.isEmpty = function(){
		var bIsEmpty = false;
		if (this.length == 0){
			bIsEmpty = true;
		}
		return bIsEmpty;
	};
	generateMsg = function(){
		var chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXTZabcdefghiklmnopqrstuvwxyz";
		var string_length = 8;
		var randomstring = '';
		for (var i=0; i<string_length; i++) {
			var rnum = Math.floor(Math.random() * chars.length);
			randomstring += chars.substring(rnum,rnum+1);
		}
		return randomstring;
	};
</script>
</html>