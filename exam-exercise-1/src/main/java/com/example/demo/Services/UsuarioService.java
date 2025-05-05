package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entities.Usuario;
import com.example.demo.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;

	// Create or update a Usuario
	public Usuario post(Usuario usuario) {
		return repository.save(usuario);
	}

	// Read a Usuario by ID
	public Usuario getId(Integer id) {
		return repository.findById(id).orElse(null);
	}

	// Read a Usuario by Username
	public Usuario getUserName(String username) {
		return repository.findByUsername(username);
	}

	// Read all Usuarios
	public List<Usuario> findAll() {
		return repository.findAll();
	}

	// Delete a Usuario by ID
	public void deleteById(Integer id) {
		repository.deleteById(id);
	}

	@Transactional
	public void removeFavorito(String username, Integer mangaId) {
		repository.deleteFavoritoByUsernameAndMangaId(username, mangaId);
	}

	@Transactional
	public void addFavorito(String username, Integer mangaId) {
		repository.insertFavoritoByUsernameAndMangaId(username, mangaId);
	}
}
