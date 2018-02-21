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
public class DeleteDemo {

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


//get instructor by primary id
            int id = 1;
            InstructorEntity instructor = session.get(InstructorEntity.class, id);

            System.out.println("Found instructor-->" + instructor);

//            Delete the instructor
            if (instructor != null) {
                System.out.println("Deleting--->" + instructor);


                /**
                 * Note: This will also delete instuctor detail
                 * because of Cascading.ALL*/
                session.delete(instructor);
            }
//            commit transaction
            session.getTransaction().commit();


            System.out.println("I am done----------------------");
        } finally {
            sessionFactory.close();
        }

    }
}
