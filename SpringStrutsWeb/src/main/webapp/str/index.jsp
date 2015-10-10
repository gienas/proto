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
	
	function sendMsgLoop()
	{
		for (var i=0;i<100000;i++)
		{ 	
		 go('/SpringStrutsWeb/str/sendRightEmail');
		}
	}
	
</script>
</head>


<body>
	tabela uzytkownikow:
	<table border="1">
		<s:iterator value="users" var="user">
			<tr>
				<td><s:property value="#user.firstName" /></td>
				<td><s:property value="#user.lastName" /></td>
				<td><s:property value="#user.email" /></td>
				<td><a href="editUser?user.id=<s:property value="#user.id" />">edit</a></td>
				<td><a
					href="deleteUser?user.id=<s:property value="#user.id" />">delete</a></td>
			</tr>
		</s:iterator>
	</table>

	<br />
	<s:form namespace="/str" action="updateUser" method="post">
		<s:textfield label="First Name" name="user.firstName" />
		<s:textfield label="Last Name" name="user.lastName" />
		<s:textfield label="Email Address" name="user.email" />
		<s:password label="Password" name="user.password" />
		<s:hidden name="user.id" />
116 CHAPTER 5 n DATA MANIPULATION
<s:if test="email==null">
			<s:submit value="Register" />
		</s:if>
		<s:else>
			<s:submit value="Update" />
		</s:else>
	</s:form>

	<br /> first name:
	<s:property value="firstName" />
	<br/>
	<h2>Messaging example</h2>
	<button onclick="sendMsgLoop()" > Wyslij 1000 wiadomości</button>
	<button onclick="go('/SpringStrutsWeb/str/sendWrongEmail')" > Wyślij wiadomosc blednie</button>
	<button onclick="go('/SpringStrutsWeb/str/msgstop')" > Stop przetwarzanie msg</button>
	<button onclick="go('/SpringStrutsWeb/str/msgstart')" > Start przetwarzanie msg</button>
	<button onclick="go('/SpringStrutsWeb/str/msgstatus')" > Czy aktywne przetwarzanie</button>
	<div id="myDiv" />
	<br/>
	
	
	
</body>
</html>