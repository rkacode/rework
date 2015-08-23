package com.blogspot.rkacode.students.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

@Entity
@Table(name = "student")
@NamedQueries(value = {
        @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s")
})
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Student {
    @Id
    @GeneratedValue
    private int id;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "student")
    private Collection<Presentation> presentations = new ArrayList<>();

    private String firstName;

    private String lastName;

    public Student(String firstName, String lastName) {
	this.firstName = firstName;
	this.lastName = lastName;
    }

    public Student() {
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getFirstName() {
	return firstName;
    }

    public void setFirstName(String firstName) {
	this.firstName = firstName;
    }

    public String getLastName() {
	return lastName;
    }

    public void setLastName(String lastName) {
	this.lastName = lastName;
    }

    public Collection<Presentation> getPresentations() {
	return presentations;
    }

    public void addPresentation(Presentation presentation) {
	presentations.add(presentation);
    }

}
