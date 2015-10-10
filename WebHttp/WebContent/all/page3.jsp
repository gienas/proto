
<jsp:include page="../header.jsp"/>
Page3

param name from el = ${param.name} <br/>

<jsp:useBean id="animal" class="beans.Animal" >
	<jsp:setProperty name="animal" property="*"  />
</jsp:useBean>

<jsp:useBean id="person" class="beans.Person" >
	<jsp:setProperty name="person" property="*"  />
</jsp:useBean>

<br/>
animal name: ${animal.name}<br/>
animal id: ${animal.id}<br/>

person name: ${person.name}<br/>
person id: ${person.id}<br/>

<br/>
page scope name: ${requestScope.name}

<% int[] nums = {42,420,4200};
	request.setAttribute("foo",nums);
	 
%>


<br/>
${5+3 lt 6}
${requestScope['foo'][0] ne 10 div 0}


<!-	"dddd"
	
-->
<br/>
<!-- test -->
<c:out value="Hello ${param.id}" />
<jsp:include page="../foother.jsp"/>
