package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Tipo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tipo_id_seq")
    @SequenceGenerator(name = "tipo_id_seq", sequenceName = "tipo_id_seq", allocationSize = 1)
	private Integer id;
	
	private String nombre;
}
