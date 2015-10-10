<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
test = <s:property value="test" /> <br/>

<table border="1">
	<s:iterator value="accountList" var="account">
		<tr>
			<td><s:property value="#account.name" /></td>
		</tr>
	</s:iterator>
</table>

</body>
</html>