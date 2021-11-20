package com.example;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.dao.CompteRepository;
import com.example.entities.Compte;

@SpringBootApplication
public class Tp21Application  implements CommandLineRunner{

	@Autowired
	CompteRepository CptRep;
	
	public static void main(String[] args) {
		SpringApplication.run(Tp21Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Compte cpt1 = new Compte(100.000,new Date());
		CptRep.save(cpt1);
	}

	

}
