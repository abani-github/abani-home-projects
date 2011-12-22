package springapp.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ContactsMapper implements RowMapper<Contact> {

	@Override
	public Contact mapRow(ResultSet rs, int arg1) throws SQLException {
		Contact contact = new Contact();
		while (rs.next()){
			contact.setFirstname(rs.getString(""));
		}
		return contact;
	}

	

}
