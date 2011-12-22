package services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dyna.entities.Family;
import com.dyna.entities.Person;

@Path("/family")
public class FamilyService {
	
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Dyna") ;
	private EntityManager em = emf.createEntityManager();
	
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Family> showFamilies () {
		Query query = em.createQuery("SELECT f from Family f");
		@SuppressWarnings("unchecked")
		List<Family> families =  query.getResultList();
		if (null != families) {
			System.out.println("FamilyService.showMembers() " + families.size());
			for (Family family : families) {
				System.out.println("FamilyService.showMembers() Persons " +family.getId() +" :: "+ family.getMembers().size());
			}
		}
		return families;
	}
	@GET
	@Path("/members")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Person> showMembers () {
		Query query = em.createQuery("SELECT f from Family f");
		@SuppressWarnings("unchecked")
		List<Family> families =  query.getResultList();
		
		List<Person> persons = families.get(1).getMembers();
		if (null != persons) {
			System.out.println("FamilyService.showMembers() " + persons.size());
		}
		return persons;
	}
}
