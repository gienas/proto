<%@ attribute name="id" description="id" required="true"  %>
<%@ attribute name="paramsList" description="params" required="true" type="java.util.List"  %>
<%@ tag body-content="tagdependent" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<br/>
<br/>It is body content from tag go: <jsp:doBody/>
<br/>It is param id: ${id}
<br/>It is list params:
<c:forEach var="item" items="${paramsList}">
<br/> ${item} 
</c:forEach> 
<br/>

