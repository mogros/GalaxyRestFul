package com.galaxy.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;


import com.galaxy.modelos.Persona;
import com.galaxy.repositorios.PersonaRepository;

@Service
public class PersonaServiceImpl implements PersonaService {

	@Autowired
	PersonaRepository personaRepository;
	
	@Override
	public List<Persona> obtenerTodos() {
		// TODO Auto-generated method stub
		return personaRepository.findAll();
	}

	@Override
	public Optional<Persona> obtenerPorId(Long id) {
		// TODO Auto-generated method stub
		return personaRepository.findById(id);
	}

	@Override
	public Persona guardar(Persona persona) {
		// TODO Auto-generated method stub
		return personaRepository.save(persona);
	}

	@Override
	public Persona actualizar(Long id, Persona personaActualizado) {
		// TODO Auto-generated method stub
		Persona persona= personaRepository.findById(id).orElseThrow( 
				() -> new ResourceNotFoundException("Persona no Encontrado"));
		persona.setNombre(personaActualizado.getNombre());
		persona.setApellidos(personaActualizado.getApellidos());
		persona.setEdad(personaActualizado.getEdad());
		persona.setDirección(personaActualizado.getDirección());
		persona.setTelefono(personaActualizado.getTelefono());

		return personaRepository.save(persona);
	}

	@Override
	public void eliminar(Long id) {
		personaRepository.deleteById(id);		
	}
	
	

}
