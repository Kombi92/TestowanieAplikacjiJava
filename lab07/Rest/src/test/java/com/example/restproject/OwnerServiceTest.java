package com.example.restproject;

import com.example.restproject.domain.Owner;
import com.jayway.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.ws.rs.core.MediaType;

import static com.jayway.restassured.RestAssured.delete;
import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;

/**
 * Created by Konrad on 29.05.2016.
 */
public class OwnerServiceTest {
    private static final String OWNER_FIRST_NAME = "Jasiu";

    @BeforeClass
    public static void setUp(){
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
        RestAssured.basePath = "/restproject/api";
    }

    @Test
    public void addPersons(){

        delete("/owner/").then().assertThat().statusCode(200);

        Owner owner = new Owner(1L, OWNER_FIRST_NAME, 1976);

        given().
                contentType(MediaType.APPLICATION_JSON).
                body(owner).
                when().
                post("/owner/").then().assertThat().statusCode(201);

        Owner rOwner = get("/owner/1").as(Owner.class);

        assertThat(OWNER_FIRST_NAME, equalToIgnoringCase(rOwner.getFirstName()));

    }

}
