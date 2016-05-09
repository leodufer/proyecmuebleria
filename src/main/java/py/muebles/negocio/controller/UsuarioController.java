package py.muebles.negocio.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import py.muebles.negocio.dao.UsuarioDAO;
import py.muebles.negocio.model.Usuario;

@RestController
@Transactional
@RequestMapping("/usuarios")
@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioDAO usuarioDAO;

	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Usuario> registrar(@RequestBody Usuario usuario){
		
		usuarioDAO.guardar(usuario, usuario.getLogin());
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView lista(){
		ModelAndView model=new ModelAndView();
		model.addObject("usuarios", usuarioDAO.getLista());
		
		return model;
	}
	@RequestMapping(method=RequestMethod.GET,value="/form")
	public ModelAndView form(){
		ModelAndView model=new ModelAndView("/usuarios/form");
		return model;
	}
	
	
}
