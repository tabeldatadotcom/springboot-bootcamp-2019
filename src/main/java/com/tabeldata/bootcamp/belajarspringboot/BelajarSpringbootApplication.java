package com.tabeldata.bootcamp.belajarspringboot;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BelajarSpringbootApplication {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-container.xml");
//        Mahasiswa dimas = (Mahasiswa) context.getBean("mahasiswa");
//
//        Kelas si = (Kelas) context.getBean("kelas");
//
//        System.out.println("nama: " + dimas.getNama() + " semester: " + dimas.getSemester() + " kelas: " + si.getNama());

        System.out.println("--- singleton ---");
        RandomString rs = context.getBean("randomString", RandomString.class);
        System.out.println(rs.getValue());

        rs = context.getBean("randomString", RandomString.class);
        System.out.println(rs.getValue());

        rs = context.getBean("randomString", RandomString.class);
        System.out.println(rs.getValue());

        rs = context.getBean("randomString", RandomString.class);
        System.out.println(rs.getValue());

        rs = context.getBean("randomString", RandomString.class);
        System.out.println(rs.getValue());

        rs = context.getBean("randomString", RandomString.class);
        System.out.println(rs.getValue());

        System.out.println("---prototype ---");

        RandomStringPrototype proto = context.getBean(RandomStringPrototype.class);
        System.out.println(proto.getValue());
        
        proto = context.getBean(RandomStringPrototype.class);
        System.out.println(proto.getValue());
        
        proto = context.getBean(RandomStringPrototype.class);
        System.out.println(proto.getValue());
        
        proto = context.getBean(RandomStringPrototype.class);
        System.out.println(proto.getValue());
        
        proto = context.getBean(RandomStringPrototype.class);
        System.out.println(proto.getValue());
        
        proto = context.getBean(RandomStringPrototype.class);
        System.out.println(proto.getValue());

    }

}
