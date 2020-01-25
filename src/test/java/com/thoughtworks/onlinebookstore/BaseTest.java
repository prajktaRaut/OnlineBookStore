package com.thoughtworks.onlinebookstore;

import io.restassured.RestAssured;
import org.junit.Before;

public class BaseTest {

    @Before
    public void setUp() throws Exception {
        RestAssured.baseURI="http://192.168.0.111:8080/book";
    }

}
