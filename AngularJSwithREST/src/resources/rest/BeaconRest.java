package resources.rest;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.BeaconModel;
import orm.Beacon;

@Path("beacon")
public class BeaconRest {
	private BeaconModel bm = new BeaconModel();
	
	//Deep
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Beacon> findAll(){
		return this.bm.findAll();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Beacon findByID(@PathParam ("id") String ID){
		return bm.find(ID);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void create(Beacon beacon){
		this.bm.create(beacon);
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void update(Beacon beacon){
		this.bm.update(beacon);
	}

	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public void delete(@PathParam ("id") String id){
		Beacon beacon = bm.find(id);
		this.bm.delete(beacon);
	}
}
