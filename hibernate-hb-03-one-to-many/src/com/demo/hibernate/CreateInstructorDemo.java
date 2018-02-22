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
public class CreateInstructorDemo {

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

//            create the objects
            InstructorEntity instructor =
                    new InstructorEntity("Ramesh", "Rijal", "rr@hem.com");


            InstructorDetailEntity instructorDetail =
                    new InstructorDetailEntity("hemraj.rijal.com.np", "love to code");

//            Associate the objects
            instructor.setInstructorDetail(instructorDetail);

//            start transaction
            session.beginTransaction();


//            save the instructor
            /**Save the instructor
             * Note: this will also save instructor details
             * because of CascadeType.All*/
            System.out.println("Saving Instructor-->" + instructor);
            session.save(instructor);

//            commit transaction
            session.getTransaction().commit();


            System.out.println("I am done----------------------");
        } finally {
            session.close();
            sessionFactory.close();
        }

    }
}
