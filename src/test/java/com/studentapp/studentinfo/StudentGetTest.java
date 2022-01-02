package com.studentapp.studentinfo;

import com.studentapp.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class StudentGetTest extends TestBase {

    @Test
    public void getAllStudentsInfo(){
        Response response = given()
                .when()
                .get("/list");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void getSignleStudentInfo(){
        Response response =given()
                .pathParam("id",3)
                .when()
                .get("");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void searchStudentWithParameter(){
        HashMap<String, Object> qParms = new HashMap<>();
        qParms.put("programme", "Financial Analysis");
        qParms.put("limit", 2);

        Response response = given()
                .queryParams(qParms)
                .when()
                .get("/list");
        response.then().statusCode(200);
        response.prettyPrint();
    }

}
