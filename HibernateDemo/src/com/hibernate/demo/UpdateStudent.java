package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Author: hemraj
 * Date:  2/17/18.
 */
public class UpdateStudent {

    public static void main(String[] args) {

//        Create session factory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(StudentEntity.class)
                .buildSessionFactory();

        try {

            int id = 3;

//            get session and start transaction
            Session  session = sessionFactory.getCurrentSession();
            session.beginTransaction();


//            retrieve student using id
            System.out.println("Retrieve student of ID-->" + id);

            StudentEntity student = session.get(StudentEntity.class, id);


            System.out.println("Updating Student Using Query------------" + student);
            session.createQuery("UPDATE StudentEntity s SET s.firstName='Hemraj' where s.id=1")
            .executeUpdate();

//            commit the transaction
            session.getTransaction().commit();

            System.out.println("I am done----------------------");
        } finally {
            sessionFactory.close();
        }

    }
}
