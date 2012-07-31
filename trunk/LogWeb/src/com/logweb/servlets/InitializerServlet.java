package com.logweb.servlets;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

/**
 * Servlet implementation class InitializerServlet
 */
@WebServlet( urlPatterns = {"/init"}, loadOnStartup = 1 )
public class InitializerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger LOG = Logger.getLogger("file.general");
	private static final String LOG4J_XML_FILE_PATH = "C:/docs/log4j.xml";
    @Override
    public void init(ServletConfig config) throws ServletException {
    	DOMConfigurator.configure(LOG4J_XML_FILE_PATH);
    	super.init(config);
    }   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InitializerServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOG.debug("This is a get Request");
		LOG.debug("You have requested for " + request.getParameter("id"));
		response.getWriter().println(request.getParameter("id"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
