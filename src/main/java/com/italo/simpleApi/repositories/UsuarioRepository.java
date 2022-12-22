package com.italo.simpleApi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.italo.simpleApi.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    
}
