<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="/Dyna/js/jquery-1.6.2.min.js"></script>
<script type="text/javascript" src="/Dyna/js/rest.js"></script>
</head>
<body>
	<form>
	  <div>First Name<input type="text" name="firstName" id="firstName" /></div>
	  <div>Last Name<input type="text" name="lastName" id="lastName" /></div>
	  <div>E-mail<input type="text" name="email" id="email" /></div>
	  <div>User Name<input type="text" name="username" id="username" /></div>
	  <div>Password<input type="password" name="password" id="password" /></div>
	   <input type="submit" name="g" value="Submit" id="g" />
	</form>	  
</body>
<script type="text/javascript">
$('form').submit(function() {
		var obj = $(this).serializeArray();
		var jsData = '{"email":"abani@in.com","firstName":"abani","id":"12","lastName":"behera","password":"behera","username":"abani"}';
	 	//var jsonData = $(this).serializeArray();
	 	//var obj = $.parseJSON(jsData);
	 	var data = $(this).serializeObject();
	 	var json = $.parseJSON(data);
	 	alert (json);
	 	$.each( $(this).serializeArray(), function(i,o){
	      var n = o.name,
	        v = o.value;
	      alert (n);
	 	}); 
	 	$.ajax({
		  type: 'POST',
		  url: 'services/hallo/add',
		  data: json,
		  contentType: "application/json; charset=utf-8",
		  dataType: 'json',
		  success: function(msg){
			   alert (msg);
		  }
		 
		});
	 	return false;
	});
</script>
</html>