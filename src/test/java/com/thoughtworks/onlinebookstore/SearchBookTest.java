package com.thoughtworks.onlinebookstore;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class SearchBookTest extends BaseTest{

    @Test
    public void givenGetBookByNameApi_WhenHitApiWithProperBookName_ShouldReturnBookDetails() {
        try {
            Response response= RestAssured.given()
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                    .when()
                    .pathParam("bookName","Angel")
                    .get("/get/{bookName}");
            ResponseBody body = response.getBody();
            Object Object = new JSONParser().parse(body.prettyPrint());
            response.then().assertThat().statusCode(200);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Ignore
    @Test
    public void givenGetBookByNameApi_WhenHitApiWithWrongBookName_ShouldReturnNotFoundMessage() {
        try {
            Response response=RestAssured.given()
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                    .when()
                    .pathParam("bookName","abcd")
                    .get("/get/{bookName}");
            ResponseBody body = response.getBody();
            Object Object = new JSONParser().parse(body.prettyPrint());
            response.then().assertThat().statusCode(404);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenGetBookByNameApi_WhenHitApiWithoutBookName_ShouldReturnNotFoundMessage() {
        try {
            Response response=RestAssured.given()
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                    .when()
                    .pathParam("bookName","")
                    .get("/get/{bookName}");
            ResponseBody body = response.getBody();
            Object Object = new JSONParser().parse(body.prettyPrint());
            response.then().assertThat().statusCode(404);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Ignore
    @Test
    public void givenGetBookByNameApi_WhenHitApiWithNumberAsBookName_ShouldReturnNotFoundMessage() {
        try {
            Response response=RestAssured.given()
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                    .when()
                    .pathParam("bookName","1234")
                    .get("/get/{bookName}");
            ResponseBody body = response.getBody();
            Object Object = new JSONParser().parse(body.prettyPrint());
            response.then().assertThat().statusCode(404);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
