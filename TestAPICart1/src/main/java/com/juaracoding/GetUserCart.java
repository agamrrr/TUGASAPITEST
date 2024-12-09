package com.juaracoding;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetUserCart {
    static {
        RestAssured.baseURI = "https://fakestoreapi.com";
    }

    @Test
    public void testGetUserCart() {
        Response response = given()
                .when()
                .get("/carts/user/2")
                .then()
                .statusCode(200)
                .extract().response();

        System.out.println(response.getBody().asString());
    }
}
