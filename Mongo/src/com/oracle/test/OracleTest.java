/**
 * 
 */
package com.oracle.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author CHIKI
 *
 */
public class OracleTest {
	private static Logger LOGGER = Logger.getLogger(OracleTest.class.getName());
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		printRecords();
		LOGGER.log(Level.INFO,"time taken {0} ms", (System.currentTimeMillis() - startTime));
	}
	private static void printRecords(){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.56.101:1521:XE","test","test");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from contacts");
			while (rs.next()) {
				LOGGER.log(Level.INFO,"first name is {0}", rs.getString("firstname"));
				LOGGER.log(Level.INFO,"last name is {0}", rs.getString("lastname"));
				LOGGER.log(Level.INFO,"email is {0}", rs.getString("email"));
				LOGGER.log(Level.INFO,"mobile num is {0} \n", rs.getString("mobile"));
			}
			rs.close();
			st.close();
			con.close();
		} catch (Exception e) {
		}
	}

}
