(function() {
	angular.module('productosapp',[])
		.controller('ProductController',productController);

	function productController($http){
		var self = this;

		self.get = function (){
			$http.get('api/productos.json')
				.success(function(data) {
					self.productos = data.productos;
				});
		};
		
		self.get();
			
		
		self.save = function(producto){
			$http.post('api/productos',producto)
				.success(function(data){
					console.log(data);
					self.producto = undefined;
					self.get();
				});
		};
		
		self.edit = function (producto) {
			self.producto = producto;
		};
		
		self.cancel = function () {
			self.producto = undefined;
		};
	}

})();