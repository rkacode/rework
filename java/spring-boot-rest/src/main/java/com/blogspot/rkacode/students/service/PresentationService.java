package com.blogspot.rkacode.students.service;

import com.blogspot.rkacode.students.dao.PresentationDao;
import com.blogspot.rkacode.students.entity.Presentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PresentationService {

    @Autowired
    PresentationDao presentationDao;

    public void save(Presentation presentation) {
	presentationDao.save(presentation);
    }

    public List<Presentation> findAll() {
	return presentationDao.findAll();
    }
}
