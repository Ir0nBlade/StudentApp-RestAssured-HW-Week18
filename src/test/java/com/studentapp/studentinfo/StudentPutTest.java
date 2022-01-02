package com.studentapp.studentinfo;

import com.studentapp.model.StudentPojo;
import com.studentapp.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class StudentPutTest extends TestBase {

    @Test
    public void updateStudentWithPut() {
        List<String> courseList = new ArrayList<>();
        courseList.add("Jira");
        courseList.add("Postman");
        StudentPojo studentPojo = new StudentPojo();
        studentPojo.setFirstName("Harry");
        studentPojo.setLastName("Potter");
        studentPojo.setEmail("prime1@gmail.com");
        studentPojo.setProgramme("Manual Testing");
        studentPojo.setCourses(courseList);

        Response response = given()
                .header("Content-Type", "application/json")
                .pathParam("id", "101")
                .body(studentPojo)
                .when()
                .put("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }


}
