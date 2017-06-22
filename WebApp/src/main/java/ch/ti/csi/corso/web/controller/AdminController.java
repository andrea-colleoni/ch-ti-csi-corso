package ch.ti.csi.corso.web.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/admin")
//@Secured("ROLE_ADMIN")
public class AdminController {

	@RequestMapping(path="/verifica")
	//@PreAuthorize("hasRole('ADMIN')")
	public @ResponseBody String admin() {
		return "ok";
	}
}
