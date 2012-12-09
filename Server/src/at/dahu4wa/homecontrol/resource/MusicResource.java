package at.dahu4wa.homecontrol.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import at.dahu4wa.homecontrol.maincontrol.HomeControl;
import at.dahu4wa.homecontrol.maincontrol.HomeControlSource;
import at.dahu4wa.homecontrol.model.MediaStatus;

/**
 * Play music with homeControl :) 
 * Useful if you want to play music from your raspberry pi
 * 
 * @author Stefan Huber
 */
@Path("/music")
public class MusicResource {

	private final static HomeControl hc = HomeControlSource.getHomeControl();
	private final static String STREAM_URL = "stream_url";

	@Context
	UriInfo uriInfo;
	@Context
	Request request;

	@GET
	@Path("/{status}")
	@Produces(MediaType.APPLICATION_JSON)
	public MediaStatus getCurrentStatus() {
		return hc.getStreamStatus();
	}

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public MediaStatus postPlug(MultivaluedMap<String, String> params) {
		return hc.setStreamUrl(params.getFirst(STREAM_URL));
	}

//	@GET
//	@Path("/{stop}")
//	@Produces(MediaType.APPLICATION_JSON)
//	public MediaStatus stopPlaying() {
//		return hc.stopPlaying();
//	}
}