package com.juaracoding;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetaSingleProduct {

        static {
            RestAssured.baseURI = "https://fakestoreapi.com";
        }

        @Test
        public void testGetSingleProduct() {
            Response response = given()
                    .when()
                    .get("/products/1")
                    .then()
                    .statusCode(200)
                    .extract().response();

            Assert.assertEquals("Product ID should be 1", 1, response.jsonPath().getInt("id"));

        }
    }
