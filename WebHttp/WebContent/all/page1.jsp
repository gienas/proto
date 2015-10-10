<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../header.jsp" />
<%@ page import="listners.*" %>
<%
	pageContext.setAttribute("PC_ATT", "PC_ATT_VAL");
	request.setAttribute("RQ_ATT", "RQ_ATT_VAL");
	session.setAttribute("SE_ATT", "SE_ATT_VAL");
	application.setAttribute("AP_ATT", "AP_ATT_VAL");
	session.setAttribute("SesionParam", new SessionParameter("name","value") );
%>


<table border="1">
	<thead style="background-color: yellow;" align="center">
		<td colspan="4">EL implicit objects</td>
	</thead>

	<tr>
		<td>param</td>
		<td>\${param.username}</td>
		<td>result:${param.username}</td>
		<td>Maps a request parameter name to a single value</td>
	</tr>

	<tr>
		<td>paramValues</td>
		<td>\${paramValues.username[0]}</td>
		<td>result:${paramValues.username[0]}</td>
		<td>Maps a request parameter name to an array of values</td>
	</tr>

	<tr>
		<td>header</td>
		<td>\${header['Host']}</td>
		<td>result:${header['Host']}</td>
		<td>Maps a request header name to a single value</td>
	</tr>

	<tr>
		<td>headerValues</td>
		<td>\${headerValues['Host'][0]}</td>
		<td>result:${headerValues['Host'][0]}</td>
		<td>Maps a request header name to an array of values</td>
	</tr>

	<tr>
		<td>cookie</td>
		<td>\${cookie.JSESSIONID}</td>
		<td>result:${cookie.JSESSIONID}</td>
		<td>Maps a cookie name to a single cookie</td>
	</tr>

	<tr>
		<td>initparam</td>
		<td>\${initParam.heldesk_email}</td>
		<td>result:${initParam.heldesk_email}</td>
		<td>Maps a context initialization parameter name to a single
		value</td>
	</tr>

	<tr style="background-color: yellow;" align="center">
		<td colspan="4">Scope Values</td>
	</tr>

	<tr>
		<td>pageScope</td>
		<td>\${pageScope.PC_ATT}</td>
		<td>result:${pageScope.PC_ATT}</td>
		<td>Maps page-scoped variable names to their values</td>
	</tr>

	<tr>
		<td>requestScope</td>
		<td>\${requestScope.RQ_ATT}</td>
		<td>result:${requestScope.RQ_ATT}</td>
		<td>Maps request-scoped variable names to their values</td>
	</tr>

	<tr>
		<td>sessionScope</td>
		<td>\${sessionScope.SE_ATT}</td>
		<td>result:${sessionScope.SE_ATT}</td>
		<td>Maps session-scoped variable names to their values</td>
	</tr>

	<tr>
		<td>applicationScope</td>
		<td>\${applicationScope.AP_ATT}</td>
		<td>result:${applicationScope.AP_ATT}</td>
		<td>Maps application-scoped variable names to their values</td>
	</tr>

	<thead style="background-color: yellow;" align="center">
		<td colspan="4">Special object <b>pageContext</b></td>
	</thead>
	<tr>
		<td>pageContext.servletContext</td>
		<td>\${pageContext.servletContext.page1_param}</td>
		<td>result:${pageContext.servletContext}</td>
		<td>The context for the JSP page's servlet and any web components
		contained in the same application. See Accessing the Web Context</td>
	</tr>
	<tr>
		<td>pageContext.session</td>
		<td>\${pageContext.session}</td>
		<td>result:${pageContext.session}</td>
		<td>The session object for the client. See Maintaining Client
		State</td>
	</tr>
	<tr>
		<td>pageContext.request</td>
		<td>\${pageContext.request}</td>
		<td>result:${pageContext.request}</td>
		<td>The request triggering the execution of the JSP page. See Getting Information from Requests</td>
	</tr>
	
	<tr>
		<td>pageContext.response</td>
		<td>\${pageContext.response}</td>
		<td>result:${pageContext.response}</td>
		<td>The response returned by the JSP page. See Constructing Responses.</td>
	</tr>
	
</table>
<br/>
page1 1 value = 
<%=
	//config.getInitParameter("page1_param")
	getInitParameter("page1_param")
%>
<br/> parametr z filtra "paramFilter": ${requestScope.paramFilter }
<br/> parametr z sesji "SesionParam": ${sessionScope.SesionParam.name }
<jsp:include page="../foother.jsp" />
