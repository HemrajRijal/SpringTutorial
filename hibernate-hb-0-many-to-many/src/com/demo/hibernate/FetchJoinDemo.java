package com.demo.hibernate;

import com.demo.hibernate.entity.Course;
import com.demo.hibernate.entity.InstructorDetailEntity;
import com.demo.hibernate.entity.InstructorEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

/**
 * Author: hemraj
 * Date:  2/22/18.
 */
public class FetchJoinDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(InstructorEntity.class)
                .addAnnotatedClass(InstructorDetailEntity.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {

            // start a transaction
            session.beginTransaction();

            // option 2: Hibernate query with HQL

            // get the instructor from db
            int theId = 1;

            Query<InstructorEntity> query =
                    session.createQuery("select i from InstructorEntity i "
                                    + "JOIN FETCH i.courses "
                                    + "where i.id=:theInstructorId",
                            InstructorEntity.class);

            // set parameter on query
            query.setParameter("theInstructorId", theId);

            // execute query and get instructor
            InstructorEntity tempInstructor = query.getSingleResult();

            System.out.println("luv2code: Instructor: " + tempInstructor);

            // commit transaction
            session.getTransaction().commit();

            // close the session
            session.close();

            System.out.println("\nluv2code: The session is now closed!\n");

            // get courses for the instructor
            System.out.println("luv2code: Courses: " + tempInstructor.getCourses());

            System.out.println("luv2code: Done!");
        } finally {

            // add clean up code
            session.close();

            factory.close();
        }
    }

}