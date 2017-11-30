package com.mvmWeb.maplist;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Question")
public class Question {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="question")
	private String  qname;
	
	@OneToMany(mappedBy="answer",fetch=FetchType.LAZY, cascade= CascadeType.ALL)
	private List<Answer> ansr;
	
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
	public List<Answer> getAnsr() {
		return ansr;
	}
	public void setAnsr(List<Answer> ansr) {
		this.ansr = ansr;
	}
	

}
