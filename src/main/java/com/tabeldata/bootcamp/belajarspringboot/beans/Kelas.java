/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tabeldata.bootcamp.belajarspringboot.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author dimasm93
 */
@Component
public class Kelas {

	@Autowired
	private String nama2;

	@Autowired
	private RandomString singletonString;

	@Autowired
	private RandomStringPrototype prototypeScript;

	public String getNama() {
		return nama2;
	}

	public void setNama(String nama) {
		this.nama2 = nama;
	}

	@Override
	public String toString() {
		return String.format("singleton: %s , protoptype: %s",
				this.singletonString.getValue(),
				this.prototypeScript.getValue());
	}

}
