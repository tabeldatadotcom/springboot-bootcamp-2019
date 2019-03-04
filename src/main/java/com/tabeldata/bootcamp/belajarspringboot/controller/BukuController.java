package com.tabeldata.bootcamp.belajarspringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tabeldata.bootcamp.belajarspringboot.dao.BukuDao;
import com.tabeldata.bootcamp.belajarspringboot.model.Buku;

@RestController
public class BukuController {

	@Autowired
	private BukuDao dao;

	@GetMapping(path = "/buku/xml/list", produces = MediaType.APPLICATION_XML_VALUE)
	public List<Buku> findAllXml() {
		return dao.daftarList();
	}
	
	@GetMapping(path = "/buku/json/list")
	public List<Buku> findAllJson() {
		return dao.daftarList();
	}
}
