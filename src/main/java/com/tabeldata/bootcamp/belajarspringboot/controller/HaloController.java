package com.tabeldata.bootcamp.belajarspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HaloController {

	@GetMapping("/halo")
	public String halo(
			@RequestParam(name = "nama", required = false) String nama, 
			Model model) {
		model.addAttribute("namaParam", nama);
		System.out.println("nama saya : " + nama+ " dari method http.GET");
		return "index";
	}
	
	@GetMapping("/form")
	public String form() {
		return "form";
	}

	@PostMapping("/halo")
	public String haloPost(@RequestParam(name = "nama", required = false) String nama) {
		System.out.println("nama saya : " + nama + " dari method http.POST");
		return "index";
	}	
}
