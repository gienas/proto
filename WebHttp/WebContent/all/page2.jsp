

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%><jsp:include page="../header.jsp"/>
Page2
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="simple" uri="MyLibrary" %>
<%

	List lista = new ArrayList();
	lista.add("ala");
	lista.add("ola");
	lista.add("ela");
	request.setAttribute("lista", lista);
%>

<my:go paramsList="${lista}" id="idvalue" >
it is body of my tag
</my:go>

<br/><br/>
My Simple tag: <simple:three>body</simple:three>


<form method="post" action="page3.jsp">
	name: <input type="text" name="name" /> <br/>
	id: <input type="text" name="id" /> <br/>
	<input type="submit">
</form>
<jsp:include page="../foother.jsp"/>
