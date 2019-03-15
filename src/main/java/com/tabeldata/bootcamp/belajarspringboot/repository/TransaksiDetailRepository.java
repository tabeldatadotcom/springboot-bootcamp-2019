package com.tabeldata.bootcamp.belajarspringboot.repository;

import com.tabeldata.bootcamp.belajarspringboot.model.TransaksiDetail;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TransaksiDetailRepository extends CrudRepository<TransaksiDetail, String> {

    @Query("from TransaksiDetail d where d.transaksi.id = ?1")
    List<TransaksiDetail> findByTransaksiId(String id);
}
