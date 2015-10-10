<html>
<head>
 <script type="text/javascript">
 	function registerSSE()
 	{
 		var source = new EventSource("http://192.168.1.2:8080/server-sent-event/sdfsdf.test");
 		source.addEventListener('server-time', function(e){
 			document.getElementById('ticker').innerHTML = e.data;
 		},false);
 	}
 </script>
</head>

<body onload="registerSSE()">
	<h2>Hello World!</h2>
	<div id="ticker">
	[TIME]
	</div>
</body>
</html>
