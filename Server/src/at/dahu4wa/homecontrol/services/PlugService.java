package at.dahu4wa.homecontrol.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import at.dahu4wa.homecontrol.maincontrol.HomeControl;
import at.dahuawa.homecontrol.model.Plug;

/**
 * The resource to access a plug object over the web
 * 
 * @author Stefan Huber
 */
@Path("/plug")
public class PlugService {

	private final static HomeControl hc = HomeControl.getInstance();

	@Context
	UriInfo uriInfo;
	@Context
	Request request;

	@GET
	@Path("/{plugId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Plug getPlug(@PathParam("plugId") String plugId) {
		return hc.getPlugById(plugId.charAt(0));
	}

	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Plug> getAllPlugs() {
		return hc.getAllPlugs();
	}

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Plug postPlug(MultivaluedMap<String, String> params) {
		return hc.updatePlugStatus(params.getFirst(Plug.ID).charAt(0), params.getFirst(Plug.ENABLED).equals("true") ? true : false);
	}
}