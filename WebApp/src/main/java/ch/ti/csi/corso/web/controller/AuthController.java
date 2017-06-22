package ch.ti.csi.corso.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthController {

	@RequestMapping("/apiauth")
	public boolean authenticate() {
		return true;
	}
}
