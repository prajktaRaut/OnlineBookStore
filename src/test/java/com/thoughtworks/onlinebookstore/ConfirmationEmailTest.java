package com.thoughtworks.onlinebookstore;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class ConfirmationEmailTest extends BaseTest {

    @Test
    public void givenApiUnderExecution_WhenUserEntersPersonalDetailsToPurchaseBook_ThenConfirmationOfOrderMailIsSentToUser() throws ParseException {
        Response response= RestAssured.given()
                .contentType(ContentType.JSON)
                .when()
                .body("{" +
                        " \"bookList\": [\n" +
                        "   {\n" +
                        "     \"authorName\": \"mahendra\",\n" +
                        "     \"bookId\": 2,\n" +
                        "     \"bookName\": \"mahendrabook\",\n" +
                        "     \"description\": \"abcd\",\n" +
                        "     \"image\": \"mahendra.png\",\n" +
                        "     \"price\": 100,\n" +
                        "     \"quantity\": 4\n" +
                        "   }\n" +
                        " ],\n" +
                        " \"consumerDto\": {\n" +
                        "   \"address\": \"Pune\",\n" +
                        "   \"country\": \"India\",\n" +
                        "   \"email\": \"hemilturakhia@gmail.com\",\n" +
                        "   \"name\": \"Hemil\",\n" +
                        "   \"pinCode\": \"431001\"\n" +
                        " }\n" +
                        "}")
                .post("/order");
                response.then().assertThat().statusCode(200);
    }


    @Test
    public void givenApiUnderExecution_WhenUserEntersPersonalDetailsToPurchaseBook_ThenPincodeShouldNotContainOtherThan6Numbers() {
            Response response = RestAssured.given()
                    .contentType(ContentType.JSON)
                    //.accept(ContentType.JSON)
                    .when()
                    .body("{" +
                            " \"bookList\": [\n" +
                            "   {\n" +
                            "     \"authorName\": \"mahendra\",\n" +
                            "     \"bookId\": 3,\n" +
                            "     \"bookName\": \"mahendrabook\",\n" +
                            "     \"description\": \"abcd\",\n" +
                            "     \"image\": \"mahendra.src\",\n" +
                            "     \"price\": 100,\n" +
                            "     \"quantity\": 10\n" +
                            "   }\n" +
                            " ],\n" +
                            " \"consumerDto\": {\n" +
                            "   \"address\": \"Pune\",\n" +
                            "   \"country\": \"India\",\n" +
                            "   \"email\": \"hemilturakhia@gmail.com\",\n" +
                            "   \"name\": \"PrajktaRaut\",\n" +
                            "   \"pinCode\": \"43101\"\n" +
                            " }\n" +
                            "}")
                    .post("/order");
            response.then().assertThat().statusCode(400);
    }

    @Test
    public void givenApiUnderExecution_WhenUserEntersPersonalDetailsToPurchaseBook_ThenNameOfTheUserShouldContainNonNullValues() {
        try {
            Response response= RestAssured.given()
                    .contentType(ContentType.JSON)
                    //.accept(ContentType.JSON)
                    .when()
                    .body("{" +
                            " \"bookList\": [\n" +
                            "   {\n" +
                            "     \"authorName\": \"mahendra\",\n" +
                            "     \"bookId\": 53,\n" +
                            "     \"bookName\": \"mahendrabook\",\n" +
                            "     \"description\": \"abcd\",\n" +
                            "     \"image\": \"mahendra.src\",\n" +
                            "     \"price\": 100,\n" +
                            "     \"quantity\": 10\n" +
                            "   }\n" +
                            " ],\n" +
                            " \"consumerDto\": {\n" +
                            "   \"address\": \"Pune11\",\n" +
                            "   \"country\": \"Indiaa\",\n" +
                            "   \"email\": \"hemilturakhia@gmail.com\",\n" +
                            "   \"name\": \"\",\n" +
                            "   \"pinCode\": \"43101\"\n" +
                            " }\n" +
                            "}")
                    .post("/order");
            response.then().assertThat().statusCode(400);
            ResponseBody body = response.getBody();
            Object Object = new JSONParser().parse(body.prettyPrint());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenApiUnderExecution_WhenUserEntersPersonalDetailsToPurchaseBook_ThenAddressOfTheUserShouldContainSomeInput() {
        try {
            Response response= RestAssured.given()
                    .contentType(ContentType.JSON)
                    //.accept(ContentType.JSON)
                    .when()
                    .body("{" +
                            " \"bookList\": [\n" +
                            "   {\n" +
                            "     \"authorName\": \"mahendra\",\n" +
                            "     \"bookId\": 53,\n" +
                            "     \"bookName\": \"mahendrabook\",\n" +
                            "     \"description\": \"abcd\",\n" +
                            "     \"image\": \"mahendra.src\",\n" +
                            "     \"price\": 100,\n" +
                            "     \"quantity\": 10\n" +
                            "   }\n" +
                            " ],\n" +
                            " \"consumerDto\": {\n" +
                            "   \"address\": \"\",\n" +
                            "   \"country\": \"India\",\n" +
                            "   \"email\": \"hemilturakhia@gmail.com\",\n" +
                            "   \"name\": \"PrajktaRaut\",\n" +
                            "   \"pinCode\": \"43101\"\n" +
                            " }\n" +
                            "}")
                    .post("/order");
            response.then().assertThat().statusCode(400);
            ResponseBody body = response.getBody();
            Object Object = new JSONParser().parse(body.prettyPrint());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenApiUnderExecution_WhenUserEntersPersonalDetailsToPurchaseBook_ThenPincodeFieldMustContainNotNullInput() {
        try {
            Response response= RestAssured.given()
                    .contentType(ContentType.JSON)
                    //.accept(ContentType.JSON)
                    .when()
                    .body("{" +
                            " \"bookList\": [\n" +
                            "   {\n" +
                            "     \"authorName\": \"mahendra\",\n" +
                            "     \"bookId\": 53,\n" +
                            "     \"bookName\": \"mahendrabook\",\n" +
                            "     \"description\": \"abcd\",\n" +
                            "     \"image\": \"mahendra.src\",\n" +
                            "     \"price\": 100,\n" +
                            "     \"quantity\": 10\n" +
                            "   }\n" +
                            " ],\n" +
                            " \"consumerDto\": {\n" +
                            "   \"address\": \"Pune\",\n" +
                            "   \"country\": \"India\",\n" +
                            "   \"email\": \"hemilturakhia@gmail.com\",\n" +
                            "   \"name\": \"hemil\",\n" +
                            "   \"pinCode\": \"\"\n" +
                            " }\n" +
                            "}")
                    .post("/order");
            response.then().assertThat().statusCode(400);
            ResponseBody body = response.getBody();
            Object Object = new JSONParser().parse(body.prettyPrint());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenApiUnderExecution_WhenUserEntersPersonalDetailsToPurchaseBook_ThenCountryDetailsShouldNotBeNull() {
        try {
            Response response= RestAssured.given()
                    .contentType(ContentType.JSON)
                    //.accept(ContentType.JSON)
                    .when()
                    .body("{" +
                            " \"bookList\": [\n" +
                            "   {\n" +
                            "     \"authorName\": \"mahendra\",\n" +
                            "     \"bookId\": 53,\n" +
                            "     \"bookName\": \"mahendrabook\",\n" +
                            "     \"description\": \"abcd\",\n" +
                            "     \"image\": \"mahendra.src\",\n" +
                            "     \"price\": 100,\n" +
                            "     \"quantity\": 10\n" +
                            "   }\n" +
                            " ],\n" +
                            " \"consumerDto\": {\n" +
                            "   \"address\": \"Pune\",\n" +
                            "   \"country\": \"\",\n" +
                            "   \"email\": \"hemilturakhia@gmail.com\",\n" +
                            "   \"name\": \"hemil\",\n" +
                            "   \"pinCode\": \"431001\"\n" +
                            " }\n" +
                            "}")
                    .post("/order");
            response.then().assertThat().statusCode(400);
            ResponseBody body = response.getBody();
            Object Object = new JSONParser().parse(body.prettyPrint());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenApiUnderExecution_WhenUserEntersPersonalDetailsToPurchaseBook_ThenEmailFieldMustBeValid() {
        try {
            Response response= RestAssured.given()
                    .contentType(ContentType.JSON)
                    //.accept(ContentType.JSON)
                    .when()
                    .body("{" +
                            " \"bookList\": [\n" +
                            "   {\n" +
                            "     \"authorName\": \"mahendra\",\n" +
                            "     \"bookId\": 53,\n" +
                            "     \"bookName\": \"mahendrabook\",\n" +
                            "     \"description\": \"abcd\",\n" +
                            "     \"image\": \"mahendra.src\",\n" +
                            "     \"price\": 100,\n" +
                            "     \"quantity\": 10\n" +
                            "   }\n" +
                            " ],\n" +
                            " \"consumerDto\": {\n" +
                            "   \"address\": \"Pune\",\n" +
                            "   \"country\": \"India\",\n" +
                            "   \"email\": \"hemilturakhiagmail\",\n" +
                            "   \"name\": \"hemil\",\n" +
                            "   \"pinCode\": \"431001\"\n" +
                            " }\n" +
                            "}")
                    .post("/order");
            response.then().assertThat().statusCode(400);
            ResponseBody body = response.getBody();
            Object Object = new JSONParser().parse(body.prettyPrint());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenApiUnderExecution_WhenUserEntersPersonalDetailsToPurchaseBook_ThenEmailFieldMustHaveNotNullValue() {
        try {
            Response response= RestAssured.given()
                    .contentType(ContentType.JSON)
                    .when()
                    .body("{" +
                            " \"bookList\": [\n" +
                            "   {\n" +
                            "     \"authorName\": \"mahendra\",\n" +
                            "     \"bookId\": 53,\n" +
                            "     \"bookName\": \"mahendrabook\",\n" +
                            "     \"description\": \"abcd\",\n" +
                            "     \"image\": \"mahendra.src\",\n" +
                            "     \"price\": 100,\n" +
                            "     \"quantity\": 10\n" +
                            "   }\n" +
                            " ],\n" +
                            " \"consumerDto\": {\n" +
                            "   \"address\": \"Pune\",\n" +
                            "   \"country\": \"India\",\n" +
                            "   \"email\": \"\",\n" +
                            "   \"name\": \"hemil\",\n" +
                            "   \"pinCode\": \"431001\"\n" +
                            " }\n" +
                            "}")
                    .post("/order");
            response.then().assertThat().statusCode(400);
            ResponseBody body = response.getBody();
            Object Object = new JSONParser().parse(body.prettyPrint());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void givenApiUnderExecution_WhenUserEntersPersonalDetailsToPurchaseBook_ThenNameFieldMustContainOnlyAlphabests() {
        try {
            Response response= RestAssured.given()
                    .contentType(ContentType.JSON)
                    .when()
                    .body("{" +
                            " \"bookList\": [\n" +
                            "   {\n" +
                            "     \"authorName\": \"mahendra\",\n" +
                            "     \"bookId\": 53,\n" +
                            "     \"bookName\": \"mahendrabook\",\n" +
                            "     \"description\": \"abcd\",\n" +
                            "     \"image\": \"mahendra.src\",\n" +
                            "     \"price\": 100,\n" +
                            "     \"quantity\": 10\n" +
                            "   }\n" +
                            " ],\n" +
                            " \"consumerDto\": {\n" +
                            "   \"address\": \"Pune\",\n" +
                            "   \"country\": \"India\",\n" +
                            "   \"email\": \"hemilturakhia@gmail.com\",\n" +
                            "   \"name\": \"hemil1\",\n" +
                            "   \"pinCode\": \"431001\"\n" +
                            " }\n" +
                            "}")
                    .post("/order");
            response.then().assertThat().statusCode(400);
            ResponseBody body = response.getBody();
            Object Object = new JSONParser().parse(body.prettyPrint());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
