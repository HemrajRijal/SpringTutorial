package com.demo.hibernate;

import com.demo.hibernate.entity.InstructorDetailEntity;
import com.demo.hibernate.entity.InstructorEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Author: hemraj
 * Date:  2/17/18.
 */
public class GetInstructorDetailDemo {

    public static void main(String[] args) {

//        Create session factory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(InstructorEntity.class)
                .addAnnotatedClass(InstructorDetailEntity.class)
                .buildSessionFactory();


//        create session
        Session session = sessionFactory.getCurrentSession();

        try {

//            start transaction
            session.beginTransaction();

//            get the instructor detail object
            int theId = 7;

            InstructorDetailEntity instructorDetail = session.get(InstructorDetailEntity.class, theId);


//            print the instructor detail object
            System.out.println("Instructor Detail-->" + instructorDetail);

//            print the associated object
            System.out.println("Associated Instructor-->" + instructorDetail.getInstructor());

//            commit transaction
            session.getTransaction().commit();


            System.out.println("I am done----------------------");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }

    }
}
