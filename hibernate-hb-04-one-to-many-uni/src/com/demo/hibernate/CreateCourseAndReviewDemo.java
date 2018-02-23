package com.demo.hibernate;

import com.demo.hibernate.entity.Course;
import com.demo.hibernate.entity.InstructorDetailEntity;
import com.demo.hibernate.entity.InstructorEntity;
import com.demo.hibernate.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Author: hemraj
 * Date:  2/17/18.
 */
public class CreateCourseAndReviewDemo {

    public static void main(String[] args) {

//        Create session factory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(InstructorEntity.class)
                .addAnnotatedClass(InstructorDetailEntity.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();


//        create session
        Session session = sessionFactory.getCurrentSession();

        try {
//            start transaction
            session.beginTransaction();

// Create course
            Course course = new Course("Stole the King");


//            Add some review
            course.addReview(new Review("oh, holly crap !!"));
            course.addReview(new Review("Dude, go and do other stuff !!"));
            course.addReview(new Review("oh, I love your tutorial !!"));

//            Save the course and leverage the cascade.ALl
            System.out.println("Saving the Course");
            System.out.println(course);
            System.out.println(course.getReviews());
            session.save(course);

//            commit transaction
            session.getTransaction().commit();


            System.out.println("I am done----------------------");
        } finally {
            session.close();
            sessionFactory.close();
        }

    }
}
