package com.juaracoding;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Assert;
import org.junit.Test;
import static io.restassured.RestAssured.given;

public class AddNewCart {
    static {
        RestAssured.baseURI = "https://fakestoreapi.com";
    }

    @Test
    public void AddNewCart() {
        String requestBody = "{\n" +
                "  \"userId\": 1,\n" +
                "  \"products\": [\n" +
                "    {\n" +
                "      \"productId\": 1,\n" +
                "      \"quantity\": 2\n" +
                "    },\n" +
                "    {\n" +
                "      \"productId\": 2,\n" +
                "      \"quantity\": 1\n" +
                "    }\n" +
                "  ]\n" +
                "}";

        int statusCode = given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/carts")
                .then()
                .statusCode(200)
                .extract()
                .statusCode();

        Assert.assertEquals(statusCode, 200);
    }
}
