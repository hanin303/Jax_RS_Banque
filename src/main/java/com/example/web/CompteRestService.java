package com.example.web;

import java.util.List;
import java.util.Optional;

import javax.ws.rs.PathParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.dao.CompteRepository;
import com.example.entities.Compte;

@Component
@Path("/Banque")
public class CompteRestService {
	
	@Autowired
	private CompteRepository CptRep ;

	@GET
	@Path("/Comptes")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Compte> getComptes(){
		return CptRep.findAll();
		
	}
	
	@GET
	@Path("/Compte/{code}")
	@Produces(MediaType.APPLICATION_JSON)
	public Compte getCompte(@PathParam(value= "code") long cd) {
		Optional<Compte> cpt=CptRep.findById(cd);
		if (cpt.isPresent()) { 
			return cpt.get();
		}else throw new RuntimeException("Compte introuvable");
		
	}
	

	@DELETE
	@Path("/deleteCompte/{code}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deletCompte(@PathParam(value = "code")long cd) {
		Optional<Compte> cpt=CptRep.findById(cd);
		if (cpt.isPresent()) { 
			CptRep.deleteById(cd);
	    }else throw new RuntimeException("Compte introuvable on ne peut pas le supprimer");
	}
	
     
    @POST
	@Path("/addCompte")
	@Produces(MediaType.APPLICATION_JSON)
	public Compte Addcompte(@RequestBody Compte compte){
    	Optional<Compte> cpt=CptRep.findById(compte.getCode());
		if (cpt.isPresent() == false) { 
			return CptRep.save(compte);
		}else throw new RuntimeException("Ce compte déjà existe");
	
	}
 
    @PUT
    @Path("/updateCompte/{code}")
	@Produces(MediaType.APPLICATION_JSON)
    public Compte EditCompte(@PathParam(value = "code") Long code,
    						 @RequestBody Compte comptemodif)throws ResourceNotFoundException{
    		
    	Compte cpt=CptRep.findById(code).orElseThrow(()->new ResourceNotFoundException("Ce compte n'existe pas"));
    	
		     cpt.setCode(comptemodif.getCode());
			cpt.setSolde(comptemodif.getSolde());
			cpt.setDate(comptemodif.getDate());
			CptRep.save(cpt);
			
	  	return cpt;
    }
}