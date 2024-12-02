package com.project.Lenguajes.repository;

import Modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {


    Usuario findByEmail(String email);
    

    Integer findIdPersonaByEmail(String email);
}
