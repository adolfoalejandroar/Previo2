package com.example.demo.Services;

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
	
	
}
