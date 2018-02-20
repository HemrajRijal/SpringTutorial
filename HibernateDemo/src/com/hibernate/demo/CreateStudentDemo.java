package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Author: hemraj
 * Date:  2/17/18.
 */
public class CreateStudentDemo {

    public static void main(String[] args) {

//        Create session factory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(StudentEntity.class)
                .buildSessionFactory();


//        create session
        Session session = sessionFactory.getCurrentSession();

        try {

//            create student object
            System.out.println("Creating new student object");
            StudentEntity studentEntity = new StudentEntity("Ramesh", "Rijal", "rr@HEM.COM");


//            start transaction
            session.beginTransaction();

//            save student object
            System.out.println("Saving the student.........");
            session.save(studentEntity);


//            commit transaction
            session.getTransaction().commit();
            session.close();


            System.out.println("I am done----------------------");
        } finally {
            sessionFactory.close();
        }

    }
}
