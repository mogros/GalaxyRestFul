package com.galaxy.servicios;

import java.util.List;
import java.util.Optional;

import com.galaxy.modelos.Persona;

public interface PersonaService {

	List<Persona> obtenerTodos();

	Optional<Persona> obtenerPorId(Long id);

	Persona guardar(Persona persona);

	Persona actualizar(Long id, Persona personaActualizado);
	
	void eliminar(Long id);

}
