package com.codegym.controller;

import com.codegym.entity.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
public class StudentRestController_getListStudent {

    @Autowired
    private StudentRestController studentRestController;

    @Test
    public void getListStudent_5() {
        ResponseEntity<Page<Student>> pageResponseEntity
                = this.studentRestController.getListStudent(PageRequest.of(0, 2));

        Assertions.assertEquals(HttpStatus.NOT_FOUND, pageResponseEntity.getStatusCode());
    }

    @Test
    public void getListStudent_6() {
        ResponseEntity<Page<Student>> pageResponseEntity
                = this.studentRestController.getListStudent(PageRequest.of(0, 2));

        Assertions.assertEquals(HttpStatus.OK, pageResponseEntity.getStatusCode());

        Page<Student> studentPage = pageResponseEntity.getBody();

        Assertions.assertEquals(5, studentPage.getTotalElements());
        Assertions.assertEquals(3, studentPage.getTotalPages());
        Assertions.assertEquals("Thịnh", studentPage.getContent().get(1).getName());
    }
}
