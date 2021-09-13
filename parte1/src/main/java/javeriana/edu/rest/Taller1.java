package javeriana.edu.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.Writer;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;

@Path("taller1")
public class Taller1 {
    @GET
    @Path("healthcheck")
    @Produces(MediaType.TEXT_PLAIN)
    public String healthcheck(){
        return "Ok";
    }
    @GET
    @Path("listar")
    @Produces(MediaType.TEXT_PLAIN)
    public String listar() throws IOException {
        File file = new File("src/main/java/javeriana/edu/rest/paseos");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        String paseos = "";
        while ((line = br.readLine()) != null){
            String[] parts = line.split(",");
            if(parts.length >= 3) paseos = paseos + new Paseo(parts[0], parts[1], parts[2]).toString();
        }
        br.close();
        return paseos;
    }
    //taller1/eliminar?id=1
    @GET
    @Path("eliminar")
    @Produces(MediaType.TEXT_PLAIN)
    public String eliminar(@QueryParam("id") String ID) throws IOException {
        File file = new File("src/main/java/javeriana/edu/rest/paseos");
        File tempFile = new File(file.getAbsolutePath() + ".tmp");
        BufferedReader br = new BufferedReader(new FileReader(file));
        PrintWriter pw = new PrintWriter(new FileWriter(tempFile));
        String line;

        while ((line = br.readLine()) != null) {
            if (!line.split(",")[0].equals(ID)) {
                pw.println(line);
                pw.flush();
            }
        }
        pw.close();
        br.close();
        file.delete();
        tempFile.renameTo(file);
        return "Eliminado el paseo con ID: " + ID;
    }
    @POST
    @Path("agregar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String agregar(Paseo paseo) throws IOException {
        Writer output = new BufferedWriter(new FileWriter("src/main/java/javeriana/edu/rest/paseos", true));
        output.append(paseo.getID()+","+paseo.getOrigen()+","+paseo.getDestino()+"\n");
        output.close();
        return "Paseo añadido con exito";
    }
    @POST
    @Path("editar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String editar(Paseo paseo) throws IOException {
        File file = new File("src/main/java/javeriana/edu/rest/paseos");
        File tempFile = new File(file.getAbsolutePath() + ".tmp");
        BufferedReader br = new BufferedReader(new FileReader(file));
        PrintWriter pw = new PrintWriter(new FileWriter(tempFile));
        String line;

        while ((line = br.readLine()) != null) {
            if (!line.split(",")[0].equals(paseo.getID())) {
                pw.println(line);
                pw.flush();
            }
        }
        pw.println(paseo.getID()+","+paseo.getOrigen()+","+paseo.getDestino()+"\n");
        pw.flush();
        pw.close();
        br.close();
        file.delete();
        tempFile.renameTo(file);
        return "Paseo editado con exito";
    }
}
