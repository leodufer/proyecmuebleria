package py.muebles.negocio.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	
	@RequestMapping("/")
	public ModelAndView index(){
		
		System.out.println("Ingrese en el inicio");
		ModelAndView modelAndView =new ModelAndView("index");
				return modelAndView;	
	}
	
//	@RequestMapping("/")
//	public String index(){
//		
//		System.out.println("Ingrese en el inicio");
//		//ModelAndView modelAndView =new ModelAndView("inicio/index");
//				return "inicio/index";	
//	}
	
	
	
//	@RequestMapping("/form")
//	public ModelAndView  form(Product product){
//ModelAndView modelAndView =
//	new ModelAndView("products/form");
//	modelAndView.addObject("types", BookType.values());
//	return modelAndView;
//	}

}
