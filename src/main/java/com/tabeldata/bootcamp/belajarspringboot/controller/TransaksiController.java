package com.tabeldata.bootcamp.belajarspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tabeldata.bootcamp.belajarspringboot.dao.TransaksiDao;
import com.tabeldata.bootcamp.belajarspringboot.model.Transaksi;

@RestController
@RequestMapping("/api/transaksi")
public class TransaksiController {
	
	@Autowired
	private TransaksiDao dao;
	
	@PostMapping("/")
	public ResponseEntity<Transaksi> save(@RequestBody Transaksi trx){
		dao.save(trx);
		
		return ResponseEntity.ok().build();
	}

}
