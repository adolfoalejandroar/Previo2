package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
		usuarioServ.removeFavorito(username, mangaId);
	}
	
	@PostMapping("/usuarios/{username}/favoritos")
	public void post(@PathVariable String username, @RequestBody Manga manga) {
		usuarioServ.addFavorito(username, manga.getId());
		usuarioServ.post(usuarioServ.getUserName(username));
	}
	
	@PostMapping("/usuarios/{username}/favoritos/{mangaId}")
	public void post(@PathVariable String username, @PathVariable int mangaId) {
		usuarioServ.addFavorito(username, mangaId);
		usuarioServ.post(usuarioServ.getUserName(username));
	}
}
