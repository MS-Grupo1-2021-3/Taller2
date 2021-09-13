package javeriana.edu.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }
    //myresource/puntouno?name=Carlos
    @GET
    @Path("puntouno")
    @Produces(MediaType.TEXT_PLAIN)
    public String puntouno(@QueryParam("name") String name) {
        return "Hola" + name;
    }
    //myresource/puntodos/Carlos
    @GET
    @Path("puntodos/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public String puntodos(@PathParam("name") String name) {
        return "Hola" + name;
    }
    
}
