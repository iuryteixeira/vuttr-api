package com.bossabox.vuttr.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

	@GetMapping({ "", "/" })
	public String index() {
		return "API OK. Para acessar a documentação <a href=\"/docs.html\">clique aqui</a>"
				+ "";
	}

}
