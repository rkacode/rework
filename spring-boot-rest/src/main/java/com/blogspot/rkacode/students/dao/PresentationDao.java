package com.blogspot.rkacode.students.dao;

import com.blogspot.rkacode.students.entity.Presentation;
import com.blogspot.rkacode.students.entity.Student;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@SuppressWarnings("unchecked")
public class PresentationDao {

    @PersistenceContext
    EntityManager entityManager;

    public Presentation findById(int id) {
	return entityManager.find(Presentation.class, id);
    }

    public void remove(int id) {
        Presentation presentation = entityManager.find(Presentation.class, id);
        if (presentation != null) {
            entityManager.remove(presentation);
        }
    }

    public void save(Presentation presentation) {
        entityManager.persist(presentation);
    }

    public List<Presentation> findAll() {
        return entityManager.createNamedQuery("Presentation.findAll")
                .getResultList();
    }
}
