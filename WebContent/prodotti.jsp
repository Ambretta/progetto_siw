<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Visualizza lista prodotti</title>
</head>
<body>

	<c:forEach var="product" items="${products}">
		<ul>
		<li>Nome: ${product.name}</li>
		<li>Prezzo: ${product.price}</li>
		<li>Descrzione: ${product.description}</li>
		<li>Codice: ${product.code}</li>
		</ul>
		<br />
	</c:forEach>

	<a href="<c:url value="index.jsp"/>">Aggiungi prodotto</a>
</body>
</html>