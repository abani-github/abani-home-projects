<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="/Dyna/css/fonts-min.css" /> 
<script type="text/javascript" src="/Dyna/js/yui-min.js"></script>
</head>
<body class="yui3-skin-sam  yui-skin-sam">
	<div id="demo"> 
	  <label for="ac-input">Enter a username:</label><br> 
	  <input id="ac-input" type="text"> 
	</div> 
</body>
<script type="text/javascript">
YUI({ filter: 'raw' }).use("autocomplete", "autocomplete-highlighters", function (Y) {
  Y.one('#ac-input').plug(Y.Plugin.AutoComplete, {
    resultHighlighter: 'phraseMatch',
    resultListLocator: 'users',
    resultTextLocator: 'firstName',
   // source: 'http://github.com/api/v2/json/user/search/{query}?callback={callback}'
    source:	'services/hallo/users/{query}'
  });
});
</script>
</html>