<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Jquery Autocomplete</title>
	<link rel="stylesheet" href="/Dyna/themes/base/jquery.ui.all.css">
	<link rel="stylesheet" href="/Dyna/themes/smoothness/demo.css">
	<script src="/Dyna/js/jquery-1.6.2.min.js"></script>
	<script src="/Dyna/ui/jquery.ui.core.js"></script>
	<script src="/Dyna/ui/jquery.ui.widget.js"></script>
	<script src="/Dyna/ui/jquery.ui.position.js"></script>
	<script src="/Dyna/ui/jquery.ui.autocomplete.js"></script>
	<style>
		.ui-autocomplete-loading { background: white url('themes/smoothness/images/ui-anim_basic_16x16.gif') right center no-repeat; }
		#city { width: 25em; }
	</style>
</head>
<body>
	<div class="demo">
		<div class="ui-widget">
			<label for="city">Name : </label>
			<input id="city" />
			Powered by ReST
		</div>
		<div class="ui-widget" style="margin-top:5em; font-family:Arial">
			Result:
			<div id="log" style="height: 200px; width: 300px; overflow: auto;" class="ui-widget-content"></div>
		</div>
	</div><!-- End demo -->
</body>
<script type="text/javascript">
$(function() {
	function log( message ) {
		$( "<div/>" ).text( message ).prependTo( "#log" );
		$( "#log" ).attr( "scrollTop", 0 );
	}
	$( "#city" ).autocomplete({
		source: function( request, response ) {
			$.ajax({
				url: "services/hallo/user",
				dataType: "json",
				data: {
					featureClass: "P",
					style: "full",
					maxRows: 12,
					id: request.term
				},
				success: function( data ) {
					response( $.map( data.users, function( item ) {
						return {
							label: item.firstName,
							value: item.firstName
						};
					}));
				},
				error : function (qXHR, textStatus, errorThrown){
					alert ('error ' + textStatus);
				}
			});
		},
		minLength: 1,
		select: function( event, ui ) {
			log( ui.item ?
				"Selected: " + ui.item.label :
				"Nothing selected, input was " + this.value);
		},
		open: function() {
			$( this ).removeClass( "ui-corner-all" ).addClass( "ui-corner-top" );
		},
		close: function() {
			$( this ).removeClass( "ui-corner-top" ).addClass( "ui-corner-all" );
		}
	});
});
</script>
</html>