package com.blogspot.rkacode.students.service;

import com.blogspot.rkacode.students.dao.PresentationDao;
import com.blogspot.rkacode.students.dao.StudentDao;
import com.blogspot.rkacode.students.entity.Presentation;
import com.blogspot.rkacode.students.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StudentService {

    @Autowired
    StudentDao studentDao;

    @Autowired
    PresentationDao presentationDao;

    public Student findById(int id) {
	return studentDao.findById(id);
    }

    public void save(Student student) {
	studentDao.save(student);
    }

    public List<Student> findAll() {
	return studentDao.findAll();
    }

    public void remove(int id) {
	studentDao.remove(id);
    }

    public void addPresentation(int id, Presentation presentation) {
	Student student = studentDao.findById(id);
	presentation.setStudent(student);
	student.addPresentation(presentation);
    }

    public void unassign(int studentId, int presentationId) {
        Presentation presentation = presentationDao.findById(presentationId);
        presentation.setStudent(null);

        Student student = studentDao.findById(studentId);
        student.getPresentations().remove(presentation);
    }

}
