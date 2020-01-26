package com.thoughtworks.onlinebookstore;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;

public class CustomerIdByemailTest extends  BaseTest {

    @Test
    public void givenApiUnderExecution_WhenEnteredEmailid_ShouldReturnCustomerId() {
        try {
            Response response= RestAssured.given()
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                    .when()
                    .pathParam("email","hemilturakhia@gmail.com")
                    .get("/id/{email}");
            ResponseBody body = response.getBody();
            Object Object = new JSONParser().parse(body.prettyPrint());
            response.then().assertThat().statusCode(200);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenApiUnderExecution_WhenEnteredAbsentEmailid_ShouldReturnErrorMessage() {
        try {
            Response response= RestAssured.given()
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                    .when()
                    .pathParam("email","hemil@gmail.com")
                    .get("/id/{email}");
            ResponseBody body = response.getBody();
            Object Object = new JSONParser().parse(body.prettyPrint());
            response.then().assertThat().statusCode(500);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenApiUnderExecution_WhenEmailiIdFieldIsEmpty_ShouldReturnErrormessage() {
        try {
            Response response= RestAssured.given()
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                    .when()
                    .pathParam("email","")
                    .get("/id/{email}");
            ResponseBody body = response.getBody();
            Object Object = new JSONParser().parse(body.prettyPrint());
            response.then().assertThat().statusCode(404);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenApiUnderExecution_WhenEnteredInvalidEmailid_ShouldGiveErrorMessage() {
        try {
            Response response= RestAssured.given()
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                    .when()
                    .pathParam("email","hemilturakhia..!@2@gmail.com")
                    .get("/id/{email}");
            ResponseBody body = response.getBody();
            Object Object = new JSONParser().parse(body.prettyPrint());
            response.then().assertThat().statusCode(500);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
