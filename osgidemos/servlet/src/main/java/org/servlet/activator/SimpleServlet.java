/**
 * 
 */
package org.servlet.activator;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author abani
 *
 */
public class SimpleServlet extends HttpServlet {
	private static final Logger LOGGER = Logger.getLogger(SimpleServlet.class.getName());
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		LOGGER.info("invoking doGet()");
		resp.setContentType("text/html");
		resp.getWriter().println("Hi.. I am running inside an OSGi Container");
	}

}
