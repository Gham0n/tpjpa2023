package tp3.taa.web;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;

import jakarta.ws.rs.*;

@Path("/api")
public class SwaggerResource {

    @GET
    public byte[] Get1() {
        try {
            return Files.readAllBytes(FileSystems.getDefault().getPath("src/main/java/webapp/swagger/dist/index.html"));
        } catch (IOException e) {
            return null;
        }
    }

    @GET
    @Path("{path:.*}")
    public byte[] Get(@PathParam("path") String path) {
        try {
            return Files.readAllBytes(FileSystems.getDefault().getPath("src/main/java/webapp/swagger/dist/" + path));
        } catch (IOException e) {
            return null;
        }
    }
}
