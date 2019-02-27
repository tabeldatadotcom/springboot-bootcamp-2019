/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tabeldata.bootcamp.belajarspringboot.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 *
 * @author dimasm93
 */
public class Mahasiswa {
	
	public Mahasiswa() {
	}
	
	public Mahasiswa(String nama, Integer semester) {
		this.nama = nama;
		this.semester = semester;
	}	

    private String nama;
    private Integer semester;
    
    @Autowired
    private Kelas kelas;
    
    @Autowired
    private RandomString singletonString;
    
    @Autowired
    private RandomStringPrototype prototypeScript;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }

    public Kelas getKelas() {
        return kelas;
    }

    public void setKelas(Kelas kelas) {
        this.kelas = kelas;
    }

    @Override
    public String toString() {
        return String.format("nama: %s, semester: %s, namaKelas: %s", this.nama, this.semester, this.kelas.getNama());
    }
    
    
    
    
}
