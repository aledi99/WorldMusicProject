package com.salesianostriana.dam.proyectofinal;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import com.salesianostriana.dam.proyectofinal.service.UsuarioService;

@SpringBootApplication
public class WorldMusicApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorldMusicApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner init(BCryptPasswordEncoder encoder, UsuarioService servicio) {
		return args -> {
			
			
			
			
			
		};
	}

}
