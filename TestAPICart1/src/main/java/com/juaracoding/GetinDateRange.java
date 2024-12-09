package com.juaracoding;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import static io.restassured.RestAssured.given;


public class GetinDateRange {
    static {
        RestAssured.baseURI = "https://fakestoreapi.com";
    }

    @Test
    public void testGetInDateRange() {
        Response response = given()
                .queryParam("startDate", "2023-01-01")
                .queryParam("endDate", "2023-12-31")
                .when()
                .get("/carts")
                .then()
                .statusCode(200)
                .extract().response();

        Assert.assertTrue(response.jsonPath().getList("$").size() > 0);
    }

}
