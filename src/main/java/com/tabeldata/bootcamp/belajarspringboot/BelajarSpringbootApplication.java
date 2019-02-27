package com.tabeldata.bootcamp.belajarspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.tabeldata.bootcamp.belajarspringboot.beans.Kelas;
import com.tabeldata.bootcamp.belajarspringboot.beans.Mahasiswa;

@SpringBootApplication
public class BelajarSpringbootApplication {
	

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(BelajarSpringbootApplication.class, args);
        
        Kelas si = (Kelas) context.getBean("kelas");
        System.out.println(si.getNama());
        
        Mahasiswa dimas = context.getBean("gufron",Mahasiswa.class);
        System.out.println(dimas.toString());
    }

}
