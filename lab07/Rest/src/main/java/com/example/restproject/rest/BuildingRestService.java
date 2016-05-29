package com.example.restproject.rest;

import com.example.restproject.domain.Building;
import com.example.restproject.service.BuildingManager;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by Konrad on 30.05.2016.
 */
@Path("building")
public class BuildingRestService {

    private BuildingManager bm = new BuildingManager();

    @GET
    @Path("/{buildingId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Building getPerson(@PathParam("buildingId") Long id){
        Building b  = bm.getBuilding(id);
        return b;
    }

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addBuilding(Building building){
        bm.addBuilding(building);
        return Response.status(201).entity("Building").build();
    }


    @GET
    @Path("/test")
    @Produces(MediaType.TEXT_HTML)
    public String test(){
        return "REST API /Building is running";
    }

    @DELETE
    public Response clearBuildings(){
        bm.clearBuildings();
        return Response.status(200).build();
    }
}
