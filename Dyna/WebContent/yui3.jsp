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
	<div id="pizza" class="dt-example"></div>
</body>
<script type="text/javascript">
YUI().use("datatable-base", "node", "io", "dump", "json-parse", function(Y) {
	 Y.io("services/hallo/users", callback);
	 var messages = [];
	 var callback = {
			 timeout : 3000,
			 on : {
				 success : function (x,o) {
					 messages = Y.JSON.parse(o.responseText);
					 alert (messages);
				 },
				 failure : function (x,o) {
			         alert("Async call failed!");
			     }
			 }
	 };
	 alert(messages);
    var cols = [
        { key: "mfr_parts_database_id", label: "Mfr Part ID", abbr: "ID"},
        { key: "mfr_parts_database_name", label: "Mfr Part Name", abbr: "Name"},
        { key: "mfr_parts_database_price", label: "Wholesale Price", abbr: "Price"}
    ],
    data = [
        { mfr_parts_database_id: "ga_3475", mfr_parts_database_name: "gadget", mfr_parts_database_price: "$6.99"},
        { mfr_parts_database_id: "sp_9980", mfr_parts_database_name: "sprocket", mfr_parts_database_price: "$3.75"},
        { mfr_parts_database_id: "wi_0650", mfr_parts_database_name: "widget", mfr_parts_database_price: "$4.25"}
    ],
    dt = new Y.DataTable.Base({
        columnset: cols,
        recordset: data,
        summary: "Price sheet for inventory parts",
        caption: "These columns have labels and abbrs"
    }).render("#pizza");
});

</script>
</html>