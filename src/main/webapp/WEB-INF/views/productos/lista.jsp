<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table>
<tr>
<th>Id</th>
<th>Descripcion</th>
<th>Fecha Fabricación</th>
<th>Cantidad</th>
<th>Precio</th>
</tr>



<c:forEach items="${productos}" var="pro">
<tr>
<td>${pro.id}</td>
<td>${pro.descripcion}</td>
<td>${pro.fechaFabricacion}</td>
<td>${pro.cantidad}</td>
<td>${pro.precio}</td>
</tr>

</c:forEach>

</table>



</body>
</html>