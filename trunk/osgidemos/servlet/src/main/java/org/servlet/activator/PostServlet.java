/**
 * 
 */
package org.servlet.activator;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author behera
 *
 */
public class PostServlet extends HttpServlet {
	private static final Logger LOGGER = Logger.getLogger(PostServlet.class.getName());
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");
		StringBuilder sb = new StringBuilder();
		sb.append("<form action='osgipost' method='post'>");
		sb.append("Enter Name : <input type='text' name='user' /> <br />");
		sb.append("Enter Name : <input type='submit' value='invoke' />");
		sb.append("</form>");
		resp.getWriter().println(sb.toString());
		resp.getWriter().flush();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");
		String enteredName = req.getParameter("user");
		LOGGER.log(Level.INFO,"You have entered {0} ", enteredName);
		resp.getWriter().println("Hallo ---- ${appRoot}");
		resp.getWriter().println("Hi "+ enteredName + " ... Welcome to OSGi <br />");
		resp.getWriter().println("<a href='osgipost'>try again</a>");
		resp.getWriter().flush();
	}

}
