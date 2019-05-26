package com.salesianostriana.dam.proyectofinal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyectofinal.model.Concierto;
import com.salesianostriana.dam.proyectofinal.repository.ConciertoRepository;

@Service
public class ConciertoService extends BaseService<Concierto, Long, ConciertoRepository> {
	
	@Autowired
	private ConciertoRepository repositorio;

	public Page<Concierto> findAllPageable(Pageable pageable) {
		return repositorio.findAll(pageable);
	}

	public  Page<Concierto> findByNombreContainingIgnoreCasePageable(String nombre, Pageable pageable)
	{
		return repositorio.findByNombreContainingIgnoreCase(nombre, pageable);
	}
	
	

}
