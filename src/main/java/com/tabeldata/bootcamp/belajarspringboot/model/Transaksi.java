package com.tabeldata.bootcamp.belajarspringboot.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * create table transaksi( id character varying(64) not null primary key,
 * anggota_id character varying (64) not null, tanggal date not null default
 * now(), created_date timestamp not null default now(), created_by character
 * varying(64) );
 * 
 * @author dimasm93
 *
 */

@Entity
public class Transaksi {

	@Id
	@Column(length = 64)
	@GenericGenerator(name = "uuid_gen", strategy = "uuid2")
	@GeneratedValue(generator = "uuid_gen")
	private String id;

	@ManyToOne
	@JoinColumn(name = "anggota_id", nullable = false)
	private Anggota anggota;

	private Date tanggal;

	@Column(name = "created_date")
	private Timestamp createdDate;

	@Column(name = "created_by", length = 64)
	private String createdBy;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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


}
