package py.muebles.negocio.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import py.muebles.negocio.dao.ProductoDao;
import py.muebles.negocio.model.Producto;

@Transactional
@RestController
@RequestMapping("api/productos")
public class ProductoController {
	
	@Autowired
	private ProductoDao productoDao;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView lista(){
		ModelAndView model=new ModelAndView();
		
		List<Producto> productos=productoDao.getLista();
		model.addObject("productos", productos);
	
	return model;
		
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Producto> guardar(@RequestBody Producto producto){
		productoDao.guardar(producto, producto.getId());
		return new ResponseEntity<Producto>(producto, HttpStatus.CREATED);
	}
	

}
