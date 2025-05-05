package com.example.demo.entities;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Manga {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "manga_id_seq")
    @SequenceGenerator(name = "manga_id_seq", sequenceName = "manga_id_seq", allocationSize = 1)
	private Integer id;
	
	private String nombre;
	
	private Date fechaLanzamiento;
	
	@ManyToOne
	@JoinColumn(name = "pais_id")
	private Pais pais;
	
	@ManyToOne
	@JoinColumn(name = "tipo_id")
	private Tipo tipo;
	
	private int anime;
	
	private int juego;
	
	private int pelicula;
	
	@ManyToMany
	@JoinTable(name = "favorito",
		joinColumns = @JoinColumn(name = "manga_id"),
		inverseJoinColumns = @JoinColumn(name = "usuario_id")
	)
	private List<Usuario> usuarios;
}
