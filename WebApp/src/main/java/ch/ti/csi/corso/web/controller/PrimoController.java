package ch.ti.csi.corso.web.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path={"/user", "/api"})
//@Secured({"ROLE_USER", "ROLE_ADMIN"})
public class PrimoController {

	@RequestMapping(path="/saluta", method=RequestMethod.GET)
	public String ciao() {
		return "ciao";
	}
	
	@RequestMapping(path="salutaModel", method=RequestMethod.GET)
	public ModelAndView ciaoModel() {
		ModelAndView mv = new ModelAndView();
		Persona p = new Persona();
		p.setNome("Mario");
		p.setCognome("Rossi");
		mv.addObject("mario", p);
		mv.setViewName("ciao");
		return mv;
	}
	
	@RequestMapping(path="salutaDirect", method=RequestMethod.GET)
	public @ResponseBody String salutaDirect() {
		return "ciao";
	}
	
	@RequestMapping(path="salutaPersona", method=RequestMethod.GET)
	public @ResponseBody Persona salutaPersona() {
		Persona p = new Persona();
		p.setNome("Mario");
		p.setCognome("Rossi");
		return p;
	}	
	
	@RequestMapping(path="salutaGenerico", method=RequestMethod.POST)
	public @ResponseBody Persona salutaGenerico(@RequestParam("nome") String nome, 
			@RequestParam("cognome") String cognome) {
		Persona p = new Persona();
		p.setNome(nome);
		p.setCognome(cognome);
		return p;
	}	
	
	@RequestMapping(path="salutaRovescio", method=RequestMethod.POST)
	public @ResponseBody Persona salutaGenerico(@RequestBody Persona p) {
		Persona p2 = new Persona();
		p2.setNome(p.getCognome());
		p2.setCognome(p.getNome());
		return p2;
	}
	
	@RequestMapping(path="salutaIndividuo/{id}", method=RequestMethod.POST)
	public @ResponseBody Persona salutaIndividuo(@PathVariable("id") int id, @RequestBody Persona p) {
		Persona p2 = new Persona();
		p2.setId(id);
		p2.setNome(p.getCognome());
		p2.setCognome(p.getNome());
		return p2;
	}
	
}
