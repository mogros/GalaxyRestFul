package com.galaxy.modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity	
@Table(name ="persona")
@Data					//ahorra 
@AllArgsConstructor
@NoArgsConstructor
public class Persona {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="nombre", length = 100)
	private String nombre;
	
	@Column(name="apellidos", length = 100)
	private String apellidos;
	
	@Column(name="edad")
	private int edad;

	@Column(name="dirección", length = 50)
	private String dirección;
	
	@Column(name="telefono", length = 50)
	private String telefono;
	
}
