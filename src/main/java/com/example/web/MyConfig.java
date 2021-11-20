package com.example.web;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


//config pour demarrer l'app spring(chnowa bch t7adher avant le demarrage
@Configuration
public class MyConfig {
	
		@Bean
		public ResourceConfig getJersey() {
			ResourceConfig config=new ResourceConfig();
			config.register(CompteRestService.class);
			return config;
		}
		
}
