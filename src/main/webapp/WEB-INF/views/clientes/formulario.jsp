<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%-- <%@taglib uri="http://www.springframework.org/security/tags" prefix="security" %>     --%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Formulario de Registro de Cliente</title>


<link rel="stylesheet" type="text/css" href="resources/css/bootstrap-3.3.6-dist/css/bootstrap.css">

<style type="text/css">

#formulario{

padding-top:30px;
width: 200px;
margin: 0 auto;

}

body {

	
	width:450px;
	height:300px;
	margin: 0 auto;
	margin-top: 30px;
}



</style>





</head>
<body class="panel panel-primary">

<div class="panel-heading">
			Registrese para una atenci�n personalizada
	</div>

<div id="formulario">


	<form:form action="${spring:mvcUrl('saveCliente').build()}" method="post" commandName="cliente" enctype="multipart/form-data">



<!-- INPUT DE SEGURIDAD AL TENER LA ANOTACION EN LA CLASE SECURITYCONFIGURATION ES OPCIONAL EL INPUT--> 
<%-- <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> --%>

<%-- <security:csrfInput/> --%>

<div class="form-group">
<label for="nombre">Nombre</label>
<input type="text" name="nombre" id="nombre" class="form-control"/>
<form:errors path="nombre"/>
</div>

<div class="form-group">
<label for="celular">Celular</label>
<input type="text" name="celular" id="celular" class="form-control"/>
<form:errors path="celular"/>
</div>

<div class="form-group">
<label for="direccion">Direcci�n</label>
<input type="text" name="direccion" id="direccion" class="form-control"/>
<form:errors path="direccion"/>
</div>

<div class="form-group">
<label for="email">Email</label>
<input type="email" name="email" id="email" class="form-control"/>
<form:errors path="email"/>
</div>



<div class="form-group">
<label for="observacion">Observaci�n</label>
<textarea  rows="10" cols="20" name="observacion"></textarea>
<form:errors path="observacion"/>
</div>

<div>
<input type="submit" value="Enviar" class="btn btn-primary">

</div>



</form:form>


	

			
	</div>



</body>
</html>