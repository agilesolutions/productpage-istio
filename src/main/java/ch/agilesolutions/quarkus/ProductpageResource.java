package ch.agilesolutions.quarkus;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/productpage")
public class ProductpageResource {

	@Inject
	@RestClient
	private ReviewsServiceClient reviewService;

	@Inject
	@RestClient
	private DetailsServiceClient detailsService;

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String hello() {

		return String.format("Product with details : %s reviewed with : %s", detailsService.getDetails(),
				reviewService.getReviews());
	}
}