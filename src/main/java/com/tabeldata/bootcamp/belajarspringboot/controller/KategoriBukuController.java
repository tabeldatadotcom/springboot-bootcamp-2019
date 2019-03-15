package com.tabeldata.bootcamp.belajarspringboot.controller;

import com.tabeldata.bootcamp.belajarspringboot.dao.KategoriBukuDao;
import com.tabeldata.bootcamp.belajarspringboot.model.Buku;
import com.tabeldata.bootcamp.belajarspringboot.model.Kategori;
import com.tabeldata.bootcamp.belajarspringboot.repository.KategoriRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/kategori/buku")
public class KategoriBukuController {

    private final Logger console = LoggerFactory.getLogger(BukuController.class);

    @Autowired
    private KategoriBukuDao dao;

    @Autowired
    private KategoriRepository repo;


    @GetMapping(path = "/list")
    public Iterable<Kategori> findAllJson() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Kategori> findById(@PathVariable("id") String primaryKey) {
        Optional<Kategori> kategoriOptional = repo.findById(primaryKey);
        if (kategoriOptional.isPresent())
            return ResponseEntity.ok(kategoriOptional.get());
        else
            return ResponseEntity.noContent().build();
    }

    @PostMapping("/")
    public ResponseEntity<Kategori> save(@RequestBody Kategori buku) {
        console.info("created : {}", buku.toString());
        repo.save(buku);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/")
    public ResponseEntity<Kategori> update(@RequestBody Kategori buku) {
        console.info("updated : {}", buku.toString());
        repo.save(buku);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Buku> delete(@PathVariable("id") String primaryKey) {
        repo.deleteById(primaryKey);
        return ResponseEntity.ok().build();
    }

}
