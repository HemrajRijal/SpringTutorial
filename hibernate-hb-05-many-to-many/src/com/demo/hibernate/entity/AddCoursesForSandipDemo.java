package com.demo.hibernate.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Author: hemraj
 * Date:  2/17/18.
 */
public class AddCoursesForSandipDemo {

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

//            Get student hem from databases
            int id = 2;
            StudentEntity temp = session.get(StudentEntity.class, id);
            System.out.println("\n Loaded Student-->" + temp);
            System.out.println("Courses-->" + temp.getCourses());

//            Create more courses
            Course course = new Course("Master the Rubiks Cube");
            Course course2 = new Course("Master the Guitar");
            Course course3 = new Course("Game Development");


//            add Student to course
            course.addStudent(temp);
            course2.addStudent(temp);
            course3.addStudent(temp);


//            Save the course
            session.save(course);
            session.save(course2);
            session.save(course3);


//            commit transaction
            session.getTransaction().commit();


            System.out.println("I am done----------------------");
        } finally {
            session.close();
            sessionFactory.close();
        }

    }
}
