/**
 * 
 */
package com.mongo.test;

import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

/**
 * @author CHIKI
 *
 */
public class MongoTest {
	private static Logger LOGGER = Logger.getLogger(MongoTest.class.getName());
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//192.168.56.101
		long startTime = System.currentTimeMillis();
		printRecords();
		LOGGER.log(Level.INFO,"time taken {0} ms", (System.currentTimeMillis() - startTime));
	}
	private static void printRecords(){
		try {
			Mongo mongo = new Mongo("localhst", 27017);
			DB db = mongo.getDB("test");
			Set<String> colls = db.getCollectionNames();
			for (String s : colls) {
			    System.out.println(s);
			}
			DBCollection coll = db.getCollection("person");
			Iterator<DBObject> records = coll.find().iterator();
			while (records.hasNext()){
				DBObject dbo = records.next();
				//LOGGER.log(Level.INFO,"first name is {0}", dbo.get("id"));
				//LOGGER.log(Level.INFO,"last name is {0}", dbo.get("name"));
				LOGGER.log(Level.INFO,"first name is {0}", dbo.get("firstname"));
				LOGGER.log(Level.INFO,"last name is {0}", dbo.get("lastname"));
				LOGGER.log(Level.INFO,"email is {0}", dbo.get("email"));
				LOGGER.log(Level.INFO,"mobile num is {0} \n", dbo.get("mobile"));
			}
			mongo.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MongoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
