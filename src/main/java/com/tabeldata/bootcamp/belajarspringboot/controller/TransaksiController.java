package com.tabeldata.bootcamp.belajarspringboot.controller;

import com.tabeldata.bootcamp.belajarspringboot.model.Transaksi;
import com.tabeldata.bootcamp.belajarspringboot.service.TransaksiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/transaksi")
public class TransaksiController {
	
	@Autowired
	private TransaksiService service;
	
	@PostMapping("/")
	public ResponseEntity<Transaksi> save(@RequestBody Transaksi trx){
		trx = service.save(trx);
		return ResponseEntity.ok(trx);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Transaksi> findById(@PathVariable("id") String id){
		Optional<Transaksi> transaksiOptional = service.findById(id);
		if(transaksiOptional.isPresent())
			return ResponseEntity.ok(transaksiOptional.get());
		else
			return ResponseEntity.noContent().build();
	}

}
