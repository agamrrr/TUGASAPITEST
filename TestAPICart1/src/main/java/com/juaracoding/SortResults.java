package com.juaracoding;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertTrue;

public class SortResults {
    static {
        RestAssured.baseURI = "https://fakestoreapi.com";
    }

    @Test
    public void testSortResults() {
        Response response = given()
                .queryParam("sort", "desc")
                .when()
                .get("/products")
                .then()
                .statusCode(200)
                .extract().response();

        int firstProductId = response.jsonPath().getInt("[0].id");
        int secondProductId = response.jsonPath().getInt("[1].id");

        assertTrue(firstProductId > secondProductId);
    }
}
