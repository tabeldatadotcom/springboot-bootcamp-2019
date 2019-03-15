package com.tabeldata.bootcamp.belajarspringboot.service;

import com.tabeldata.bootcamp.belajarspringboot.dto.TransaksiDto;
import com.tabeldata.bootcamp.belajarspringboot.model.Transaksi;
import com.tabeldata.bootcamp.belajarspringboot.model.TransaksiDetail;
import com.tabeldata.bootcamp.belajarspringboot.repository.TransaksiDetailRepository;
import com.tabeldata.bootcamp.belajarspringboot.repository.TransaksiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class TransaksiService {

    @Autowired
    private TransaksiRepository trxRepo;

    @Autowired
    public TransaksiDetailRepository trxDetailRepo;

    @Transactional
    public Transaksi save(TransaksiDto transaksi) {
        List<TransaksiDetail> details = transaksi.getDetail();
        Transaksi trx = new Transaksi();
        trx.setAnggota(transaksi.getAnggota());
        trx.setCreatedBy(transaksi.getCreatedBy());
        trx.setCreatedDate(transaksi.getCreatedDate());
        trx.setTanggal(transaksi.getTanggal());

        trx = trxRepo.save(trx);

        for (TransaksiDetail detail : details) {
            detail.setTransaksi(trx);
        }
        trxDetailRepo.saveAll(details);
        return trx;
    }

    public Optional<Transaksi> findById(String id) {
        return trxRepo.findById(id);
    }

    public List<TransaksiDetail> findByTransaksiId(String transaksiId) {
        return trxDetailRepo.findByTransaksiId(transaksiId);
    }

}
