package com.tabeldata.bootcamp.belajarspringboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * create table anggota(
 * 	id character varying(64) not null primary key,
 * 	nama character varying(100),
 * 	nik character varying(50),
 * 	tanggalLahir date
 * );
 */
@Entity
public class Anggota {

	@Id
	@Column(length = 64)
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	

}
