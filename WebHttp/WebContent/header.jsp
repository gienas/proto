<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<div align="center">Hello on my site</div>
<div align="center">
<h4>Login status:</h4>
<c:choose>
	<c:when test="${pageContext.request.remoteUser==null} ">
		page content for user that has not logged in yet...
	</c:when>
	<c:otherwise>
		Hello <c:out value="${pageContext.request.remoteUser}" />
		</b>
		<!--  a href="/WebLoginHttp/logout.jsp"> Logout</a>
		-->
	</c:otherwise>
</c:choose>
</div>

<div align="center">
<h4>All menu</h4>
<a href="/WebLoginHttp/all/page1.jsp"> page1 all users</a>| <a
	href="/WebLoginHttp/all/page2.jsp"> page2 all users</a>| <a
	href="/WebLoginHttp/all/page3.jsp"> page3 all users</a>|</div>

<div align="center">
<h4>Admin menu</h4>
<a href="/WebLoginHttp/admin/page1.jsp"> page1 admin</a>| <a
	href="/WebLoginHttp/admin/page2.jsp"> page2 admin</a>| <a
	href="/WebLoginHttp/admin/page3.jsp"> page3 admin</a>|</div>

<div align="center">
<h4>Member menu</h4>
<a href="/WebLoginHttp/member/page1.jsp"> page1 memeber</a>| <a
	href="/WebLoginHttp/member/page2.jsp"> page2 memeber</a>| <a
	href="/WebLoginHttp/member/page3.jsp"> page3 memeber</a>|</div>