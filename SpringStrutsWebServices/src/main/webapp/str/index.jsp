<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<title>User Information</title>
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
			<td><a href="deleteUser?user.id=<s:property value="#user.id" />">delete</a></td>
		</tr>
	</s:iterator>
</table>

<br />
<s:form namespace="/str" action="updateUser" method="post">
	<s:textfield label="First Name" name="user.firstName" />
	<s:textfield label="Last Name" name="user.lastName" />
	<s:textfield label="Email Address" name="user.email" />
	<s:password label="Password" name="user.password" />
	<s:hidden name="user.id"/>
116 CHAPTER 5 n DATA MANIPULATION
<s:if test="email==null">
		<s:submit value="Register" />
	</s:if>
	<s:else>
		<s:submit value="Update" />
	</s:else>
</s:form>


<br />
first name:
<s:property value="firstName" />

</body>
</html>