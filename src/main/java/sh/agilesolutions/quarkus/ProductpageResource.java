package sh.agilesolutions.quarkus;

import java.net.URI;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/productpage")
public class ProductpageResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
    	
    	URI apiUri = new URI("http://localhost:9080/movieReviewService");
    	ReviewService reviewSvc = RestClientBuilder.newBuilder()
    	            .baseUri(apiUri)
    	            .build(ReviewService.class);
    	return(reviewSvc.getReview());
    }
}