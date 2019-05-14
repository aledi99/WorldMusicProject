package com.proyectofinal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.proyectofinal.model.Categoria;
import com.proyectofinal.model.Concierto;
import com.proyectofinal.repository.CategoriaRepository;
import com.proyectofinal.repository.ConciertoRepository;

@Service
public class ConciertoServicio {

private ConciertoRepository conciertoRepository;
	
	
	public ConciertoServicio(ConciertoRepository repositorio) {
		this.conciertoRepository = repositorio;
	}
	
	
	public Concierto add(Concierto c) {
		return conciertoRepository.save(c);
	}

	public Concierto edit(Concierto c) {
		return conciertoRepository.save(c);
	}

	public void delete(Concierto c) {
		conciertoRepository.delete(c);
	}

	public List<Concierto> findAll() {
		return conciertoRepository.findAll();
	}

	public Concierto findById(long id) {
		return conciertoRepository.findById(id).orElse(null);

}
	
	
}
