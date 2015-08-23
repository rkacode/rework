package com.blogspot.rkacode.bean;

import com.blogspot.rkacode.model.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@SuppressWarnings("unchecked")
@Transactional
public class CarDao {
    @Autowired
    SessionFactory sessionFactory;

    public void add(Car car) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(car);
    }

    public List<Car> getAll() {
        return sessionFactory.getCurrentSession()
                .createQuery("from Car")
                .list();
    }
}
