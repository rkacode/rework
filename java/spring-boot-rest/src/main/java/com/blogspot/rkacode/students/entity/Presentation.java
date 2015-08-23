package com.blogspot.rkacode.students.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

@Entity
@Table(name="presentation")
@NamedQueries(value = {
        @NamedQuery(name = "Presentation.findAll", query = "SELECT p FROM Presentation p")
})
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Presentation {

    @Id
    @GeneratedValue
    private int id;

    private String title;

    @ManyToOne
    private Student student;

    public Presentation(String title) {
	this.title = title;
    }

    public Presentation() {
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getTitle() {
	return title;
    }

    public void setTitle(String title) {
	this.title = title;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

}
