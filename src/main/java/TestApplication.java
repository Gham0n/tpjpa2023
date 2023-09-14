
import java.util.HashSet;
import java.util.Set;

import io.swagger.v3.jaxrs2.integration.resources.OpenApiResource;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import rest.MedecinResource;
import rest.PatientResource;
import rest.RDVResource;

@ApplicationPath("/")
public class TestApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {

        final Set<Class<?>> clazzes = new HashSet<Class<?>>();

        clazzes.add(OpenApiResource.class);
        clazzes.add(PatientResource.class);
        clazzes.add(MedecinResource.class);
        clazzes.add(RDVResource.class);
        // clazzes.add(AcceptHeaderOpenApiResource.class);

        return clazzes;
    }

}
