package com.tabeldata.bootcamp.belajarspringboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tabeldata.bootcamp.belajarspringboot.beans.Mahasiswa;

@Configuration
public class BeanConfiguration {
	

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
