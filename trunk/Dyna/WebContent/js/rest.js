/**
 * 
 */
function getXmlHttpRequest() {
	try
	{
		// Firefox, Opera 8.0+, Safari
		return new XMLHttpRequest();
	}
	catch (e)
	{
		// Internet Explorer
		try
		{
			return new ActiveXObject("Msxml2.XMLHTTP");
		}
		catch (e)
		{
			try
			{
				return new ActiveXObject("Microsoft.XMLHTTP");
			}
			catch (e)
			{
				alert("Your browser does not support AJAX!");
				return null;
			}
		}
	}
}
function getMessages()
{
	var xmlHttp = getXmlHttpRequest();
	xmlHttp.onreadystatechange=function() {
		if(xmlHttp.readyState==4)
		{
			// document.getElementById("output").innerHTML=xmlHttp.responseText;
			alert (xmlHttp.responseText);
		}
	};
	xmlHttp.open("GET","services/hallo/users/25",true);
	xmlHttp.send(null);
}
function addMessage(message)
{
	var xmlHttp = getXmlHttpRequest();
	xmlHttp.onreadystatechange=function()
	{
		if(xmlHttp.readyState==4)
		{
			alert (xmlHttp.responseText);
		}
	};
	xmlHttp.open("PUT","services/hallo/add",true);
	xmlHttp.send(message);
}
(function($,undefined){
	  '$:nomunge'; // Used by YUI compressor.
	  
	  $.fn.serializeObject = function(){
	    var obj = {};
	    
	    $.each( this.serializeArray(), function(i,o){
	      var n = o.name,
	        v = o.value;
	        
	        obj[n] = obj[n] === undefined ? v
	          : $.isArray( obj[n] ) ? obj[n].concat( v )
	          : [ obj[n], v ];
	    });
	    
	    return obj;
	  };
	  
	})(jQuery);