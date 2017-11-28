package com.mvmWeb.demoTest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmployeeDao {
	 
	    public static int register(Employee emp)
	    {
	    	Configuration config = new Configuration();
	    	config.configure("emp1.cfg.xml");
	    	SessionFactory factory  = config.buildSessionFactory();
	    	Session session = factory.openSession();
     
	    	Transaction trans = session.beginTransaction();
           
	    	
	    	Employee2 emp2 = new Employee2();
	    	emp2.setAddress("jaipur");
	    	emp2.setMobno("78777");
	    	
	    	Employee3 emp3 = new Employee3();
	    	emp3.setSalary(10);
	    	
	    	session.save(emp);
	    	session.save(emp2);
	    	

	    	
	    	trans.commit();
	
	    	session.close();
	    	System.out.println("Succesfully saved");
			return 0;
	}
}
