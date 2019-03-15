package com.tabeldata.bootcamp.belajarspringboot.dto;

import com.tabeldata.bootcamp.belajarspringboot.model.Anggota;
import com.tabeldata.bootcamp.belajarspringboot.model.TransaksiDetail;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class TransaksiDto {

    private Anggota anggota;
    private Date tanggal;
    private Timestamp createdDate;
    private String createdBy;
    private List<TransaksiDetail> detail = new ArrayList<TransaksiDetail>();

    public Anggota getAnggota() {
        return anggota;
    }

    public void setAnggota(Anggota anggota) {
        this.anggota = anggota;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public List<TransaksiDetail> getDetail() {
        return detail;
    }

    public void setDetail(List<TransaksiDetail> detail) {
        this.detail = detail;
    }
}
