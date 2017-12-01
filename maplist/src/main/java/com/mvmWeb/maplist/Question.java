package com.mvmWeb.maplist;

import java.util.List;
import java.util.Map;

public class Question {
	
	
	private int id;
	private String  qname;
	private Map<String,Answer> answer;
	
	
	public Map<String, Answer> getAnswer() {
		return answer;
	}
	public void setAnswer(Map<String, Answer> answer) {
		this.answer = answer;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQname() {
		return qname;
	}
	public void setQname(String qname) {
		this.qname = qname;
	}
	

}
