package ch.agilesolutions.quarkus;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.keycloak.adapters.springsecurity.client.KeycloakRestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;

@Path("/productpage")
public class ProductpageResource {

	@Inject
	@RestClient
	private ReviewsServiceClient reviewService;

	@Inject
	@RestClient
	private DetailsServiceClient detailsService;
	
    @Value("${details.api.url}")
    private String detailsApiUrl;
	
    @Value("${reviews.api.url}")
    private String reviewsApiUrl;

    @Autowired
	private KeycloakRestTemplate keycloakRestTemplate;

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String hello() {

		ResponseEntity<String[]> details = keycloakRestTemplate.getForEntity(detailsApiUrl, String[].class);

		ResponseEntity<String[]> reviews = keycloakRestTemplate.getForEntity(reviewsApiUrl, String[].class);

		
		return String.format("Product with details : %s reviewed with : %s", details.getBody(), reviews.getBody());
//		return String.format("Product with details : %s reviewed with : %s", detailsService.getDetails(),
//				reviewService.getReviews());
	}
}