package com.tabeldata.bootcamp.belajarspringboot.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tabeldata.bootcamp.belajarspringboot.dao.BukuDao;
import com.tabeldata.bootcamp.belajarspringboot.model.Buku;

@RestController
@RequestMapping("/api/buku")
public class BukuController {
	
	private final Logger console = LoggerFactory.getLogger(BukuController.class);

	@Autowired
	private BukuDao dao;

	@GetMapping(path = "/xml/list", produces = MediaType.APPLICATION_XML_VALUE)
	public List<Buku> findAllXml() {
		return dao.daftarList();
	}

	@GetMapping(path = "/json/list")
	public List<Buku> findAllJson() {
		return dao.daftarList();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Buku> findById(@PathVariable("id") String primaryKey) {
		try {
			Buku buku = dao.findById(primaryKey);
			return ResponseEntity.ok(buku);
		} catch (EmptyResultDataAccessException erdae) {
			return ResponseEntity.noContent().build();
		}
	}

	@PostMapping("/")
	public ResponseEntity<Buku> save(@RequestBody Buku buku) {
		console.info("updated : {}", buku.toString());
		dao.save(buku);
		return ResponseEntity.ok().build();
	}

	@PutMapping("/")
	public ResponseEntity<Buku> update(@RequestBody Buku buku) {
		console.info("updated : {}", buku.toString());
		dao.update(buku);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Buku> delete(@PathVariable("id") String primaryKey) {
		dao.delete(primaryKey);
		return ResponseEntity.ok().build();
	}

}
