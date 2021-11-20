package com.example.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Compte {
	
	@Id 
	@GeneratedValue
	private long code;
	private double solde;
	private Date date;
	
	public Compte() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Compte( double solde, Date date) {
		super();
		this.solde = solde;
		this.date = date;
	}
	 
	
	public long getCode() {
		return code;
	}
	public void setCode(long code) {
		this.code = code;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	

	
}
