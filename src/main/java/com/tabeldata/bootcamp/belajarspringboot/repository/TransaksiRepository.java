package com.tabeldata.bootcamp.belajarspringboot.repository;

import com.tabeldata.bootcamp.belajarspringboot.model.Transaksi;
import org.springframework.data.repository.CrudRepository;

public interface TransaksiRepository extends CrudRepository<Transaksi, String> {
}
