package py.muebles.negocio.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import py.muebles.negocio.dao.ProductoDao;
import py.muebles.negocio.model.Producto;

@Transactional
@Controller
@RequestMapping("/productos")
public class ProductoController {
	
	@Autowired
	private ProductoDao productoDao;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView lista(){
		ModelAndView model=new ModelAndView("/productos/lista");
		
	List<Producto> productos=productoDao.getLista();
	model.addObject("productos", productos);
	
	return model;
		
	}
	

}
