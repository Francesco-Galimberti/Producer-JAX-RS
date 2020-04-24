/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Galimberti Francesco
 */
@Path("hello")
public class HelloName {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of HelloName
     */
    public HelloName() {
    }

    @GET
    @Produces("text/xml")
    @Path("{name}")
    public String getMessage(@PathParam(value = "name") String name) {
        return "<message>Ciao " + name + "!</message>";
    }

    /**
     * PUT method for updating or creating an instance of HelloName
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
}
