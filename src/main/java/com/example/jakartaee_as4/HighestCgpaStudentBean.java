package com.example.jakartaee_as4;

import javax.ejb.Singleton;
import javax.persistence.*;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Singleton
@Path("/student/highest-cgpa")
public class HighestCgpaStudentBean {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getHighestCgpaStudent() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("student_pu");
        EntityManager em = emf.createEntityManager();

        Student highestCgpaStudent;
        try {
            String jpql = "SELECT s FROM Student s ORDER BY s.cgpa DESC";
            TypedQuery<Student> query = em.createQuery(jpql, Student.class);
            query.setMaxResults(1);
            highestCgpaStudent = query.getSingleResult();
        }
        catch (NoResultException e)
        {
            return "No entities were found!";
        }

        return "Student with ID " + highestCgpaStudent.getStudentID() + " has the highest CGPA with value '" + highestCgpaStudent.getCgpa() +"'";
    }
}