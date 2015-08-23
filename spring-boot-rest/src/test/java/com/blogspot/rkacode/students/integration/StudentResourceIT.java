package com.blogspot.rkacode.students.integration;

import com.blogspot.rkacode.students.config.RestConfig;
import com.blogspot.rkacode.students.entity.Student;
import com.blogspot.rkacode.students.util.ResourceLoader;
import com.blogspot.rkacode.students.util.TransactionExecutor;
import com.jayway.restassured.RestAssured;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

import static com.jayway.restassured.RestAssured.expect;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {RestConfig.class})
@WebIntegrationTest("server.port:0")
@SuppressWarnings("unchecked")
public class StudentResourceIT extends IntegrationTestBase {

    private static final ResourceLoader RESOURCE_LOADER = new ResourceLoader(StudentResourceIT.class);

    @Autowired
    TransactionExecutor transactionExecutor;

    private Student john;

    @Before
    public void setUp() {
        RestAssured.authentication = RestAssured.basic("user", "password");
        RestAssured.port = port;
        RestAssured.baseURI = getHostAddress();
        RestAssured.basePath = "/students/";

        john = new Student("John", "Doe");
        transactionExecutor.runInTransaction(em -> em.persist(john));
    }

    @After
    public void clear() {
        transactionExecutor.runInTransaction(em -> {
            Student managed = em.find(Student.class, john.getId());
            em.remove(managed);
        });
    }

    @Test
    public void getStudent() {
        expect()
            .body("firstName", equalTo("John"))
        .when()
            .get(String.valueOf(john.getId()));
    }

    @Test
    public void getAllStudents() throws IOException {
	    String expected = RESOURCE_LOADER.readFile("students.json");

        expect()
            .body(equalTo(expected))
        .when()
            .get();
    }

}
