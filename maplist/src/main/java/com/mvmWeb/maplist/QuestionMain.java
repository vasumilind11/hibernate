package com.mvmWeb.maplist;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

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
		    
		     HashMap<String,Answer> list1 = new HashMap<String,Answer>();
		    {
			    Answer ans1 = new Answer();
			    ans1.setPostedBy("Milind Jain");
			    ans1.setAnswer("My name is Milind Jain");
			   
			    Answer ans2 = new Answer();
			    ans2.setPostedBy("Ankush Jain");
			    ans2.setAnswer("My name is Ankush Jain");
			   
			    list1.put("1",ans1);
			    list1.put("2",ans2);
		    }
		    
		    HashMap<String,Answer> list2 = new HashMap<String,Answer>();
		    {
			    Answer ans1 = new Answer();
			    ans1.setPostedBy("Milind Jain");
			    ans1.setAnswer("I am Male");
			   
			    Answer ans2 = new Answer();
			    ans2.setPostedBy("Ankush Jain");
			    ans2.setAnswer("I am Male");
			   
			    list2.put("1",ans1);
			    list2.put("2",ans2);
		    }
		    
		    
		    Question ques1 = new Question();
		    ques1.setQname("What is Your Name");
		    ques1.setAnswer(list1);
		    
		    Question ques2 = new Question();
		    ques2.setQname("what is your Sex");
		    ques2.setAnswer(list2);
		    
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
        	    
        	   System.out.println(list1.isEmpty());

        	   while(itr1.hasNext())
        	   {
        		   Question q = itr1.next();
        		   System.out.println(q.getQname());
        		   Map<String, Answer> map1= q.getAnswer();
        		   Set<Map.Entry<String,Answer>> entryset = map1.entrySet();
    		  
        		   Iterator<Entry<String, Answer>> entry = entryset.iterator();
        		   while(entry.hasNext())
        		   { 
            	         Entry<String, Answer> ans =  entry.next();
                         System.out.println(ans.getKey()+ ans.getValue().getAnswer() +"\n"+ "PostedBy: "+ans.getKey() + ans.getValue().getPostedBy());  
    		       }
    	    
        		   if(t.getStatus().equals(TransactionStatus.ACTIVE)) { 
            	    t.commit();
            	}
               
               session.close();
    	 
           }  
    	  
    	   }

}
