package com.example.demo.Controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.Services.MangaService;
import com.example.demo.entities.Manga;

@RestController
@RequestMapping("/mangas")
public class MangaController {

	@Autowired
    private MangaService mangaService;

    // 1. Obtener todos los mangas
    // GET /mangas
    @GetMapping
    public ResponseEntity<List<Manga>> getAllMangas() {
        List<Manga> all = mangaService.findAll();
        return ResponseEntity.ok(all);
    }

    // 2. Obtener un manga por ID
    // GET /mangas/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Manga> getMangaById(@PathVariable Integer id) {
        Manga m = mangaService.findById(id);
        if (m == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(m);
    }

    // 3. Crear un nuevo manga
    // POST /mangas
    @PostMapping
    public ResponseEntity<Manga> createManga(@RequestBody Manga manga) {
        Manga created = mangaService.save(manga);
        URI location = URI.create(String.format("/mangas/%d", created.getId()));
        return ResponseEntity.created(location).body(created);
    }

    // 4. Actualizar un manga existente
    // PUT /mangas/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Manga> updateManga(
            @PathVariable Integer id,
            @RequestBody Manga mangaDetails) {

        Manga existing = mangaService.findById(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }

        // Actualizar campos (puedes ajustar según tus necesidades)
        existing.setNombre(mangaDetails.getNombre());
        existing.setFechaLanzamiento(mangaDetails.getFechaLanzamiento());
        existing.setPais(mangaDetails.getPais());
        existing.setAnime(mangaDetails.getAnime());
        existing.setJuego(mangaDetails.getJuego());
        existing.setPelicula(mangaDetails.getPelicula());
        existing.setTipo(mangaDetails.getTipo());

        Manga updated = mangaService.save(existing);
        return ResponseEntity.ok(updated);
    }

    // 5. Eliminar un manga
    // DELETE /mangas/{id}
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
