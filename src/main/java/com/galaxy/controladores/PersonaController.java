package com.galaxy.controladores;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.galaxy.modelos.Persona;
import com.galaxy.servicios.PersonaServiceImpl;

@RestController			//identificar q es servicio rest
@RequestMapping("/api/v1")
public class PersonaController {

	@Autowired
	private PersonaServiceImpl personaService;

	@GetMapping("/personas")
	public ResponseEntity<List<Persona>> obtenerPersonas(){
		return ResponseEntity.ok(personaService.obtenerTodos());
	}

	//requestbody mandar un JSON
	@PostMapping("/personas")
	public ResponseEntity<Persona> crearPersona(@RequestBody Persona persona){
		return ResponseEntity.ok(personaService.guardar(persona));
	}
	
	@GetMapping("/personas/{id}")
	public ResponseEntity<Persona> obtenerPersona(@PathVariable Long id){
		Optional<Persona> persona= personaService.obtenerPorId(id);
		return persona.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}
	
	@PutMapping("/personas/{id}")
	public ResponseEntity<Persona> actualizarPersona(@PathVariable Long id, @RequestBody Persona personaActualizado){
		return ResponseEntity.ok(personaService.actualizar(id, personaActualizado));
	}
	
	@DeleteMapping("/personas/{id}")
	public ResponseEntity<Void> eliminarPersona(@PathVariable Long id){
		personaService.eliminar(id);
		return ResponseEntity.noContent().build();
	}
	
	
}
