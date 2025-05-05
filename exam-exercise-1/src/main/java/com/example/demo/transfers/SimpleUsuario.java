package com.example.demo.transfers;

import java.util.List;

import com.example.demo.entities.Manga;
import com.example.demo.entities.Usuario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SimpleUsuario {
	
	public SimpleUsuario(Usuario usuario) {
		this.id = usuario.getId();
		this.nombre = usuario.getNombre();
		this.username = usuario.getUsername();
		this.email = usuario.getEmail();
		this.password = usuario.getPassword();
	}
	
	private Integer id;

	private String nombre;

	private String username;

	private String email;

	private String password;
	
	private List<Manga> mangasFavoritos;
}
