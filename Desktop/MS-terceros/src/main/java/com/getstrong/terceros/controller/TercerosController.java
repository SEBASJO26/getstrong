package com.getstrong.terceros.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.getstrong.terceros.modelo.Terceros;
import com.getstrong.terceros.servicios.TercerosService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/terceros")
public class TercerosController {
	
	@Autowired
	TercerosService service;
	
	@GetMapping("lista")
	public List<Terceros> lista(){
		return service.listarTodo();
	}
	
	@PostMapping("/crear")
	public void create(@RequestBody Terceros terceros) {
		service.crear(terceros);
		
	}
	
	@PutMapping("/editar")
	public ResponseEntity<?> update(@RequestBody Terceros terceros, @PathVariable Long id) {
        try {
            Terceros existTerceros = service.getTercero(id);
            terceros.setId(id);            
            service.crear(terceros);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	
	@DeleteMapping("/eliminar/{id}")
	public void delete(@PathVariable Long id) {
		service.eliminar(id);
	}

}
