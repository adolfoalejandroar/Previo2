package com.example.demo.transfers;

import com.example.demo.entities.Pais;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SimplePais {

	public SimplePais(Pais pais) {
		this.id = pais.getId();
		this.nombre = pais.getNombre();
	}
	private Integer id;

	private String nombre;
}
