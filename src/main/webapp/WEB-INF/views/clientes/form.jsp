<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="registroCliente">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registro de Clientes</title>
<script type="text/javascript" src="/proyectomuebleria/resources/js/angular/angular.js"></script>

<link rel="stylesheet" type="text/css" href="/proyectomuebleria/resources/css/bootstrap-3.3.6-dist/css/bootstrap.css">


<script type="text/javascript">

	angular.module("registroCliente",[]);
	angular.module("registroCliente").controller("clienteController",function($scope,$http){
		
	
		$scope.app="Registro de Cliente";
		
	
	$scope.registrarCliente=(function(cliente){
		
		$http.post("http://localhost:8080/proyectomuebleria/clientes",cliente).success(function(){
			
			delete $scope.cliente;
			
			
		});
		
		
	});	
	
	var cargarClientes=(function(){

		$http.get("http://localhost:8080/proyectomuebleria/clientes.json").success(function(datos){
			
			$scope.clientes=datos.clientes;
			
		});
		
		
	});
		
	cargarClientes();	
		
	});
	



</script>

<style type="text/css">

.jumbotron{

width: 700px;
margin-left: auto;
margin-right: auto;
text-align: center;

margin-bottom: 10px;

}
.form-control{

 margin-bottom: 5px;
}
.table{
margin-top: 20px;
text-align: left;

}

</style>



</head>
<body ng-controller="clienteController">

<div class="jumbotron">
<h3>{{app}}</h3>


<form action="">

<input class="form-control" type="text" ng-model="cliente.nombre" placeholder="Nombre">
<input class="form-control" type="text" ng-model="cliente.celular" placeholder="Celular" >
<input class="form-control" type="text" ng-model="cliente.direccion" placeholder="Dirección">
<input class="form-control" type="email" ng-model="cliente.email" placeholder="Email">
<textarea class="form-control" placeholder="Observación" ng-model="cliente.observacion"></textarea>



<button class="btn btn-block" ng-click="registrarCliente(cliente)">Registrar</button>


</form>

<table class="table table-striped">

<thead>



</thead>


<tr>

<th>Nombre</th>
<th>Celular</th>
<th>Dirección</th>
<th>Email</th>
<th>Observación</th>
</tr>

<tr ng-repeat="cliente in clientes">
<td>{{cliente.nombre}}</td>
<td>{{cliente.celular}}</td>
<td>{{cliente.direccion}}</td>
<td>{{cliente.email}}</td>
<td>{{cliente.observacion}}</td>

</tr>


</table>




</div>



</body>
</html>