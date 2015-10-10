<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<title>User Information</title>
<script>
	function go(url) {
		var xmlhttp;
		if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
			xmlhttp = new XMLHttpRequest();
		} else {// code for IE6, IE5
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				document.getElementById("myDiv").innerHTML = xmlhttp.responseText;
			}
		}
		xmlhttp.open("GET", url, true);
		xmlhttp.send();
	}
</script>
</head>


<body>
	<h2>Autonumber example</h2>
	<s:form namespace="/str" action="getAutonumber" method="post">
		<s:textfield label="Klucz" name="autonumber.key" value="numer"/> <>
		<s:submit value="Wyznacz" />
		<s:textfield label="Wartość" name="autonumber.value" />
	</s:form>
	
</body>
</html>