package com.tabeldata.bootcamp.belajarspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;

import com.tabeldata.bootcamp.belajarspringboot.dao.BukuDao;
import com.tabeldata.bootcamp.belajarspringboot.model.Buku;

@SpringBootApplication
public class BelajarSpringbootApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(BelajarSpringbootApplication.class, args);

		BukuDao dao = context.getBean(BukuDao.class);
		try {
			Buku pegEmptyPangarang = dao.findById("prog-empty-pengarng");

			System.out.println(pegEmptyPangarang.toString());
		} catch (EmptyResultDataAccessException erdae) {
			erdae.printStackTrace();
			System.err.println("Data tidak ditemukan");
		}
		System.out.println("ini program ditampilkan");

	}

}
