package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Manga;
import com.example.demo.repositories.MangaRepository;

@Service
public class MangaService {

    @Autowired
    private MangaRepository repository;

    // Create or update a Manga
    public Manga save(Manga manga) {
        return repository.save(manga);
    }

    // Read a Manga by ID
    public Manga findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    // Read all Mangas
    public List<Manga> findAll() {
        return repository.findAll();
    }

    // Delete a Manga by ID
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}

