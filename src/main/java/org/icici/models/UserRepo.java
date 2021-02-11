package org.icici.models;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UserRepo {

	
	public void  setData() {
		SessionFactory sessionFactory =  new Configuration().configure().buildSessionFactory();        		
	       
	       Session session =	sessionFactory.openSession();
	       session.beginTransaction();
	       
	       Userdet user= new Userdet();
	       
	       user.setUsername("Sarthak");
	       
	       session.save(user);
	       session.getTransaction().commit();
	       
	       System.out.println(user.getId());
	       session.close();
	
	}
	
}
