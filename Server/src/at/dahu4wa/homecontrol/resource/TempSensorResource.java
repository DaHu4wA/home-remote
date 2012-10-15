package at.dahu4wa.homecontrol.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import at.dahu4wa.homecontrol.maincontrol.HomeControl;
import at.dahu4wa.homecontrol.maincontrol.HomeControlGetter;
import at.dahu4wa.homecontrol.model.TempSensor;


@Path("/tempsensor")
public class TempSensorResource {

	private final static HomeControl hc = HomeControlGetter.getHomeControl();

	@Context
	UriInfo uriInfo;
	@Context
	Request request;

	@GET
	@Path("/{tempSensorId}")
	@Produces(MediaType.APPLICATION_JSON)
	public TempSensor getTempSensor(@PathParam("tempSensorId") String tempSensorId) {
		return hc.getTempSensorById(tempSensorId.charAt(0));
	}

	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<TempSensor> getAllTempSensors() {
		return hc.getAllTempSensors();
	}
}