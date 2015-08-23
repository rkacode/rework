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
@RequestMapping("presentation")
public class PresentationResource {

    @Autowired
    PresentationService presentationService;

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity add(@RequestBody Presentation presentation) {
        presentationService.save(presentation);
	return new ResponseEntity(HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Presentation> findAll() {
	return presentationService.findAll();
    }

}
