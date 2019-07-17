<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page import="model.User" %>
<%@ page import="java.util.*" %>
<%@page import="service.AdminService"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>admin</title>
</head>
<body>

	<%
	User user = (User)session.getAttribute("user");
	%>
	
		<h1>HEllo ADMIN </h1>
		<h2>Vas user name: <%=user.getUserName() %></h2>
		
		
	<%
		AdminService service = new AdminService();
		List<User> listaUsera = service.vratiSveUsere();
		request.setAttribute("listaUsera", listaUsera);
	%>
	<a href = "../LogOutServlet"><button>LOG OUT</button></a>
	<br><br>
	<a href = "dodajArtikal.jsp"><button>DODAJ ARTIKAL</button></a>
	<br>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>IME</th>
			<th>PASSWORD</th>
			<th>ROLE</th>
			<th>BALANCE</th>
			<th>ADD BALANCE</th>
		</tr>
		<c:forEach var="u" items="${listaUsera}">
		<tr>
			<td>${u.idUser}</td>
			<td>${u.userName}</td>
			<td>${u.password}</td>
			<td>${u.role}</td>
			<td>${u.balance}</td>
			<c:url var="link" value="addBalance.jsp">
				<c:param name="idUser" value="${u.idUser}"/>
			</c:url>
			<td><a href = "${link}">add balance</a></td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>