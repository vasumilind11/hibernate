package com.mvmWeb.maplist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.resource.transaction.spi.TransactionStatus;

public class QuestionMain {
	
	  public static Session getCurrentSession()
	  {

		    Configuration cfg = new Configuration();
		    cfg.configure("ques.cfg.xml");
            Session session = cfg.buildSessionFactory().openSession();
	        return session;
	  }
	
      public static int register()
	  {   
		    Session session = getCurrentSession();
		    Transaction t = session.beginTransaction();
		    
		    ArrayList<Answer> list1 = new ArrayList<Answer>();
		    {
			    Answer ans1 = new Answer();
			    ans1.setPostedBy("Milind Jain");
			    ans1.setAnswer("My name is Milind Jain");
			   
			    Answer ans2 = new Answer();
			    ans2.setPostedBy("Ankush Jain");
			    ans2.setAnswer("My name is Ankush Jain");
			   
			    list1.add(ans1);
			    list1.add(ans2);
		    }
		    
		    ArrayList<Answer> list2 = new ArrayList<Answer>();
		    {
			    Answer ans1 = new Answer();
			    ans1.setPostedBy("Milind Jain");
			    ans1.setAnswer("I am Male");
			   
			    Answer ans2 = new Answer();
			    ans2.setPostedBy("Ankush Jain");
			    ans2.setAnswer("I am Male");
			   
			    list2.add(ans1);
			    list2.add(ans2);
		    }
		    
		    
		    Question ques1 = new Question();
		    ques1.setQname("What is Your Name");
		    ques1.setAnsr(list1);
		    
		    Question ques2 = new Question();
		    ques2.setQname("what is your Sex");
		    ques2.setAnsr(list2);
		    
		    session.persist(ques1);
		    session.persist(ques2);
		    
		    t.commit();
		   
		    
		    return 0;
	  }
	 
           public static void fetch()
           {
    	  
        	   Session session = getCurrentSession();
        	   Transaction t = session.beginTransaction();
    	   
        	   Query query = session.createQuery("From Question");
        	   List<Question> list1 = query.list();
        	   Iterator<Question> itr1 = list1.iterator();

        	   while(itr1.hasNext())
        	   {
        		   Question q = itr1.next();
        		   System.out.println(q.getQname());
    		  
        		   List<Answer> list2= q.getAnsr();  
    		  
        		   Iterator<Answer> itr2=list2.iterator();  
        		   while(itr2.hasNext()){ 
            	   
            	   Answer ans = itr2.next();
                   System.out.println(ans.getAnswer()+"\n"+"PostedBy: "+ans.getPostedBy());  
    		   }
    	    
        		   if(t.getStatus().equals(TransactionStatus.ACTIVE)) { 
            	    t.commit();
            	}
               
               session.close();
    	 
           }  
    	   
    	   }

}
