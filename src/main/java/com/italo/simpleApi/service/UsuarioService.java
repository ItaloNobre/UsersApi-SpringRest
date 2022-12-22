package com.italo.simpleApi.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.italo.simpleApi.exceptions.ObjectNotFoundException;
import com.italo.simpleApi.model.Usuario;
import com.italo.simpleApi.repositories.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository repository;

    public Usuario findById(Long id){
        Optional<Usuario> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto nao encontrado! id: " 
            +id+" Tipo: "+ Usuario.class.getName()));
    }

    public Usuario create(Usuario obj) {
        obj.setId(null);
        return repository.save(obj);
    }

    public List<Usuario> findAll() {
        return repository.findAll();
    }

    public Usuario update(Long id, Usuario obj){
        Usuario newObj = findById(id);
        newObj.setName(obj.getName());
        newObj.setLogin(obj.getLogin());
        newObj.setSenha(obj.getSenha());
        return repository.save(newObj);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

}
