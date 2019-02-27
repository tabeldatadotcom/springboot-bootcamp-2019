/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tabeldata.bootcamp.belajarspringboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.tabeldata.bootcamp.belajarspringboot.beans.Kelas;
import com.tabeldata.bootcamp.belajarspringboot.beans.Mahasiswa;

/**
 *
 * @author dimasm93
 */
@Configuration
@ComponentScan(basePackages = "com.tabeldata.bootcamp.belajarspringboot.beans")
public class SpringConfig {
	
	@Bean
	public String nama1() {
		return "Configurasion dari bean";
	}
	
	@Bean
	public String nama2() {
		return "Configurasion dari bean 2";
	}
	
	@Bean
	public Mahasiswa dimas() {
		return new Mahasiswa("Dimas Maryanto", 7);
	}
	
	@Bean
	public Mahasiswa gufron() {
		return new Mahasiswa("Gufron", 7);
	}
	
}