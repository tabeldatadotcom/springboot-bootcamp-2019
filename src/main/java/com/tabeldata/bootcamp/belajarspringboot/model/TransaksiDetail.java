package com.tabeldata.bootcamp.belajarspringboot.model;

/**
 * create table transaksi_detail(
	id character varying(64) not null primary key,
	transaksi_id character varying(64) not null,
	buku_id character varying(64) not null,
	kembali boolean default false
);

 * @author dimasm93
 *
 */
public class TransaksiDetail {
	
	private String id;
	private Transaksi transaksi;
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
