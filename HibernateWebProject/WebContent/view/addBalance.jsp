<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>add balance</title>
</head>
<body>
	<% 
	String idUser = request.getParameter("idUser");
	
	%>
	
	<form action = "../AddBalanceServlet" method="post">
		<input type="hidden" name="idUser" value="<%=idUser %>">
	ADD:<input type="text" name = "balanceAdded"><br>
	<input type="submit" value="DODAJ">
	</form>
</body>
</html>