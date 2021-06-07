package navy.elos.app;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/api")
public class ApiResource {

    @Inject
    KeyValueDbService kvdbsvc;

    @GET
    @Path("/audit")
    @Produces(MediaType.TEXT_PLAIN)
    public String getAudit() {
        return "Hello RESTEasy";
    }

    @Path("/kvp")
    @GET
    public List<KeyValuePair> list() {
        return kvdbsvc.getKeyValueList();
    }

    @Path("/kvp")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void add(KeyValuePair kvp) {
        kvdbsvc.addKeyValuePair(kvp);
    }


}