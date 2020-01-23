//package com.thoughtworks.onlinebookstore;
//
//import io.restassured.RestAssured;
//import io.restassured.http.ContentType;
//import io.restassured.response.Response;
//import io.restassured.response.ResponseBody;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;
//import org.junit.Assert;
//import org.junit.Test;
//
//public class UserDetailsTest extends BaseTest {
//
//    @Test
//    public void givenAddUserDetailsApi_WhenHitApi_ShouldReturnStatusCodeOfSuccess() {
//        try {
//            Response response= RestAssured.given()
//                    .contentType(ContentType.JSON)
//                    //.accept(ContentType.JSON)
//                    .when()
//                    .body("{\"name\" : \"Vedika\" , \"email\" : \"abc123@gmail.com\" ,\"address\" : \"Pune\",\"pinCode\" : \"444106\",\"country\" : \"India\"}")
//                    .post("/addUserDetails");
//            int statusCode = response.getStatusCode();
//            System.out.println("State code is "+statusCode);
//            ResponseBody body = response.getBody();
//            Object Object = new JSONParser().parse(body.prettyPrint());
//            Assert.assertEquals(200,statusCode);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Test
//    public void givenAddUserDetailsApi_WhenHitApiWithInvalidNameValue_ShouldReturnInvalidDetails() {
//        try {
//            Response response= RestAssured.given()
//                    .contentType(ContentType.JSON)
//                    .accept(ContentType.JSON)
//                    .when()
//                    .body("{\"name\" : \"vedika\" , \"email\" : \"abc123@gmail.com\" ,\"address\" : \"Pune\",\"pinCode\" : \"444106\",\"country\" : \"India\"}")
//                    .post("/addUserDetails");
//            int statusCode = response.getStatusCode();
//            System.out.println("State code is "+statusCode);
//            ResponseBody body = response.getBody();
//            JSONObject Object = (JSONObject) new JSONParser().parse(body.prettyPrint());
//            Assert.assertEquals(500,statusCode);
//        } catch (ParseException e) {
//            e.printStackTrace();
//            e.getMessage();
//        }
//    }
//
//    @Test
//    public void givenAddUserDetailsApi_WhenHitApiWithInvalidName_ShouldReturnInvalidDetails() {
//        try {
//            Response response= RestAssured.given()
//                    .contentType(ContentType.JSON)
//                    .accept(ContentType.JSON)
//                    .when()
//                    .body("{\"name\" : \"12345\" , \"email\" : \"abc123@gmail.com\" ,\"address\" : \"Pune\",\"pinCode\" : \"444106\",\"country\" : \"India\"}")
//                    .post("/addUserDetails");
//            int statusCode = response.getStatusCode();
//            System.out.println("State code is "+statusCode);
//            ResponseBody body = response.getBody();
//            JSONObject Object = (JSONObject) new JSONParser().parse(body.prettyPrint());
//            Assert.assertEquals(500,statusCode);
//        } catch (ParseException e) {
//            e.printStackTrace();
//            e.getMessage();
//        }
//    }
//
//    @Test
//    public void givenAddUserDetailsApi_WhenHitApiWithEmptyNameField_ShouldReturnInvalidDetails() {
//        try {
//            Response response= RestAssured.given()
//                    .contentType(ContentType.JSON)
//                    .accept(ContentType.JSON)
//                    .when()
//                    .body("{\"name\" : \" \" , \"email\" : \"abc123@gmail.com\" ,\"address\" : \"Pune\",\"pinCode\" : \"444106\",\"country\" : \"India\"}")
//                    .post("/addUserDetails");
//            int statusCode = response.getStatusCode();
//            System.out.println("State code is "+statusCode);
//            ResponseBody body = response.getBody();
//            JSONObject Object = (JSONObject) new JSONParser().parse(body.prettyPrint());
//            Assert.assertEquals(500,statusCode);
//        } catch (ParseException e) {
//            e.printStackTrace();
//            e.getMessage();
//        }
//    }
//
//    @Test
//    public void givenGetUserDetailsApi_WhenHitApiWithInvalidEmail_ShouldReturnInvalidDetails() {
//        try {
//            Response response= RestAssured.given()
//                    .contentType(ContentType.JSON)
//                    .accept(ContentType.JSON)
//                    .when()
//                    .body("{\"name\" : \"Vedika\" , \"email\" : \"12@gmail.com\" ,\"address\" : \"Pune\",\"pinCode\" : \"444106\",\"country\" : \"India\"}")
//                    .post("/addUserDetails");
//            int statusCode = response.getStatusCode();
//            System.out.println("State code is "+statusCode);
//            ResponseBody body = response.getBody();
//            JSONObject Object = (JSONObject) new JSONParser().parse(body.prettyPrint());
//            Assert.assertEquals(500,statusCode);
//        } catch (ParseException e) {
//            e.printStackTrace();
//            e.getMessage();
//        }
//    }
//
//    @Test
//    public void givenAddUserDetailsApi_WhenHitApiWithEmptyEmailField_ShouldReturnInvalidDetails() {
//        try {
//            Response response= RestAssured.given()
//                    .contentType(ContentType.JSON)
//                    .accept(ContentType.JSON)
//                    .when()
//                    .body("{\"name\" : \"Vedika\" , \"email\" : \" \" ,\"address\" : \"Pune\",\"pinCode\" : \"444106\",\"country\" : \"India\"}")
//                    .post("/addUserDetails");
//            int statusCode = response.getStatusCode();
//            System.out.println("State code is "+statusCode);
//            ResponseBody body = response.getBody();
//            JSONObject Object = (JSONObject) new JSONParser().parse(body.prettyPrint());
//            Assert.assertEquals(500,statusCode);
//        } catch (ParseException e) {
//            e.printStackTrace();
//            e.getMessage();
//        }
//    }
//
//    @Test
//    public void givenAddUserDetailsApi_WhenHitApiWithInvalidEmailAddress_ShouldReturnInvalidDetails() {
//        try {
//            Response response= RestAssured.given()
//                    .contentType(ContentType.JSON)
//                    .accept(ContentType.JSON)
//                    .when()
//                    .body("{\"name\" : \"Vedika\" , \"email\" : \"abc12@gmail..com\" ,\"address\" : \"Pune\",\"pinCode\" : \"444106\",\"country\" : \"India\"}")
//                    .post("/addUserDetails");
//            int statusCode = response.getStatusCode();
//            System.out.println("State code is "+statusCode);
//            ResponseBody body = response.getBody();
//            JSONObject Object = (JSONObject) new JSONParser().parse(body.prettyPrint());
//            Assert.assertEquals(500,statusCode);
//        } catch (ParseException e) {
//            e.printStackTrace();
//            e.getMessage();
//        }
//    }
//
//    @Test
//    public void givenAddUserDetailsApi_WhenHitApiWithInvalidEmailField_ShouldReturnInvalidDetails() {
//        try {
//            Response response= RestAssured.given()
//                    .contentType(ContentType.JSON)
//                    .accept(ContentType.JSON)
//                    .when()
//                    .body("{\"name\" : \"Vedika\" , \"email\" : \"abc12@nuakri\" ,\"address\" : \"Pune\",\"pinCode\" : \"444106\",\"country\" : \"India\"}")
//                    .post("/addUserDetails");
//            int statusCode = response.getStatusCode();
//            System.out.println("State code is "+statusCode);
//            ResponseBody body = response.getBody();
//            JSONObject Object = (JSONObject) new JSONParser().parse(body.prettyPrint());
//            Assert.assertEquals(500,statusCode);
//        } catch (ParseException e) {
//            e.printStackTrace();
//            e.getMessage();
//        }
//    }
//
//    @Test
//    public void givenAddUserDetailsApi_WhenHitApiWithInvalidEmailAddressField_ShouldReturnInvalidDetails() {
//        try {
//            Response response= RestAssured.given()
//                    .contentType(ContentType.JSON)
//                    .accept(ContentType.JSON)
//                    .when()
//                    .body("{\"name\" : \"Vedika\" , \"email\" : \"abc12@gmail.i\" ,\"address\" : \"Pune\",\"pinCode\" : \"444106\",\"country\" : \"India\"}")
//                    .post("/addUserDetails");
//            int statusCode = response.getStatusCode();
//            System.out.println("State code is "+statusCode);
//            ResponseBody body = response.getBody();
//            JSONObject Object = (JSONObject) new JSONParser().parse(body.prettyPrint());
//            Assert.assertEquals(500,statusCode);
//        } catch (ParseException e) {
//            e.printStackTrace();
//            e.getMessage();
//        }
//    }
//
//    @Test
//    public void givenAddUserDetailsApi_WhenHitApiWithInvalidEmail_ShouldReturnInvalidDetails() {
//        try {
//            Response response= RestAssured.given()
//                    .contentType(ContentType.JSON)
//                    .accept(ContentType.JSON)
//                    .when()
//                    .body("{\"name\" : \"Vedika\" , \"email\" : \"abc12gmail.com\" ,\"address\" : \"Pune\",\"pinCode\" : \"444106\",\"country\" : \"India\"}")
//                    .post("/addUserDetails");
//            int statusCode = response.getStatusCode();
//            System.out.println("State code is "+statusCode);
//            ResponseBody body = response.getBody();
//            JSONObject Object = (JSONObject) new JSONParser().parse(body.prettyPrint());
//            Assert.assertEquals(500,statusCode);
//        } catch (ParseException e) {
//            e.printStackTrace();
//            e.getMessage();
//        }
//    }
//
//    @Test
//    public void givenAddUserDetailsApi_WhenHitApiWithEmptyAddressField_ShouldReturnInvalidDetails() {
//        try {
//            Response response = RestAssured.given()
//                    .contentType(ContentType.JSON)
//                    .accept(ContentType.JSON)
//                    .when()
//                    .body("{\"name\" : \"Vedika\" , \"email\" : \"abc12@gmail.com\" ,\"address\" : \" \",\"pinCode\" : \"123456\",\"country\" : \"India\"}")
//                    .post("/addUserDetails");
//            int statusCode = response.getStatusCode();
//            System.out.println("State code is " + statusCode);
//            ResponseBody body = response.getBody();
//            JSONObject Object = (JSONObject) new JSONParser().parse(body.prettyPrint());
//            Assert.assertEquals(500,statusCode);
//        } catch (ParseException e) {
//            e.printStackTrace();
//            e.getMessage();
//        }
//    }
//    @Test
//    public void givenAddUserDetailsApi_WhenHitApiWithInvalidPinCode_ShouldReturnInvalidDetails() {
//        try {
//            Response response= RestAssured.given()
//                    .contentType(ContentType.JSON)
//                    .accept(ContentType.JSON)
//                    .when()
//                    .body("{\"name\" : \"Vedika\" , \"email\" : \"abc12gmail.com\" ,\"address\" : \"Pune\",\"pinCode\" : \"12356766\",\"country\" : \"India\"}")
//                    .post("/addUserDetails");
//            int statusCode = response.getStatusCode();
//            System.out.println("State code is "+statusCode);
//            ResponseBody body = response.getBody();
//            JSONObject Object = (JSONObject) new JSONParser().parse(body.prettyPrint());
//            Assert.assertEquals(500,statusCode);
//        } catch (ParseException e) {
//            e.printStackTrace();
//            e.getMessage();
//        }
//    }
//
//    @Test
//    public void givenAddUserDetailsApi_WhenHitApiWithEmptyPinCodeField_ShouldReturnInvalidDetails() {
//        try {
//            Response response= RestAssured.given()
//                    .contentType(ContentType.JSON)
//                    .accept(ContentType.JSON)
//                    .when()
//                    .body("{\"name\" : \"Vedika\" , \"email\" : \" abc123@gmail.com\" ,\"address\" : \"Pune\",\"pinCode\" : \" \",\"country\" : \"India\"}")
//                    .post("/addUserDetails");
//            int statusCode = response.getStatusCode();
//            System.out.println("State code is "+statusCode);
//            ResponseBody body = response.getBody();
//            JSONObject Object = (JSONObject) new JSONParser().parse(body.prettyPrint());
//            Assert.assertEquals(500,statusCode);
//        } catch (ParseException e) {
//            e.printStackTrace();
//            e.getMessage();
//        }
//    }
//
//    @Test
//    public void givenAddUserDetailsApi_WhenHitApiWithInvalidPinCodeValue_ShouldReturnInvalidDetails() {
//        try {
//            Response response= RestAssured.given()
//                    .contentType(ContentType.JSON)
//                    .accept(ContentType.JSON)
//                    .when()
//                    .body("{\"name\" : \"Vedika\" , \"email\" : \"abc12gmail.com\" ,\"address\" : \"Pune\",\"pinCode\" : \"abcd\",\"country\" : \"India\"}")
//                    .post("/addUserDetails");
//            int statusCode = response.getStatusCode();
//            System.out.println("State code is "+statusCode);
//            ResponseBody body = response.getBody();
//            JSONObject Object = (JSONObject) new JSONParser().parse(body.prettyPrint());
//            Assert.assertEquals(500,statusCode);
//        } catch (ParseException e) {
//            e.printStackTrace();
//            e.getMessage();
//        }
//    }
//
//    @Test
//    public void givenAddUserDetailsApi_WhenHitApiWithInvalidPinCodeFieldValue_ShouldReturnInvalidDetails() {
//        try {
//            Response response = RestAssured.given()
//                    .contentType(ContentType.JSON)
//                    .accept(ContentType.JSON)
//                    .when()
//                    .body("{\"name\" : \"Vedika\" , \"email\" : \"abc12gmail.com\" ,\"address\" : \"Pune\",\"pinCode\" : \"1234\",\"country\" : \"India\"}")
//                    .post("/addUserDetails");
//            int statusCode = response.getStatusCode();
//            System.out.println("State code is " + statusCode);
//            ResponseBody body = response.getBody();
//            JSONObject Object = (JSONObject) new JSONParser().parse(body.prettyPrint());
//            Assert.assertEquals(statusCode, 500);
//        } catch (ParseException e) {
//            e.printStackTrace();
//            e.getMessage();
//        }
//
//    }
//
//    @Test
//    public void givenAddUserDetailsApi_WhenHitApiWithInvalidCountry_ShouldReturnInvalidDetails() {
//        try {
//            Response response = RestAssured.given()
//                    .contentType(ContentType.JSON)
//                    .accept(ContentType.JSON)
//                    .when()
//                    .body("{\"name\" : \"Vedika\" , \"email\" : \"abc12gmail.com\" ,\"address\" : \"Pune\",\"pinCode\" : \"123456\",\"country\" : \"1234\"}")
//                    .post("/addUserDetails");
//            int statusCode = response.getStatusCode();
//            System.out.println("State code is " + statusCode);
//            ResponseBody body = response.getBody();
//            JSONObject Object = (JSONObject) new JSONParser().parse(body.prettyPrint());
//            Assert.assertEquals(500,statusCode);
//        } catch (ParseException e) {
//            e.printStackTrace();
//            e.getMessage();
//        }
//    }
//
//    @Test
//    public void givenAddUserDetailsApi_WhenHitApiWithEmptyCountryField_ShouldReturnInvalidDetails() {
//        try {
//            Response response = RestAssured.given()
//                    .contentType(ContentType.JSON)
//                    .accept(ContentType.JSON)
//                    .when()
//                    .body("{\"name\" : \"Vedika\" , \"email\" : \"abc12gmail.com\" ,\"address\" : \"Pune\",\"pinCode\" : \"123456\",\"country\" : \" \"}")
//                    .post("/addUserDetails");
//            int statusCode = response.getStatusCode();
//            System.out.println("State code is " + statusCode);
//            ResponseBody body = response.getBody();
//            JSONObject Object = (JSONObject) new JSONParser().parse(body.prettyPrint());
//            Assert.assertEquals(500,statusCode);
//        } catch (ParseException e) {
//            e.printStackTrace();
//            e.getMessage();
//        }
//    }
//}
