package com.juaracoding;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Tetsgetallproduct {

    static {
        RestAssured.baseURI = "https://fakestoreapi.com";
    }

    @Test
    public void testGetAllProducts() {
        Response response = given()
                .when()
                .get("/products")
                .then()
                .statusCode(200)
                .extract().response();

        assertTrue("Product list", response.jsonPath().getList("$").size() > 0);
    }
}
