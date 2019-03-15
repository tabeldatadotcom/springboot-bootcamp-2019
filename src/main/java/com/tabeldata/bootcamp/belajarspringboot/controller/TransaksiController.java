package com.tabeldata.bootcamp.belajarspringboot.controller;

import com.tabeldata.bootcamp.belajarspringboot.dto.TransaksiDto;
import com.tabeldata.bootcamp.belajarspringboot.model.Transaksi;
import com.tabeldata.bootcamp.belajarspringboot.model.TransaksiDetail;
import com.tabeldata.bootcamp.belajarspringboot.service.TransaksiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/transaksi")
public class TransaksiController {

    @Autowired
    private TransaksiService service;

    @PostMapping("/")
    public ResponseEntity<Transaksi> save(@RequestBody TransaksiDto trx) {
        Transaksi transaksi = service.save(trx);
        return ResponseEntity.ok(transaksi);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransaksiDto> findById(@PathVariable("id") String id) {
        Optional<Transaksi> transaksiOptional = service.findById(id);
        if (transaksiOptional.isPresent()) {
            Transaksi transaksi = transaksiOptional.get();
            List<TransaksiDetail> transaksiDetails = service.findByTransaksiId(transaksi.getId());

            TransaksiDto dto = new TransaksiDto();
            dto.setAnggota(transaksi.getAnggota());
            dto.setCreatedBy(transaksi.getCreatedBy());
            dto.setCreatedDate(transaksi.getCreatedDate());
            dto.setTanggal(transaksi.getTanggal());
            dto.setDetail(transaksiDetails);
            return ResponseEntity.ok(dto);

        } else
            return ResponseEntity.noContent().build();
    }

}
