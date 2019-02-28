package com.tabeldata.bootcamp.belajarspringboot;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.tabeldata.bootcamp.belajarspringboot.dao.BukuDao;
import com.tabeldata.bootcamp.belajarspringboot.model.Buku;

@SpringBootApplication
public class BelajarSpringbootApplication {
	
    public static void main(String[] args) {
       ApplicationContext context =  SpringApplication.run(BelajarSpringbootApplication.class, args);
       BukuDao dao = context.getBean(BukuDao.class);
       
       List<Buku> list = dao.daftarList();
       for(Buku buku : list){
    	   System.out.println(buku.toString());
       }
    }

}
