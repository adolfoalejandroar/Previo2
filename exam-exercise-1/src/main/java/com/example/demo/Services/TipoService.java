package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Tipo;
import com.example.demo.repositories.TipoRepository;


@Service
public class TipoService {
	
	@Autowired
	TipoRepository repository;
	
	public Tipo get(int id) {
		return repository.findById(id).orElse(null);
	}
	
	// Create or update a Tipo
    public Tipo save(Tipo tipo) {
        return repository.save(tipo);
    }

    // Read a Tipo by ID
    public Tipo findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    // Read all Tipos
    public List<Tipo> findAll() {
        return repository.findAll();
    }

    // Delete a Tipo by ID
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
