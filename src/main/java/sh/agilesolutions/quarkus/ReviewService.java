package sh.agilesolutions.quarkus;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/reviews")
public interface ReviewService {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getReview();
}