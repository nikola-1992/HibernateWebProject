<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>dodaj artikal</title>
</head>
<body>

<form action = "../DodajArtikalServlet" method="post">
	Ime: 	<input type="text" name = "imeArtikla">
	Cena: 	<input type="text" name = "cena">
	Stanje: <input type="text" name = "stanje">
	Popust: <input type="text" name = "popust">
			<input type="submit" value = "DODAJ">

</form>

</body>
</html>