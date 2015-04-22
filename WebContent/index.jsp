<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="productController" method="get" style="display: block">
		Name: <input type="text" name="name" value="${param.name}" />
		${nameError} Price: <input type="text" name="price"
			value="${param.price}" /> ${priceError} Description: <input
			type="text" name="description" value="${param.description}" />
		${descriptionError} Code: <input type="text" name="code"
			value="${param.code}" /> ${codeError} <input type="submit"
			name="sumbit" value="invia" />

	</form>

</body>
</html>