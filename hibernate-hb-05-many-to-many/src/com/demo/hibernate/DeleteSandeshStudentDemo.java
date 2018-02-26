package com.demo.hibernate;

import com.demo.hibernate.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Author: hemraj
 * Date:  2/17/18.
 */
public class DeleteSandeshStudentDemo {

    public static void main(String[] args) {

//        Create session factory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(InstructorEntity.class)
                .addAnnotatedClass(InstructorDetailEntity.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(StudentEntity.class)
                .buildSessionFactory();


//        create session
        Session session = sessionFactory.getCurrentSession();

        try {
//            start transaction
            session.beginTransaction();


//            Get Student from Database
            int id = 3;
            StudentEntity studentEntity = session.get(StudentEntity.class, id);

//            Delete the Student
            System.out.println("\n ----Deleting Student------");
            session.delete(studentEntity);

//            commit transaction
            session.getTransaction().commit();


            System.out.println("I am done----------------------");
        } finally {
            session.close();
            sessionFactory.close();
        }

    }
}
