package com.getstrong.terceros.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.getstrong.terceros.modelo.Terceros;
import com.getstrong.terceros.repositorio.TercerosRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class TercerosService {
	@Autowired
	private TercerosRepository repo;
	
	public List<Terceros> listarTodo(){
		return repo.findAll();
	}
	
	public void crear(Terceros terceros) {
		repo.save(terceros);
	}
	
	public void eliminar(Long id) {
		repo.deleteById(id);
	}
	
	public Terceros getTercero(Long id) {
		return repo.findById(id).get();
	}

}
