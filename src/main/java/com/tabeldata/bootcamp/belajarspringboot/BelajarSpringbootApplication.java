package com.tabeldata.bootcamp.belajarspringboot;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

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

		// cari data buku berdasarkan id = prog-java
		try {
			Buku progJava = dao.findById("prog-java");
			progJava.setNamaPengarang("Hari sapto adi");
			progJava.setLastUpdatedDate(Timestamp.valueOf(LocalDateTime.now()));
			progJava.setLastUpdatedBy("dimas");
			dao.update(progJava);
			
			System.out.println(progJava.toString());
		} catch (EmptyResultDataAccessException erdae) {			
			System.err.println("Data tidak ditemukan");
		}
		
		System.out.println("--- pencarian by nama dan nama pengarang ---");

		// cari data buku berdasarkan nama yang mengandung huruf a dan nama pengarang yang mengandung huruf D
		List<Buku> listByNamaAndPengarang = dao.findByNamaAndNamaPengarang("a", "d");
		System.out.println("jumlah data pencarian: " + listByNamaAndPengarang.size());
		for (Buku buku : listByNamaAndPengarang) {
			System.out.println(buku.toString());
		}
		
		Buku pemograman = new Buku();
		pemograman.setId(UUID.randomUUID().toString());
		pemograman.setNama("Bahasa pemograman java baru");
		pemograman.setIsbn("12342314234");
		pemograman.setNamaPengarang("Dimas Maryanto");
		pemograman.setPenerbit("Gramedia");
		pemograman.setTahunTerbit(2018);
		pemograman.setCreatedBy("operator");
		
		dao.save(pemograman);
		
		dao.delete(pemograman.getId());
		
		System.out.println("pencarian data semua setelah insert");
		
		List<Buku> list = dao.daftarList();
		for(Buku buku : list) {
			System.out.println(buku.toString());
		}
	}

}
