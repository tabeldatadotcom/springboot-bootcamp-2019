package com.tabeldata.bootcamp.belajarspringboot;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BelajarSpringbootApplication {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-container.xml");
       Mahasiswa dimas =(Mahasiswa) context.getBean("dimas");
       
      
       System.out.println("nama: "+ dimas.getNama() +" semester: "+dimas.getSemester()+ " kelas: "+ dimas.getKelas().getNama());
    }

}
