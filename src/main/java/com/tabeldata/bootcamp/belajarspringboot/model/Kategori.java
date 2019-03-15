package com.tabeldata.bootcamp.belajarspringboot.model;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * create table kategori_buku(
 * id character varying(64) not null primary key,
 * nama character varying(100) not null,
 * keterangan text
 * );
 */
@Entity
@Table(name = "kategori_buku")
public class Kategori {

    @Id
    @Column(name = "id", length = 64)
    private String id;

    @Column(length = 100)
    private String nama;

    @Type(type = "text")
    @Column(name = "keterangan")
    private String keterangan;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }


}
