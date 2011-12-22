<html dir="ltr">
    
    <head>
        <style type="text/css">
            body, html { font-family:helvetica,arial,sans-serif; font-size:90%; }
        </style>
        <script src="http://ajax.googleapis.com/ajax/libs/dojo/1.6/dojo/dojo.xd.js"
        djConfig="parseOnLoad: true">
        </script>
        <script type="text/javascript">
            dojo.require("dijit.form.ComboBox");
            dojo.require("dojo.data.ItemFileReadStore");
        </script>
        <script type="text/javascript">
            dojo.addOnLoad(function() {
            	
            	dojo.xhrGet({
           		 url: "services/hallo/users", // read the url: from the action="" of the <form>
           	      handleAs:"json",
           	      timeout: 5000, // give up after 5 seconds
           	      load: function(data, ioArgs){
           	    	handleResponse(data);
           	      },
           	      error: function(err, ioArgs){
                     // again, ioArgs is useful, but not in simple cases
                    alert( error );
                   }
           		});
            	
            });
            var handleResponse = function(data){
            	//alert (data.users[0].email);
            	var jsonUsers = data.users;
            	var store = new dojo.data.ItemFileReadStore({data: { identifier: "firstName",
            		   items: jsonUsers
            		 }});
            	
            	var filteringSelect = new dijit.form.ComboBox({
                    id: "stateSelect",
                    name: "user_name",
                    value: "Abani",
                    store: store,
                    domNode: "users",
                    searchAttr: "firstName"
                },
                "stateSelect");
            };
        </script>
        <link rel="stylesheet" type="text/css" href="http://ajax.googleapis.com/ajax/libs/dojo/1.6/dijit/themes/claro/claro.css"
        />
    </head>
    
    <body class=" claro ">
</div>
        <input id="stateSelect">
        <p>
            <button onClick="alert(dijit.byId('stateSelect').attr('value'))">
                Get value
            </button>
        </p>
    </body>

</html>