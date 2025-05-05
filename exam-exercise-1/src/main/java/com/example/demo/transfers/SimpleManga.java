package com.example.demo.transfers;

import java.util.Date;

import com.example.demo.entities.Manga;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SimpleManga {

	public SimpleManga(Manga manga) {
		this.id = manga.getId();
		this.nombre = manga.getNombre();
		this.fechaLanzamiento = manga.getFechaLanzamiento();
		this.pais = new SimplePais(manga.getPais());
		this.tipo = new SimpleTipo(manga.getTipo());
		this.anime = manga.getAnime();
		this.juego = manga.getJuego();
		this.pelicula = manga.getPelicula();
	}
	
	private Integer id;
	
	private String nombre;
	
	private Date fechaLanzamiento;
	
	private SimplePais pais;
	
	private SimpleTipo tipo;
	
	private int anime;
	
	private int juego;
	
	private int pelicula;
}
