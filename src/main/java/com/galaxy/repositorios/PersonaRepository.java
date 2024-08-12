package com.galaxy.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.galaxy.modelos.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long>{

}
