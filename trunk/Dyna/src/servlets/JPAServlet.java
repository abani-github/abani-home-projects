package servlets;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Users;

/**
 * Servlet implementation class JPAServlet
 */
@WebServlet({ "/JPAServlet", "/jpa" })
public class JPAServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Dyna") ;
	private EntityManager em = emf.createEntityManager();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JPAServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Query query = em.createQuery("SELECT u from Users u");
		@SuppressWarnings("unchecked")
		List<Users> users = query.getResultList();
		if (null != users) {
			System.out.println("JPAServlet.doGet() " + users.size());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
