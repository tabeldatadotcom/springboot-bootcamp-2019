package com.tabeldata.bootcamp.belajarspringboot;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tabeldata.bootcamp.belajarspringboot.beans.Kelas;
import com.tabeldata.bootcamp.belajarspringboot.beans.Mahasiswa;
import com.tabeldata.bootcamp.belajarspringboot.config.SpringConfig;

public class BelajarSpringbootApplication {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        
        Kelas si = (Kelas) context.getBean("kelas");
        System.out.println(si.getNama());
        
        Mahasiswa dimas = context.getBean("gufron",Mahasiswa.class);
        System.out.println(dimas.toString());
    }

}
