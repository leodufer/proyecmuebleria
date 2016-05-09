<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="registroUsuario">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<!-- <script type="text/javascript" src="/proyectomuebleria/resources/js/angular/angular.js"></script> -->

<script type="text/javascript" src="/proyectomuebleria/resources/js/angular/angular.js"></script>

<link rel="stylesheet" type="text/css" href="/proyectomuebleria/resources/css/bootstrap-3.3.6-dist/css/bootstrap.css">

<!-- <script type="text/javascript" src="/proyectomuebleria/resources/js/angular/angular.js"></script> -->

<!-- <link rel="stylesheet" type="text/css" href="/proyectomuebleria/resources/css/bootstrap-3.3.6-dist/css/bootstrap.css"> -->




<script type="text/javascript">

angular.module("registroUsuario",[]);

angular.module("registroUsuario").controller("usuarioController",function($scope,$http){
	
	$scope.app="Registro de Usuario";
	
	
$scope.registrarUsuario=function(usuario){
	
	$http.post("http://localhost:8080/proyectomuebleria/usuarios",usuario).success(function(){
		delete $scope.usuario;
		alert("Ingrese");
		console.log("Ingrese en insertar");
	});
	
	
};


var cargarUsuarios=function(){
	
	$http.get("http://localhost:8080/proyectomuebleria/usuarios")
}





	
	
});



</script>

<style type="text/css">

.jumbotron{
width: 500px;
text-align: center;
margin-left: auto;
margin-right: auto;

}
.form-control{
margin-bottom: 5px;

}

.scroll{
overflow: scroll;
max-height: 400px;


}

</style>



</head>
<body ng-controller="usuarioController">
<div class="jumbotron">

<h3 ng-bind="app"></h3>

<form ng-submit="registrarUsuario(usuario)">

<input class="form-control" ng-model="usuario.login" placeholder="Correo">
<input class="form-control" ng-model="usuario.name" placeholder="Nombre">
<input class="form-control" ng-model="usuario.password" placeholder="Contraseña">

<button class="btn btn-primary btn-block"  >Registrar</button>

</form>


<table>


<tbody class="scroll">
<tr ng-repeat="usuario in usuarios">
<td>{{usuario.login}}</td>
<td>{{usuario.name}}</td>
<td>{{usuario.password}}</td>


</tr>



</tbody>



</table>


</div>
</body>
</html>