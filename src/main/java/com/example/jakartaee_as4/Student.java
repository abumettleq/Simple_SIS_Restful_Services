package com.example.jakartaee_as4;

import javax.persistence.*;

@Entity
@Table(name = "student")
@NamedQuery(name = "Student.getNameByID", query = "SELECT s.studentName FROM Student s WHERE s.studentID = :id")
@NamedQuery(name = "Student.getCGPAByID", query = "SELECT s.cgpa FROM Student s WHERE s.studentID = :id")
@NamedQuery(name = "Student.updateStudentName", query = "UPDATE Student s SET s.studentName = :name WHERE s.studentID = :id")
public class Student {
    @Id
    @Column(name = "studentID")
    private int studentID;

    @Column(name = "studentName")
    private String studentName;

    @Column(name = "semester")
    private String semester;

    @Column(name = "cgpa")
    private double cgpa;

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getStudentID() {
        return studentID;
    }

    public String getSemester() {
        return semester;
    }

    public double getCgpa() {
        return cgpa;
    }

    public String getStudentName() {
        return studentName;
    }

}