package ch.ti.csi.corso.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PrimoController {

	@RequestMapping(path="saluta", method=RequestMethod.GET)
	public String ciao() {
		return "ciao";
	}
	
}
