package sh.agilesolutions.quarkus;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/details")
@RegisterRestClient
public interface DetailsServiceClient {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getDetails();
}