package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * Author: hemraj
 * Date:  2/17/18.
 */
public class QueryStudentDemo {

    public static void main(String[] args) {

//        Create session factory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(StudentEntity.class)
                .buildSessionFactory();


//        create session
        Session session = sessionFactory.getCurrentSession();

        try {

//            start transaction
            session.beginTransaction();


//            query student
            List<StudentEntity> students = session.createQuery("from StudentEntity ").list();


//            Query student using where clause
            List<StudentEntity> students2 = session.createQuery("from StudentEntity s where s.firstName='sabdesh'").list();

//            Query using like clause
            List<StudentEntity> students3 = session.createQuery("from StudentEntity s where s.email like '%HEM.com' " +
                    "and s.firstName like 's%'").list();


//            Retrieve student Last name = Rijal or first name= sandesh
            List<StudentEntity> list = session.createQuery("from StudentEntity s where s.firstName='sandesh' or " +
                    "s.lastName='Rijal'").list();
//            Display all student
            System.out.println("---------List of all students------------");
            displayStudent(students);

//            Display specific students
            System.out.println();
            System.out.println();
            System.out.println("-------------List of student having first name = sabdesh----------");
            displayStudent(students2);


//            Display specific students using query
            System.out.println();
            System.out.println();
            System.out.println("----------List of student having first name = sabdesh or last name = Rijal--------");
            displayStudent(list);

            //  Display specific students
            System.out.println();
            System.out.println();
            System.out.println("--------List of student having email=like Hem@com and first name start with s--------");
            displayStudent(students3);

//            commit transaction
            session.getTransaction().commit();
            session.close();


            System.out.println("I am done----------------------");
        } finally {
            sessionFactory.close();
        }

    }

    public static void displayStudent(List<StudentEntity> students) {
        for (StudentEntity entity : students) {
            System.out.println(entity);
        }
    }
}
