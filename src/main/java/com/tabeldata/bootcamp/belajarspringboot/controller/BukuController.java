package com.tabeldata.bootcamp.belajarspringboot.controller;

import com.tabeldata.bootcamp.belajarspringboot.dao.BukuDao;
import com.tabeldata.bootcamp.belajarspringboot.model.Buku;
import com.tabeldata.bootcamp.belajarspringboot.repository.BukuRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/buku")
public class BukuController {

    private final Logger console = LoggerFactory.getLogger(BukuController.class);

    @Autowired
    private BukuDao dao;

    @Autowired
    private BukuRepository repo;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(path = "/xml/list", produces = MediaType.APPLICATION_XML_VALUE)
    public List<Buku> findAllXml() {
        console.info("masuk cari data");
        return dao.daftarList();
    }

    @PostAuthorize("hasRole('ADMIN')")
    @GetMapping(path = "/json/list", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Iterable<Buku> findAllJson() {
        console.info("masuk cari data");
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Buku> findById(Principal principal, @PathVariable("id") String primaryKey) {
        console.info("user login : {}", principal.getName());
        Optional<Buku> bukuOptional = repo.findById(primaryKey);
        if (bukuOptional.isPresent())
            return ResponseEntity.ok(bukuOptional.get());
        else
            return ResponseEntity.noContent().build();
    }

    @PostMapping("/")
    public ResponseEntity<Buku> save(@RequestBody Buku buku) {
        console.info("created : {}", buku.toString());
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
