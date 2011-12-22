package services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import entities.Users;

@Path("/hallo")
public class HalloService {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Dyna") ;
	private EntityManager em = emf.createEntityManager();

	@GET
	@Path("/say")
	@Produces(MediaType.TEXT_HTML)
	public String say(){
		return "hallo";
	}

	@GET
	@Path("/users")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Users> listAll( ){
		Query query = em.createQuery("SELECT u from Users u");
		@SuppressWarnings("unchecked")
		List<Users> users = query.getResultList();
		if (null != users) {
			System.out.println("JPAServlet.doGet() " + users.size());
		}
		return users;
	}
	@GET
	@Path("/users/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public  List<Users> update(@PathParam("id") String id){
		System.out.println("HalloService.update() id" + id);
		Query query = em.createQuery("select u from Users u where u.firstName like :x");
		final String param = "%"+id+"%";
		query.setParameter("x", param); 
		@SuppressWarnings("unchecked")
		List<Users> users = query.getResultList();
		System.out.println("HalloService.update() users "+users);
		return users;
	}
	@GET
	@Path("/user")
	@Produces(MediaType.APPLICATION_JSON)
	public  List<Users> search(@QueryParam("id") String id){
		System.out.println("HalloService.update() id" + id);
		Query query = em.createQuery("select u from Users u where u.firstName like :x");
		final String param = "%"+id+"%";
		query.setParameter("x", param); 
		@SuppressWarnings("unchecked")
		List<Users> users = query.getResultList();
		System.out.println("HalloService.update() users "+users);
		return users;
	}
	@GET
	@Path("/user/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public  Users getUser(@PathParam("id") String id){
		System.out.println("HalloService.getUser() id" + id);
		Query query = em.createQuery("select u from Users u where u.firstName = :x");
		//final String param = "%"+id+"%";
		query.setParameter("x", id); 
		Users users = (Users) query.getSingleResult();
		return users;
	}
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	public String getData(Users user){
		System.out.println("HalloService.getData() called");
		System.out.println("HalloService.getData() user " + user);
		return "data gott";
	}
	@POST
	public String addMessage(String msg){
		System.out.println("HalloService.addMessage() msg " + msg);
		return "data got";
	}
}
