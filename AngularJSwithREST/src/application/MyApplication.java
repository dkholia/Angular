package application;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import resources.rest.BeaconRest;
import resources.rest.ProductRest;

@ApplicationPath("rest")
public class MyApplication extends Application {
	@Override
	public Set<Class<?>> getClasses() {
		//BasicConfigurator.configure();
		Set<Class<?>> resources= new HashSet<Class<?>>();
		addRestResourceClasses(resources);
		return resources;
	}

	private void addRestResourceClasses(Set<Class<?>> resources) {
		resources.add(ProductRest.class);
		resources.add(BeaconRest.class);
	}
}
