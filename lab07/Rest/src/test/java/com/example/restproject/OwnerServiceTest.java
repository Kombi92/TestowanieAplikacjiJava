package com.example.restproject;

import com.example.restproject.domain.Owner;
import com.jayway.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.ws.rs.core.MediaType;

import java.util.ArrayList;
import java.util.List;

import static com.jayway.restassured.RestAssured.delete;
import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * Created by Konrad on 29.05.2016.
 */
public class OwnerServiceTest {
    private static final String OWNER_FIRST_NAME = "Jasiu";
    private static final String SECOND_OWNER_FIRST_NAME = "Stefan";

    @BeforeClass
    public static void setUp(){
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
        RestAssured.basePath = "/restproject/api";
    }

    @Test
    public void addOwner(){

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

    @Test
    public void findOwner(){

        delete("/owner/").then().assertThat().statusCode(200);

        Owner owner = new Owner(1L, OWNER_FIRST_NAME, 1976);
        Owner owner2 = new Owner(2L, OWNER_FIRST_NAME, 1980);
        Owner owner3 = new Owner(3L, SECOND_OWNER_FIRST_NAME, 1990);

        given().
                contentType(MediaType.APPLICATION_JSON).
                body(owner).
                when().
                post("/owner/").then().assertThat().statusCode(201);
        given().
                contentType(MediaType.APPLICATION_JSON).
                body(owner2).
                when().
                post("/owner/").then().assertThat().statusCode(201);
        given().
                contentType(MediaType.APPLICATION_JSON).
                body(owner3).
                when().
                post("/owner/").then().assertThat().statusCode(201);

        List<String> nameList = new ArrayList<>();
        nameList.add(OWNER_FIRST_NAME);
        nameList.add(OWNER_FIRST_NAME);

        given().
                queryParam("name",OWNER_FIRST_NAME).
        when().
                get("/owner/name/Jasiu").
        then().
                statusCode(200).body("owner.firstName",equalTo(nameList));
    }

    @Test
    public void deleteOwner(){

        Owner owner = new Owner(100L, SECOND_OWNER_FIRST_NAME, 1986);

        given().
                contentType(MediaType.APPLICATION_JSON).
                body(owner).
                when().
                post("/owner/").then().assertThat().statusCode(201);

        Owner rOwner = get("/owner/100").as(Owner.class);

        assertThat(SECOND_OWNER_FIRST_NAME, equalToIgnoringCase(rOwner.getFirstName()));

        delete("/owner/100").then().assertThat().statusCode(200);

        rOwner = get("/owner/100").as(Owner.class);

        assertThat(rOwner.getFirstName(), is(nullValue()));

    }

    @Test
    public void updateOwner(){

        delete("/owner/").then().assertThat().statusCode(200);

        Owner owner = new Owner(1L, OWNER_FIRST_NAME, 1976);

        given().
                contentType(MediaType.APPLICATION_JSON).
                body(owner).
                when().
                post("/owner/").then().assertThat().statusCode(201);

        Owner rOwner = get("/owner/1").as(Owner.class);

        assertThat(OWNER_FIRST_NAME, equalToIgnoringCase(rOwner.getFirstName()));

        owner.setFirstName(SECOND_OWNER_FIRST_NAME);

        given().
                contentType(MediaType.APPLICATION_JSON).
                body(owner).
                when().
                put("/owner/").then().assertThat().statusCode(201);

        rOwner = get("/owner/1").as(Owner.class);

        assertThat(SECOND_OWNER_FIRST_NAME, equalToIgnoringCase(rOwner.getFirstName()));
    }
}
