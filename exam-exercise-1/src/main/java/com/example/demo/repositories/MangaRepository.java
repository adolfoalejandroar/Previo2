package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entities.Manga;

public interface MangaRepository extends JpaRepository<Manga, Integer> {
}
