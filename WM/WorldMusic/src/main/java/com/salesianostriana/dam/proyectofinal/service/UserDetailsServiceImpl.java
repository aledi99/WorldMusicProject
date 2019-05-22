package com.salesianostriana.dam.proyectofinal.service;


import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyectofinal.model.Usuario;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

UsuarioService usuarioServicio;
	
	public UserDetailsServiceImpl(UsuarioService servicio) {
		this.usuarioServicio = servicio;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Usuario usuario = usuarioServicio.buscarPorEmail(username);
		
		
		UserBuilder userBuilder = null;
		
		if (usuario != null) {
			userBuilder = User.withUsername(usuario.getCorreo());
			userBuilder.disabled(false);
			userBuilder.password(usuario.getContrasenya());
			if (usuario.isUsuarioAdmin()) {
				// Este caso indica que un ADMIN también puede hacer todo lo que hace un USER
				userBuilder.authorities(new SimpleGrantedAuthority("ROLE_USER"), new SimpleGrantedAuthority("ROLE_ADMIN"));				
			} else {
				userBuilder.authorities(new SimpleGrantedAuthority("ROLE_USER"));				
			}
		} else {
			throw new UsernameNotFoundException("Usuario no encontrado");
		}
			
		return userBuilder.build();
		
	}
}
