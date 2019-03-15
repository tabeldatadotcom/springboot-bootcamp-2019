package com.tabeldata.bootcamp.belajarspringboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * create table rak(
 * 	id character varying(64) not null primary key,
 * 	nama character varying(64) not null,
 * 	nomor int not null default 0
 * );
 */
@Entity
public class Rak {

	@Id
	@Column(length = 64)
	private String id;

	@Column(length = 64, nullable = false)
	private String nama;

	@Column(nullable = false)
	private Integer nomor;

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

	public Integer getNomor() {
		return nomor;
	}

	public void setNomor(Integer nomor) {
		this.nomor = nomor;
	}

}
