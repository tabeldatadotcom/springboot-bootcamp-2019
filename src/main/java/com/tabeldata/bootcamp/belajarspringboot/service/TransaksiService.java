package com.tabeldata.bootcamp.belajarspringboot.service;

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
    public Transaksi save(Transaksi transaksi) {
        List<TransaksiDetail> details = transaksi.getDetail();
        transaksi = trxRepo.save(transaksi);

        for (TransaksiDetail detail : details) {
            detail.setTransaksi(transaksi);
        }
        trxDetailRepo.saveAll(details);
        return transaksi;
    }

    public Optional<Transaksi> findById(String id){
        return trxRepo.findById(id);
    }

}
