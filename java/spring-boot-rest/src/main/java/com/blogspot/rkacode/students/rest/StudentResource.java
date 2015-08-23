package com.blogspot.rkacode.students.rest;


import com.blogspot.rkacode.students.entity.Presentation;
import com.blogspot.rkacode.students.entity.Student;
import com.blogspot.rkacode.students.rest.exception.ResourceNotFoundException;
import com.blogspot.rkacode.students.service.PresentationService;
import com.blogspot.rkacode.students.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("students")
public class StudentResource {

    @Autowired
    StudentService studentService;

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity add(@RequestBody Student student) {
        studentService.save(student);
	return new ResponseEntity(HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Student> findAll() {
	return studentService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Student findById(@PathVariable int id) {
	Student student = studentService.findById(id);
	if (student == null) {
	    throw new ResourceNotFoundException("Student id [" + id + "] not found");
	}

	return student;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable int id) {
        studentService.remove(id);
	return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/{id}/presentations", method = RequestMethod.PUT)
    public ResponseEntity addPresentation(@PathVariable int id, @RequestBody Presentation presentation) {
        studentService.addPresentation(id, presentation);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{studentId}/presentations/{presentationId}", method = RequestMethod.DELETE)
    public ResponseEntity unassignPresentation(@PathVariable int studentId, @PathVariable int presentationId) {
        studentService.unassign(studentId, presentationId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
