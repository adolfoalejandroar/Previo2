package com.example.demo.Controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.Services.MangaService;
import com.example.demo.entities.Manga;
import com.example.demo.transfers.SimpleManga;

@RestController
@RequestMapping("/mangas")
public class MangaController {

	@Autowired
	private MangaService mangaService;

	@GetMapping
	public List<SimpleManga> getAllMangas() {
		List<Manga> all = mangaService.findAll();
		List<SimpleManga> simpleMangas = new ArrayList<>();
		for (Manga manga : all) {
			SimpleManga simpleManga = new SimpleManga(manga);
			simpleMangas.add(simpleManga);
		}
		return simpleMangas;
	}

	@GetMapping("/{id}")
	public SimpleManga getMangaById(@PathVariable Integer id) {
		return new SimpleManga(mangaService.findById(id));
	}

	@PostMapping
	public ResponseEntity<Manga> createManga(@RequestBody Manga manga) {
		Manga created = mangaService.save(manga);
		URI location = URI.create(String.format("/mangas/%d", created.getId()));
		return ResponseEntity.created(location).body(created);
	}

	@PutMapping("/{id}")
	public SimpleManga updateManga(@PathVariable Integer id, @RequestBody Manga mangaDetails) {

		Manga existing = mangaService.findById(id);
		
		SimpleManga updated = null;
		
		if (existing != null) {
			if (mangaDetails.getNombre() != null) existing.setNombre(mangaDetails.getNombre());
			if (mangaDetails.getTemporadas() != null) existing.setTemporadas(mangaDetails.getTemporadas());
			if (mangaDetails.getFechaLanzamiento() != null) existing.setFechaLanzamiento(mangaDetails.getFechaLanzamiento());
			if (mangaDetails.getPais() != null) existing.setPais(mangaDetails.getPais());
			if (mangaDetails.getAnime() != null) existing.setAnime(mangaDetails.getAnime());
			if (mangaDetails.getJuego() != null) existing.setJuego(mangaDetails.getJuego());
			if (mangaDetails.getPelicula() != null) existing.setPelicula(mangaDetails.getPelicula());
			if (mangaDetails.getTipo() != null) existing.setTipo(mangaDetails.getTipo());
			updated = new SimpleManga(mangaService.save(existing));
		}
		
		return updated;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteManga(@PathVariable Integer id) {
		Manga existing = mangaService.findById(id);
		if (existing == null) {
			return ResponseEntity.notFound().build();
		}
		mangaService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
