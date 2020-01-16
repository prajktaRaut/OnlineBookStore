package com.thoughtworks.onlinebookstore;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BookListFromDBTest extends BaseTest {

    @Test
    public void givenGetBookListApi_WhenHitApi_ShouldReturnAllBookDetails() {
        try {
            Response response=RestAssured.given()
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                    .when()
                    .get("/list");
            int statusCode = response.getStatusCode();
            ResponseBody body = response.getBody();
            Object Object = new JSONParser().parse(body.prettyPrint());
            Assert.assertEquals(statusCode,200);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenGetBookApi_WhenHitApi_ShouldReturnThatBookDetails() {
        try {
            Response response=RestAssured.given()
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                    .when()
                    .request().queryParam("quantity",0)
                    .pathParam("id",2)
                    .get("/get/{id}");
            int statusCode = response.getStatusCode();
            ResponseBody body = response.getBody();
            Object Object = new JSONParser().parse(body.prettyPrint());
            Assert.assertEquals(statusCode,200);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenGetBookApi_WhenHitApi_ShouldNotReturnTheBookDetails() {
        try {
            Response response=RestAssured.given()
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                    .when()
                    .request().queryParam("quantity",50)
                    .pathParam("id",2)
                    .get("/get/{id}");
            int statusCode = response.getStatusCode();
            ResponseBody body = response.getBody();
            Object Object = new JSONParser().parse(body.prettyPrint());
            Assert.assertEquals(statusCode,500);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
