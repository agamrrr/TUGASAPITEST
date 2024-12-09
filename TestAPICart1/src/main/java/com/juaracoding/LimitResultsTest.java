package com.juaracoding;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class LimitResultsTest {


    static {
        RestAssured.baseURI = "https://fakestoreapi.com";
    }

    @Test
    public void testLimitResults() {
        Response response = given()
                .queryParam("limit", 5)
                .when()
                .get("/products")
                .then()
                .statusCode(200)
                .extract().response();

        int actualSize = response.jsonPath().getList("$").size();
        assertEquals("Limit results to 5 products", 5, actualSize);
    }
}
