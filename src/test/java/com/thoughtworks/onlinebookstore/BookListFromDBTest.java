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
            Assert.assertEquals(200,statusCode);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    /*@Test
    public void givenGetBookApi_WhenHitApi_ShouldReturnParticularBookDetails() {
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
            Assert.assertEquals(200,statusCode);
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
            Assert.assertEquals(500,statusCode);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
*/
    @Test
    public void givenGetBookByNameApi_WhenHitApiWithProperBookName_ShouldReturnBookDetails() {
        try {
            Response response=RestAssured.given()
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                    .when()
                    .pathParam("bookName","Angel")
                    .get("/bookByName/{bookName}");
            int statusCode = response.getStatusCode();
            ResponseBody body = response.getBody();
            Object Object = new JSONParser().parse(body.prettyPrint());
            Assert.assertEquals(200,statusCode);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenGetBookByNameApi_WhenHitApiWithWrongBookName_ShouldReturnNotFoundMessage() {
        try {
            Response response=RestAssured.given()
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                    .when()
                    .pathParam("bookName","abcd")
                    .get("/bookByName/{bookName}");
            int statusCode = response.getStatusCode();
            ResponseBody body = response.getBody();
            Object Object = new JSONParser().parse(body.prettyPrint());
            Assert.assertEquals(404,statusCode);
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
                    .get("/bookByName/{bookName}");
            int statusCode = response.getStatusCode();
            ResponseBody body = response.getBody();
            Object Object = new JSONParser().parse(body.prettyPrint());
            Assert.assertEquals(404,statusCode);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenGetBookByNameApi_WhenHitApiWithNumberAsBookName_ShouldReturnNotFoundMessage() {
        try {
            Response response=RestAssured.given()
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                    .when()
                    .pathParam("bookName","1234")
                    .get("/bookByName/{bookName}");
            int statusCode = response.getStatusCode();
            ResponseBody body = response.getBody();
            Object Object = new JSONParser().parse(body.prettyPrint());
            Assert.assertEquals(404,statusCode);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
