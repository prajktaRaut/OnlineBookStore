package com.thoughtworks.onlinebookstore;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;

public class AddBookTest extends BaseTest {

    @Test
    public void givenApiUnderExecution_WhenOwnerTriesToAddBooksWithValidDetails_ThenBookShouldBeAddedToDatabase() throws ParseException {
        Response response= RestAssured.given()
                .contentType(ContentType.JSON)
                .when()
                .body("{\n" +
                        " \"authorName\": \"abc\",\n" +
                        " \"bookName\": \"Journey to thoughtWorks\",\n" +
                        " \"description\": \"undefine-able\",\n" +
                        " \"image\": \"asd.png\",\n" +
                        " \"price\": 100,\n" +
                        " \"quantity\": 5\n" +
                        "}\n")
                .post("/post");
        response.then().assertThat().statusCode(200);
    }

    @Test
    public void givenApiUnderExecution_WhenOwnerTriesToAddBooks_ThenQuantityShouldBeNonNegativeValue() {
        Response response= RestAssured.given()
                .contentType(ContentType.JSON)
                .when()
                .body("{\n" +
                        " \"authorName\": \"abc\",\n" +
                        " \"bookName\": \"Journey to thoughtWorks\",\n" +
                        " \"description\": \"undefine-able\",\n" +
                        " \"image\": \"asd.jpg\",\n" +
                        " \"price\": 100,\n" +
                        " \"quantity\": -5\n" +
                        "}\n")
                .post("/post");
        response.then().assertThat().statusCode(400);
    }

    @Test
    public void givenApiUnderExecution_WhenOwnerTriesToAddBooks_ThenImageMustHaveValidExtension() {
        Response response= RestAssured.given()
                .contentType(ContentType.JSON)
                .when()
                .body("{\n" +
                        " \"authorName\": \"abc\",\n" +
                        " \"bookName\": \"Journey to thoughtWorks\",\n" +
                        " \"description\": \"undefine-able\",\n" +
                        " \"image\": \"asd.\",\n" +
                        " \"price\": 100,\n" +
                        " \"quantity\": 5\n" +
                        "}\n")
                .post("/post");
        response.then().assertThat().statusCode(400);
    }
    @Test
    public void givenApiUnderExecution_WhenOwnerTriesToAddBooks_ThenPriceShouldBePositive() {
        Response response= RestAssured.given()
                .contentType(ContentType.JSON)
                .when()
                .body("{\n" +
                        " \"authorName\": \"abc\",\n" +
                        " \"bookName\": \"Journey to thoughtWorks\",\n" +
                        " \"description\": \"undefine-able\",\n" +
                        " \"image\": \"asd.png\",\n" +
                        " \"price\": -100,\n" +
                        " \"quantity\": 5\n" +
                        "}\n")
                .post("/post");
        response.then().assertThat().statusCode(400);
    }

    @Test
    public void givenApiUnderExecution_WhenOwnerTriesToAddBooks_ThenPriceCanBeFractionalValue() {
        Response response= RestAssured.given()
                .contentType(ContentType.JSON)
                .when()
                .body("{\n" +
                        " \"authorName\": \"abc\",\n" +
                        " \"bookName\": \"Journey to thoughtWorks\",\n" +
                        " \"description\": \"undefine-able\",\n" +
                        " \"image\": \"asd.png\",\n" +
                        " \"price\": 100.55,\n" +
                        " \"quantity\": 5\n" +
                        "}\n")
                .post("/post");
        response.then().assertThat().statusCode(200);
    }
}
