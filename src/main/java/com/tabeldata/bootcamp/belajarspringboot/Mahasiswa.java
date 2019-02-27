/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tabeldata.bootcamp.belajarspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 *
 * @author dimasm93
 */
@Component
public class Mahasiswa {

    @Value("Dimas maryanto")
    private String nama;
    @Value("1")
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
        return String.format("singleton: %s , protoptype: %s", this.singletonString.getValue(), this.prototypeScript.getValue());
    }
    
    
    
    
}
