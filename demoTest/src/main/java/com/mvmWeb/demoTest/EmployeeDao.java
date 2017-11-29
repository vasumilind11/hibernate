package com.mvmWeb.demoTest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmployeeDao {
	 
	    public static int register()
	    {
	    	Configuration config = new Configuration();
	    	config.configure("emp1.cfg.xml");
	    	SessionFactory factory  = config.buildSessionFactory();
	    	System.out.println(factory);
	    	Session session = factory.openSession();
     
	    	Transaction trans = session.beginTransaction();
            System.out.println("transcation begin.........");
            
            Employee emp = new Employee();
	    	emp.setAge(20);
	    	emp.setId(78);
	    	emp.setFirstname("Anu");
	    	emp.setLastname("jain");
	    	
            
	    	Employee2 emp2 = new Employee2();
	    	emp2.setAddress("jaipur");
	    	emp2.setMobno("78777");
	    	emp2.setFirstname("Anuj");
	    	emp2.setLastname("jain");
	    	
	    	Employee3 emp3 = new Employee3();
	    	emp3.setSalary(10);
	    	emp3.setFirstname("abhishekh");
	    
	    	session.save(emp);
	   
	        session.save(emp3);
	      
	        trans.commit();
	    	
	    	System.out.println("persistent done");
	    	
     
	        System.out.println("Transcation commited");
            
	        session.close();
	    	System.out.println("Succesfully saved");
			return 0;
	}
}
