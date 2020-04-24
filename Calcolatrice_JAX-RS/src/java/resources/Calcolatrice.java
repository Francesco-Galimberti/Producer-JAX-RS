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
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Galimberti Francesco
 */
@Path("calculator")
public class Calcolatrice {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of Calcolatrice
     */
    public Calcolatrice() {
    }

    @GET
    @Produces("text/xml")
    @Path("{operation}")
    public String getResult(@PathParam(value = "operation") String operation,
            @QueryParam("X") double x,
            @QueryParam("Y") double y) {

        double r;
        switch (operation) {
            case "+":
                r = x + y;
                break;
            case "-":
                r = x - y;
                break;
            case "*":
                r = x * y;
                break;
            case "/":
                if (y != 0.0) {
                    r = x / y;
                } else {
                    throw new WebApplicationException(400);
                }
                break;
            default:
                throw new WebApplicationException(400);
        }
        return ("<result>" + Double.toString(r) + "</result>");
    }

    /**
     * PUT method for updating or creating an instance of Calcolatrice
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
}
