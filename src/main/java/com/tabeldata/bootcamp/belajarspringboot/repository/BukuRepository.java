package com.tabeldata.bootcamp.belajarspringboot.repository;

import com.tabeldata.bootcamp.belajarspringboot.model.Buku;
import org.springframework.data.repository.CrudRepository;

public interface BukuRepository extends CrudRepository<Buku, String> {
}
