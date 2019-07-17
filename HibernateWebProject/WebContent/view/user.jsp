<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page import="model.User" %>
<%@ page import="model.Artikal" %>
<%@ page import="java.util.*" %>
<%@page import="service.KorisnikService"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>user</title>
</head>
<body>
	<jsp:useBean id="user" scope="session" class="model.User"/>
	
	<h1>HEllo User  </h1>
	
	<h2>Vas user name: ${user.userName}</h2>
	
	<a href = "../LogOutServlet"><button>LOG OUT</button></a>
	<br><br>
	
	<%
	KorisnikService service = new KorisnikService();
	List<Artikal> listaArtikala = service.vratiSveArtikle();
	request.setAttribute("listaArtikala", listaArtikala);
	%>
	
	<table>
		<tr>
			<th>ID</th>
			<th>IME ARTIKLA</th>
			<th>CENA</th>
			<th>POPUST</th>
			<th>CHECK</th>
			<th>KOLICINA</th>
		</tr>
		<form>
		<c:forEach var="a" items="${listaArtikala}">
			<tr>
				<td>${a.idArtikal}</td>
				<td>${a.imeArtikla}</td>
				<td>${a.cena}</td>
				<td>${a.popust}</td>
				<td><input type="checkbox" name = "check" value="${a.idArtikal}"/></td>
				<td>
					<select name = "kolicina">
						<c:forEach var="i" begin="1" end="${a.stanje}">
							<option value="i">${i}</option>
						</c:forEach>
				</td>
				
			</tr>
		</c:forEach>
		</form>
	</table>
	
	
	
</body>
</html>