package com.example.demo.Services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entities.Pais;
import com.example.demo.repositories.PaisRepository;

@Service
public class PaisService {
	
	@Autowired
	PaisRepository repository;
	
    public Pais save(Pais pais) {
        return repository.save(pais);
    }

    public Pais findById(int id) {
        return repository.findById(id).orElse(null);
    }

    public List<Pais> findAll() {
        return repository.findAll();
    }
    
    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
