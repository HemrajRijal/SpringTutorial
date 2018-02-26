package com.demo.hibernate;

import com.demo.hibernate.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Author: hemraj
 * Date:  2/17/18.
 */
public class CreateCourseAndStudentDemo {

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

// Create course
            Course course = new Course("Stole the King");

//          Save the course and leverage the cascade.ALl
            System.out.println("\n Saving Student.........");
            session.save(course);
            System.out.println("Saved Course--->" + course);

            //Create Student
            StudentEntity student = new StudentEntity("Ramesh", "Rijal", "rr@hem.com");
            StudentEntity student2 = new StudentEntity("Sandip", "Rijal", "sr@hem.com");
            StudentEntity student3 = new StudentEntity("Sandesh", "Rijal", "sr@hem.com");


//            Add student to the course
            System.out.println("\n Saving Student----");
            course.addStudent(student);
            course.addStudent(student2);
            course.addStudent(student3);
            System.out.println("\n Saved Student;::::->" + course.getStudentList());

//            Save student
            session.save(student);
            session.save(student2);
            session.save(student3);
            System.out.println();


//            commit transaction
            session.getTransaction().commit();


            System.out.println("I am done----------------------");
        } finally {
            session.close();
            sessionFactory.close();
        }

    }
}
