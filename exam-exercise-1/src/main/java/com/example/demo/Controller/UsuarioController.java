package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.Services.MangaService;
import com.example.demo.Services.UsuarioService;
import com.example.demo.entities.Manga;
import com.example.demo.transfers.SimpleManga;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	UsuarioService usuarioServ;

	// ##########################################################
	// GET Methods
	// ##########################################################

	@GetMapping("/{username}/favoritos")
	public List<SimpleManga> get(@PathVariable String username) {
		List<Manga> mangas = usuarioServ.getUserName(username).getMangasFavoritos();
		List<SimpleManga> simpleMangas = new ArrayList<>();
		for (Manga manga : mangas) {
			SimpleManga simpleManga = new SimpleManga(manga);
			simpleMangas.add(simpleManga);
		}
		return simpleMangas;
		
	}
	
	@DeleteMapping("/usuarios/{username}/favoritos/{mangaId}")
	public void delete(@PathVariable String username, @PathVariable int mangaId) {
		// usuarioServ.deleteMangaFavorito(username, mangaId);
	}

	/*@GetMapping("/list/{id}")
	public Usuario getSeleccion(@PathVariable int id) {
		return usuarioServ.get(id);
	}

	// ##########################################################
	// POST Methods
	// ##########################################################

	@PostMapping("/post/one")
	public void create(@RequestBody Usuario usuario) {
		usuarioServ.post(usuario);
	}

	// ----------------------------------------------------------

	@PostMapping("/post/more")
	public void create(@RequestBody List<Usuario> usuarios) {
		usuarioServ.post(usuarios);
	}

	// ############################################################
	// DELETE Methods
	// ############################################################

	

	// ----------------------------------------------------------

	@DeleteMapping("/del/usuario")
	public void delete(@RequestBody Usuario usuario) {
		usuarioServ.delete(usuario);
	}

	// ----------------------------------------------------------

	@DeleteMapping("/del/all")
	public void delete() {
		usuarioServ.delete();
	}

	// ##########################################################
	// PUT Methods
	// ##########################################################

	@PutMapping("/put/usuario")
	public void update(@RequestBody Usuario usuario) {
		if (usuarioServ.find(usuario.getId())) {
			usuarioServ.put(usuario);
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrada");
		}
	}

	// ##########################################################
	// EXTRA Methods
	// ##########################################################

	@GetMapping("/list/{id}/results")
	public List<Resultado> getCustom1(@PathVariable int id) {
		return usuarioServ.getCustom1(id);
	}*/
}
