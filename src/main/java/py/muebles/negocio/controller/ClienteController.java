package py.muebles.negocio.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import py.muebles.negocio.dao.ClienteDAO;
import py.muebles.negocio.model.Cliente;

@Controller
@Transactional
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteDAO clienteDAO;
	
	
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		
//binder.setValidator(new ProductValidator());		
	}
	
	
	@RequestMapping(method=RequestMethod.POST,name="saveCliente")
	//@CacheEvict(value="books", allEntries=true)
	public ModelAndView save(@ModelAttribute("cliente") @Valid Cliente cliente,BindingResult bindingResult,
			RedirectAttributes redirectAttributes){
		
	if(bindingResult.hasErrors()){
		//return "produtos/form";
		System.out.println("Encontre algun error");
		return formulario(cliente);
	}
		
		
		clienteDAO.guardar(cliente, cliente.getId());
		redirectAttributes.addFlashAttribute("sucesso","Producto cadastrado con exito");
		//return "redirect:produtos";
		return new ModelAndView("redirect:clientes");
	}
	
	
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView list(){
	ModelAndView modelAndView =new ModelAndView("clientes/lista");
	//System.out.println("Lista "+productDao.list().get(0));
	modelAndView.addObject("clientes", clienteDAO.getLista());
	return modelAndView;
	}
	
	
	
	
	
	
	
	@RequestMapping("/formulario")
	public ModelAndView  formulario(Cliente cliente){
ModelAndView modelAndView =new ModelAndView("clientes/formulario");

	return modelAndView;
	}
	

	

	
	
	
}
