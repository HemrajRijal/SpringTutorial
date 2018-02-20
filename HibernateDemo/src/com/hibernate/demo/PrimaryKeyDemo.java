package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Author: hemraj
 * Date:  2/19/18.
 */
public class PrimaryKeyDemo {

    public static void main(String[] args) {
        //        Create session factory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(StudentEntity.class)
                .buildSessionFactory();


//        create session
        Session session = sessionFactory.getCurrentSession();

        try {

//            Insert 3 students object
            System.out.println("Creating 3 students object");
            StudentEntity studentEntity = new StudentEntity("sandip", "Rijal", "sandip@HEM.COM");
            StudentEntity studentEntity2 = new StudentEntity("sabdesh", "Rijal", "sabdesh@HEM.COM");
            StudentEntity studentEntity3 = new StudentEntity("sandesh", "Rijal", "sandesh@HEM.COM");


//            start transaction
            session.beginTransaction();

//            save student object
            System.out.println("Saving the student.........");
            session.save(studentEntity);
            session.save(studentEntity2);
            session.save(studentEntity3);


//            commit transaction
            session.getTransaction().commit();
            session.close();


            System.out.println("I am done----------------------");
        } finally {
            sessionFactory.close();
        }

    }
}
