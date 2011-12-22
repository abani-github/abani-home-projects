/**
 * 
 */
package springapp.service.contacts;

import java.util.List;

import springapp.domain.Contact;

/**
 * @author CHIKI
 *
 */
public interface ContactsDAO {
	void addContact(Contact contact);
	List<Contact> listAll();
}
