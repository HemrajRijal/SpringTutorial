package com.demo.hibernate;

import com.demo.hibernate.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Author: hemraj
 * Date:  2/17/18.
 */
public class DeleteGuitarCourseDemo {

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


//            Get Guitar course from Database
            int id = 3;
            Course course = session.get(Course.class, id);

//            Delete the course
            System.out.println("\n ----Deleting Course------");
            session.delete(course);

//            commit transaction
            session.getTransaction().commit();


            System.out.println("I am done----------------------");
        } finally {
            session.close();
            sessionFactory.close();
        }

    }
}
