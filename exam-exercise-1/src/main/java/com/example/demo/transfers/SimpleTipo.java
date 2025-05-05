package com.example.demo.transfers;

import com.example.demo.entities.Tipo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SimpleTipo {
	
	public SimpleTipo(Tipo tipo) {
		this.id = tipo.getId();
		this.nombre = tipo.getNombre();
	}
	
	private Integer id;

	private String nombre;
}
