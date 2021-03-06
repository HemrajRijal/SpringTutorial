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
public class CreateCourseDemo {

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

//           get the instructor from database
            int theId = 1;
            InstructorEntity instructor = session.get(InstructorEntity.class, theId);


//            create some courses
            Course course = new Course("Air Guitar The ultimate guide");
            Course course2 = new Course("Guitsr from zero to pro");

//            Add courses to instructor
            instructor.add(course);
            instructor.add(course2);

//            save the course
            session.save(course);
            session.save(course2);


//            commit transaction
            session.getTransaction().commit();


            System.out.println("I am done----------------------");
        } finally {
            session.close();
            sessionFactory.close();
        }

    }
}
