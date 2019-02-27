package com.tabeldata.bootcamp.belajarspringboot;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BelajarSpringbootApplication {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-container.xml");
        Mahasiswa dimas = (Mahasiswa) context.getBean("mahasiswa");
        System.out.println(dimas.toString());
        
        Mahasiswa yusuf = (Mahasiswa) context.getBean("mahasiswa");
        System.out.println(yusuf.toString());
     
        Kelas si = (Kelas) context.getBean("kelas");
        System.out.println(si.toString());

    }

}
