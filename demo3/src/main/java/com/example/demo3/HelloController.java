package com.example.demo3;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {

	@RequestMapping("/")
	public String index() {
		return "<<<< Olá pessoal da Aceleracao Avanade >>>>";
	}

}