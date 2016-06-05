package com.example.restproject.restTests;

import com.example.restproject.domain.Building;
import com.example.restproject.domain.Owner;
import com.jayway.restassured.RestAssured;
import org.apache.commons.lang3.ObjectUtils;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.ws.rs.core.MediaType;

import static com.jayway.restassured.RestAssured.delete;
import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.RestAssured.put;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.Matchers.is;

/**
 * Created by Konrad on 29.05.2016.
 */
public class BuildingServiceTest {
    private static final String BUILDING_NAME = "Drapacz";
    private static final int BUILDING_FLOORAREA = 150;
    private static final String SECOND_BUILDING_NAME = "Kopacz";
    private static final int SECOND_BUILDING_FLOORAREA = 250;

    private static final String OWNER_FIRST_NAME = "Jasiu";

    @BeforeClass
    public static void setUp(){
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
        RestAssured.basePath = "/restproject/api";
    }

    @Test
    public void addBuilding(){

        delete("/building/").then().assertThat().statusCode(200);
        delete("/owner/").then().assertThat().statusCode(200);

        Owner owner = new Owner(1L, OWNER_FIRST_NAME, 1976);
        Building building = new Building(1L, BUILDING_NAME, BUILDING_FLOORAREA,1L);

        given().
                contentType(MediaType.APPLICATION_JSON).
                body(owner).
                when().
                post("/owner/").then().assertThat().statusCode(201);

        given().
                contentType(MediaType.APPLICATION_JSON).
                body(building).
                when().
                post("/building/").then().assertThat().statusCode(201);

        Building rBuilding = get("/building/1").as(Building.class);

        assertThat(BUILDING_NAME, equalToIgnoringCase(rBuilding.getName()));

    }

    @Test
    public void deleteBuilding(){

        Owner owner = new Owner(100L, OWNER_FIRST_NAME, 1986);
        Building building = new Building(100L, SECOND_BUILDING_NAME, BUILDING_FLOORAREA,100L);

        given().
                contentType(MediaType.APPLICATION_JSON).
                body(owner).
                when().
                post("/owner/").then().assertThat().statusCode(201);

        given().
                contentType(MediaType.APPLICATION_JSON).
                body(building).
                when().
                post("/building/").then().assertThat().statusCode(201);

        Building rBuilding = get("/building/100").as(Building.class);

        assertThat(SECOND_BUILDING_NAME, equalToIgnoringCase(rBuilding.getName()));

        delete("/building/100").then().assertThat().statusCode(200);

        rBuilding = get("/building/100").as(Building.class);

        assertThat(rBuilding.getName(), is(nullValue())); //TODO: Make it work in owner

    }

    @Test
    public void updateOwner(){

        delete("/building/").then().assertThat().statusCode(200);

        Building building = new Building(1L,BUILDING_NAME,BUILDING_FLOORAREA);

        given().
                contentType(MediaType.APPLICATION_JSON).
                body(building).
                when().
                post("/building/").then().assertThat().statusCode(201);

        Building rBuilding = get("/building/1").as(Building.class);

        assertThat(BUILDING_NAME, equalToIgnoringCase(rBuilding.getName()));
        assertThat(BUILDING_FLOORAREA, is(rBuilding.getFloorArea()));


        building.setFloorArea(SECOND_BUILDING_FLOORAREA);

        given().
                contentType(MediaType.APPLICATION_JSON).
                body(building).
                when().
                put("/building/").then().assertThat().statusCode(201);

        rBuilding = get("/building/1").as(Building.class);

        assertThat(SECOND_BUILDING_FLOORAREA, is(rBuilding.getFloorArea()));
    }
}
