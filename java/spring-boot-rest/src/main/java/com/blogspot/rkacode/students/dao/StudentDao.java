package com.blogspot.rkacode.students.dao;

import com.blogspot.rkacode.students.entity.Student;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@SuppressWarnings("unchecked")
public class StudentDao {
    @PersistenceContext
    EntityManager entityManager;

    public Student findById(int id) {
	return entityManager.find(Student.class, id);
    }

    public void save(Student student) {
	entityManager.persist(student);
    }

    public List<Student> findAll() {
	return entityManager.createNamedQuery("Student.findAll")
		.getResultList();
    }

    public void remove(int id) {
	Student student = entityManager.find(Student.class, id);
        if (student != null) {
            entityManager.remove(student);
        }
    }
}
