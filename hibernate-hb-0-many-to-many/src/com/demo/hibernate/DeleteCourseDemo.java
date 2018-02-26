package com.demo.hibernate;

import com.demo.hibernate.entity.Course;
import com.demo.hibernate.entity.InstructorDetailEntity;
import com.demo.hibernate.entity.InstructorEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Author: hemraj
 * Date:  2/17/18.
 */
public class DeleteCourseDemo {

    public static void main(String[] args) {

//        Create session factory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(InstructorEntity.class)
                .addAnnotatedClass(InstructorDetailEntity.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();


//        create session
        Session session = sessionFactory.getCurrentSession();

        try {
//            start transaction
            session.beginTransaction();

//get course from database
            int theId = 1;
            Course course = session.get(Course.class, theId);


//            Delete course
            System.out.println("Deleting Course-------->" + course);
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
