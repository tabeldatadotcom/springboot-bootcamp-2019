package com.tabeldata.bootcamp.belajarspringboot.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * create table transaksi_detail(
 * id character varying(64) not null primary key,
 * transaksi_id character varying(64) not null,
 * buku_id character varying(64) not null,
 * kembali boolean default false
 * );
 *
 * @author dimasm93
 */
@Entity
public class TransaksiDetail {

    @Id
    @Column(length = 64)
    @GenericGenerator(name = "uuid_gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid_gen")
    private String id;

    @ManyToOne
    @JoinColumn(name = "transaksi_id", nullable = false)
    private Transaksi transaksi;

    @ManyToOne
    @JoinColumn(name = "buku_id", nullable = false)
    private Buku buku;

    private boolean kembali;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Transaksi getTransaksi() {
        return transaksi;
    }

    public void setTransaksi(Transaksi transaksi) {
        this.transaksi = transaksi;
    }

    public Buku getBuku() {
        return buku;
    }

    public void setBuku(Buku buku) {
        this.buku = buku;
    }

    public boolean isKembali() {
        return kembali;
    }

    public void setKembali(boolean kembali) {
        this.kembali = kembali;
    }


}
