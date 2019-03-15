package com.tabeldata.bootcamp.belajarspringboot.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * -- untuk membuat table buku
 * create table buku(
 * 	id character varying(64) not null primary key,
 * 	nama character varying(100) not null,
 * 	isbn  character varying(62),
 * 	tahun_terbit int not null default 2000,
 * 	nama_pengarang character varying(100),
 * 	penerbit character varying(64),
 * 	created_date timestamp not null default now(),
 * 	created_by character varying(100) not null,
 * 	last_updated_date timestamp,
 * 	last_updated_by character varying(100)
 * );
 */
@Entity
public class Buku {

	@Id
	@Column(length = 64)
	private String id;
	private String nama;
	private String isbn;
	@Column(name = "tahun_terbit")
	private Integer tahunTerbit;
	@Column(name = "nama_pengarang")
	private String namaPengarang;
	private String penerbit;
	@Column(name = "created_date")
	private Timestamp createdDate;
	@Column(name = "created_by")
	private String createdBy;
	@Column(name = "last_updated_date")
	private Timestamp lastUpdatedDate;
	@Column(name = "last_updated_by")
	private String lastUpdatedBy;

	@OneToMany
	@JoinTable(
			name = "daftar_kategori_buku",
			joinColumns = @JoinColumn(name = "buku_id", nullable = false),
			inverseJoinColumns = @JoinColumn(name = "kategori_id", nullable = false)
	)
	private List<Kategori> daftarKategori = new ArrayList<Kategori>();

	@ManyToOne
	@JoinColumn(name = "rak_id", nullable = false)
	private Rak rak;
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("{ id: %s, nama: %s, isbn: %s, tahunTerbit: %d, namaPengarang: %s, penerbit: %s, createdDate: %s, createdBy: %s, lastUpdatedDate: %s, lastUpdatedBy: %s}", 
				this.id, this.nama, this.isbn, this.tahunTerbit, this.namaPengarang, this.penerbit, this.createdDate, this.createdBy, this.lastUpdatedDate, this.lastUpdatedBy);
	}

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

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Integer getTahunTerbit() {
		return tahunTerbit;
	}

	public void setTahunTerbit(Integer tahunTerbit) {
		this.tahunTerbit = tahunTerbit;
	}

	public String getNamaPengarang() {
		return namaPengarang;
	}

	public void setNamaPengarang(String namaPengarang) {
		this.namaPengarang = namaPengarang;
	}

	public String getPenerbit() {
		return penerbit;
	}

	public void setPenerbit(String penerbit) {
		this.penerbit = penerbit;
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

	public Timestamp getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(Timestamp lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public List<Kategori> getDaftarKategori() {
		return daftarKategori;
	}

	public void setDaftarKategori(List<Kategori> daftarKategori) {
		this.daftarKategori = daftarKategori;
	}

	public Rak getRak() {
		return rak;
	}

	public void setRak(Rak rak) {
		this.rak = rak;
	}
		
	
}
