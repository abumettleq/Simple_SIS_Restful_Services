package com.example.jakartaee_as4;

import org.hibernate.annotations.Cascade;

import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.*;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.net.URI;

@Path("/student")
@Stateless
public class StudentBean {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("student_pu");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    EntityTransaction transaction = entityManager.getTransaction();

    @GET
    @Path("/add")
    public String addStudent(
            @QueryParam("studentID") int studentID,
            @QueryParam("studentName") String studentName,
            @QueryParam("semester") String semester,
            @QueryParam("cgpa") double cgpa) {

        if(entityManager.find(Student.class, studentID) != null)
        {
            return "<h1>STUDENT WITH ID "+studentID+" ALREADY EXISTS</h1>";
        }

        Student student = new Student();
        student.setStudentID(studentID);
        student.setStudentName(studentName);
        student.setSemester(semester);
        student.setCgpa(cgpa);

        transaction.begin();
        entityManager.persist(student);
        transaction.commit();

        if(entityManager.find(Student.class, studentID) != null)
        {
            return "<h1>Student added successfully</h1>";
        }
        else
        {
            return "<h1>Failed to add new student</h1>";
        }
    }

    @GET
    @Path("/{studentID}/studentName")
    public String getStudentName(@PathParam("studentID") int studentID) {
        try {
            Query query = entityManager.createNamedQuery("Student.getNameByID");
            query.setParameter("id", studentID);
            String studentName = (String) query.getSingleResult();
            return "Student's name with ID '" + studentID + "' is \"" + studentName + "\"";
        }
        catch (NoResultException e)
        {
            return "No student found with this ID '" + studentID + "'";
        }
    }

    @GET
    @Path("/compare")
    public String compareCgpa(@QueryParam("firstID") int studentID1, @QueryParam("secondID") int studentID2) {
        double student1CGPA;
        try {
            Query query = entityManager.createNamedQuery("Student.getCGPAByID");
            query.setParameter("id", studentID1);
            student1CGPA = (double) query.getSingleResult();
        } catch (NoResultException e) {
            return "No student found with this ID '" + studentID1 + "'";
        }

        double student2CGPA;
        try {
            Query query = entityManager.createNamedQuery("Student.getCGPAByID");
            query.setParameter("id", studentID2);
            student2CGPA = (double) query.getSingleResult();
        } catch (NoResultException e) {
            return "No student found with this ID '" + studentID2 + "'";
        }


        if (student1CGPA > student2CGPA) {
            return "The student with ID '" + studentID1 + "' has a greater CGPA with value '" + student1CGPA + "'";
        }
        else if(student1CGPA == student2CGPA)
        {
            return "Both the students with ID '" + studentID1 + "' and ID '" + studentID2 + "' has the same CGPA with value '" + student1CGPA + "'";
        }
        else {
            return "The student with ID '" + studentID2 + "' has a greater CGPA with value '" + student2CGPA + "'";
        }
    }

    @GET
    @Path("/update")
    public String updateStudentName(@QueryParam("studentID") int studentID, @QueryParam("studentName") String studentName) {
        try
        {
            Query query = entityManager.createNamedQuery("Student.updateStudentName");
            query.setParameter("id",studentID);
            query.setParameter("name",studentName);
            query.executeUpdate();

            return "Updated successfully!";
        }
        catch (NoResultException e)
        {
            return "No student found with this ID '" + studentID + "'";
        }
    }
}