package com.tabeldata.bootcamp.belajarspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HaloController {
	
	@GetMapping("/halo")
	public String halo() {
		return "index";
	}

}
