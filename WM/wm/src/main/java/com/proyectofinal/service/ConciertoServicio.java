package com.proyectofinal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.proyectofinal.model.ConciertoModel;
import com.proyectofinal.repository.ConciertoRepository;

@Service
public class ConciertoServicio {

private ConciertoRepository conciertoRepository;
	
	
	public ConciertoServicio(ConciertoRepository repositorio) {
		this.conciertoRepository = repositorio;
	}
	
	
	public ConciertoModel add(ConciertoModel c) {
		return conciertoRepository.save(c);
	}

	public ConciertoModel edit(ConciertoModel c) {
		return conciertoRepository.save(c);
	}

	public void delete(ConciertoModel c) {
		conciertoRepository.delete(c);
	}

	public List<ConciertoModel> findAll() {
		return conciertoRepository.findAll();
	}

	public ConciertoModel findById(long id) {
		return conciertoRepository.findById(id).orElse(null);

}
	
	
}
