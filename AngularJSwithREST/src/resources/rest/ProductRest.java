package resources.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import application.utility.AngularLogger;
import model.ProductModel;
import orm.Product;

@Path("product")
public class ProductRest {
	
	static final Logger logger  =  Logger.getLogger(ProductRest.class.getName());
	private ProductModel  pm = new ProductModel();
	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("/findallxml")
	public List<orm.Product> findAllXML(){
		return this.pm.findAll();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/findalljson")
	public List<orm.Product> findAllJSON(){
		AngularLogger.getLogger(this.getClass()).debug("This is a sample message");
		return this.pm.findAll();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/find/{id}")
	public Product findByID(@PathParam ("id") String ID){
		return pm.find(ID);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/find")
	public List<orm.Product> findByExample(Product product) {
		return (List<orm.Product>) this.pm.findByExample(product);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void create(Product product){
		this.pm.create(product);
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void update(Product product){
		this.pm.update(product);
	}

	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public void delete(@PathParam ("id") String id){
		Product product = pm.find(id);
		this.pm.delete(product);
	}
	
	public static void main(String[] args) {
		ProductRest ws = new ProductRest();
		Product p = ws.pm.find("12345");
		 System.out.println(p);
	}
}

