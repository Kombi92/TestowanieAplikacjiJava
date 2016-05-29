package com.example.restproject.rest;

import com.example.restproject.domain.Owner;
import com.example.restproject.service.OwnerManager;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Konrad on 29.05.2016.
 */
@Path("owner")
public class OwnerRESTService{

        private OwnerManager om = new OwnerManager();

        @GET
        @Path("/{ownerId}")
        @Produces(MediaType.APPLICATION_JSON)
        public Owner getOwners(@PathParam("ownerId") Long id){
            Owner o  = om.getOwner(id);
            return o;
        }

        @POST
        @Path("/")
        @Consumes(MediaType.APPLICATION_JSON)
        public Response addOwner(Owner owner){
            om.addOwner(owner);
            return Response.status(201).entity("Owner").build();
        }

        @GET
        @Path("/all")
        @Produces(MediaType.APPLICATION_JSON)
        public List<Owner> getOwners(){
            List<Owner> o  = om.getAllOwners();
            return o;
        }


        @GET
        @Path("/test")
        @Produces(MediaType.TEXT_HTML)
        public String test(){
            return "REST API /owner is running";
        }

        @DELETE
        public Response clearOwners(){
            om.clearOwners();
            return Response.status(200).build();
        }

}
