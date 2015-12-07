/**
 * 
 */
package application.utility;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * @author Deep
 *
 */
public class AngularLogger extends Logger {

	public AngularLogger(String name) {
		super(name);
		PropertyConfigurator.configure("log4j.properties");
	}
	
	@Override
	public void debug(Object message) {
		super.debug(message);
	}
}
