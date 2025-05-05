package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Usuario;
import com.example.demo.repositories.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    // Create or update a Usuario
    public Usuario save(Usuario usuario) {
        return repository.save(usuario);
    }

    // Read a Usuario by ID
    public Usuario findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    // Read all Usuarios
    public List<Usuario> findAll() {
        return repository.findAll();
    }

    // Delete a Usuario by ID
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
