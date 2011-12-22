/**
 * 
 */
package springapp.service.contacts;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import springapp.domain.Contact;
import springapp.domain.ContactsMapper;

/**
 * @author CHIKI
 *
 */
public class ContactsDAOImpl extends JdbcDaoSupport implements ContactsDAO {
	
	/* (non-Javadoc)
	 * @see springapp.service.contacts.ContactsDAO#addContact(springapp.domain.Contact)
	 */
	@Autowired private DataSource dataSource;
	
	private SimpleJdbcTemplate jdbcTemplate;
	
	
	@Override
	public void addContact(Contact contact) {
		String sql = "INSERT INTO contacts " +
		"(firstname, lastname, email, mobile) VALUES (?, ?, ?,?)";
		
		int status = getJdbcTemplate().update(sql, contact.getFirstname(), contact.getLastname(), contact.getEmail(), contact.getTelephone());
		System.out.println("ContactsDAOImpl.addContact() status " + status);
	}

	@Override
	public List<Contact> listAll() {
		String sql = "select * from contacts";
		
		List<Contact> contacts = getJdbcTemplate().query(sql, new ContactsMapper());
		return contacts;
	}

}
