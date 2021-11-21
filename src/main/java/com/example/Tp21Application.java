package com.example;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.dao.CompteRepository;
import com.example.entities.Compte;


@SpringBootApplication
public class Tp21Application implements CommandLineRunner{

		
	@Autowired
	CompteRepository CptRep;

	
	public static void main(String[] args) {
		SpringApplication.run(Tp21Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Date date1 = new Date();
		Compte cpt1 = new Compte(100.000,date1);
		CptRep.save(cpt1);
		Date date2 = new Date();
		Compte cpt2 = new Compte(1100.000,date2);
		CptRep.save(cpt2);
		Date date3 = new Date();
		Compte cpt3 = new Compte(2500.000,date3);
		CptRep.save(cpt3);
		Date date4 = new Date();
		Compte cpt4 = new Compte(2300.000,date4);
		CptRep.save(cpt4);
		Date date5 = new Date();
		Compte cpt5 = new Compte(4000.000,date5);
		CptRep.save(cpt5);
		
	}




}
